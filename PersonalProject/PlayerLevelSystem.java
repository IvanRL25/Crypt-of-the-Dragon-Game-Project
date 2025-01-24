//import PersonalProject.*;
import java.awt.Color;
import java.awt.Graphics;


public class PlayerLevelSystem {
    static double Expneeded;
    static double ExpObtained;
    static double ExpLeft;
    static int availableStatpoints;

// sets the amount of exp need to levelup and gain extra points in a stat
    public static void setExpneeded(){
        Expneeded = (Gameloop.playerlevel * 3.14*10);
    }

    // when you reach a certain amount of xp you level up
    public static void levelUp(Graphics g){
            Gameloop.playerlevel++;
            g.drawString("You leveled up to level: " + Gameloop.playerlevel, DungeonCrawlerTest.WIDTH/2-90, (DungeonCrawlerTest.HEIGHT/2)+90);
            availablePointIncrease += 3;
            setExpneeded();
            ExpObtained = 0;
            setExpneeded();
            availableStatpoints +=3;
    
    }
    //allows you to gain exp when you defeat an enemy
    public static double gainXp(int EL, Graphics g){
        ExpObtained = EL*3.14;
        Expneeded  -= ExpObtained;
        if(ExpObtained >= Expneeded ){
            levelUp(g);
        }
        return ExpObtained;
    }

//prints out your current stat points and allows you to scroll through and select on
// upon selection you can add you level up points to the stat and increase it
    static double hoverover = 1.0;
    static boolean statSelected = false;
    static double timeToselect = 0;
    static int availablePointIncrease = 0;

     public static String[] addtostat(boolean statmenuOpen, Graphics g, String[] statlist) throws InterruptedException{
            int statloc = 0;
            String[] highlightedStats = new String[statlist.length]; 

            highlightedStats[0] = "Class: "+ statlist[0];
            highlightedStats[1] = "Dex: "+ statlist[1];
            highlightedStats[2] = "Int: "+ statlist[2];
            highlightedStats[3] = "Char: "+ statlist[3];
            highlightedStats[4] = "Wis: "+ statlist[4];
            highlightedStats[5] = "Str: "+ statlist[5];
            highlightedStats[6] = "Const: "+ statlist[6];

            g.drawString(highlightedStats[0],  DungeonCrawlerTest.WIDTH/2-150, (DungeonCrawlerTest.HEIGHT/2)-175);
           
            for(int i =1; i< Gameloop.selectionlist.length; i++){
               if((int)hoverover != i){
                   g.setColor(Color.GRAY);
                   g.drawString(highlightedStats[i],  DungeonCrawlerTest.WIDTH/2-150, (DungeonCrawlerTest.HEIGHT/2)-175+(i*25));
                   g.setColor(Color.WHITE);
               }
               else{
               g.drawString(highlightedStats[i],  DungeonCrawlerTest.WIDTH/2-150, (DungeonCrawlerTest.HEIGHT/2)-175+(i*25));
               }
           }
           g.drawString("Available Points: "+availablePointIncrease, DungeonCrawlerTest.WIDTH/2-150, DungeonCrawlerTest.HEIGHT/2+25);
           g.drawString("Press Enter to Upgrade Stat ", DungeonCrawlerTest.WIDTH/2-150, DungeonCrawlerTest.HEIGHT/2+50);
        
        if(statSelected == false){
            if(Controller.W == true &&  hoverover >= 1.0){
                hoverover-= (1/64.0);
            }
            else if(Controller.W == true && hoverover <= 1.0){
                hoverover = (double)highlightedStats.length;
            }
            else if(Controller.S == true && hoverover <= (double)highlightedStats.length){
                hoverover += (1/58.0);
            }
            else if(Controller.S == true && hoverover >= (double)highlightedStats.length){
                hoverover = 1.0;
            }
            if(Controller.Enter == true && statSelected == false){
                timeToselect += (1/64.0);
            }

            if(timeToselect >= 1){
                statSelected = true;
                timeToselect = 0;
                Thread.sleep(10);
            }
         }


         statloc = (int)hoverover;
        if(statSelected == true && availablePointIncrease >0){
            int tempstatloc = highlightedStats[statloc].indexOf(": ");
           String tempStat = highlightedStats[statloc].substring(tempstatloc+1); 
           int changeStat = Integer.parseInt(tempStat.strip());
           changeStat ++;
           availablePointIncrease--;

           Gameloop.selectionlist[statloc] = String.valueOf(changeStat);
           
            statSelected = false;
        }

         return Gameloop.selectionlist;
     }
}
