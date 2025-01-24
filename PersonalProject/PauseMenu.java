import java.awt.Font;
import java.awt.Graphics;

//trying to get a pause menu working that will allow the player to exit or save at anytime and level/ see their stats



public class PauseMenu {
    

    boolean pause = false; 
   static String[] options = new String[4];
   static int[] selection = new int[4];
    static double scroll = 0.0;
    static int locationinscroll = 0;
    static boolean selectedConfirmed = false;
    static double testing = 0.0;
    static boolean backtoMenu = false;
    static boolean showOptions = true;
    
    

    public static void pausePressed(Graphics g, PauseMenu pm) throws InterruptedException{

        options[0] = "Stats";
        options[1] = "Level Up";
        options[2] = "Save";
        options[3] = "Exit";


       if(Controller.four == true){
        pm.pause = false;
       }




        if(backtoMenu == false && pm.pause == true){
        

       
     

       
       

        if(Controller.S == true && selectedConfirmed == false){
        scroll += 1.0/45.0;
        }
        if(Controller.W == true && selectedConfirmed == false){
            scroll -= 1.0/45.0;
        }

        if(scroll >= 1.0){
            if(locationinscroll == 3){
                locationinscroll = 0;
            }
            else locationinscroll++;

            scroll = 0;
        }
        if(scroll <= -1.0){
            if(locationinscroll == 0){
                locationinscroll = 3;
            }
            else locationinscroll--;
            scroll = 0;
        }
        
    if(showOptions == true){
        switch(locationinscroll){
            case 0 ->{ g.setFont( new Font("Terminus", 2, 30));
            g.drawString(options[0], DungeonCrawlerTest.WIDTH/2-250, 250 );
            g.setFont(new Font("Terminus", 1, 18));
            g.drawString(options[1], DungeonCrawlerTest.WIDTH/2-250, 275 );
            g.drawString(options[2], DungeonCrawlerTest.WIDTH/2-250, 300 );
            g.drawString(options[3], DungeonCrawlerTest.WIDTH/2-250, 325 );
            }
            case 1 ->{ 
            g.setFont(new Font("Terminus", 1, 18));
            g.drawString(options[0], DungeonCrawlerTest.WIDTH/2-250, 250 );
            g.setFont( new Font("Terminus", 2, 30));
            g.drawString(options[1], DungeonCrawlerTest.WIDTH/2-250, 275 );
            g.setFont(new Font("Terminus", 1, 18));
            g.drawString(options[2], DungeonCrawlerTest.WIDTH/2-250, 300 );
            g.drawString(options[3], DungeonCrawlerTest.WIDTH/2-250, 325 );
            }
            case 2 ->{ 
            g.setFont(new Font("Terminus", 1, 18));
            g.drawString(options[0], DungeonCrawlerTest.WIDTH/2-250, 250 );
            g.drawString(options[1], DungeonCrawlerTest.WIDTH/2-250, 275 );
            g.setFont( new Font("Terminus", 2, 30));
            g.drawString(options[2], DungeonCrawlerTest.WIDTH/2-250, 300 );
            g.setFont(new Font("Terminus", 1, 18));
            g.drawString(options[3], DungeonCrawlerTest.WIDTH/2-250, 325 );
            }
            case 3 ->{ 
                g.setFont(new Font("Terminus", 1, 18));
            g.drawString(options[0], DungeonCrawlerTest.WIDTH/2-250, 250 );
            g.drawString(options[1], DungeonCrawlerTest.WIDTH/2-250, 275 );
            g.drawString(options[2], DungeonCrawlerTest.WIDTH/2-250, 300 );
            g.setFont( new Font("Terminus", 2, 30));
            g.drawString(options[3], DungeonCrawlerTest.WIDTH/2-250, 325 );
            g.setFont(new Font("Terminus", 1, 18));
            }

        }
        g.setFont(new Font("Terminus", 1, 14));
        g.drawString("Press 2 for choice or 4 to return", DungeonCrawlerTest.WIDTH/2-250, 350);
        g.setFont(new Font("Terminus", 1, 18));
    }
           
        
        makeSelection(locationinscroll,g, backtoMenu);

        }
    }


    static double exitChoice = 0.0;
    static double timeToselect =0.0;
    static String[] toDisplay = new String[7];
    public static int makeSelection(int select, Graphics g, boolean back) throws InterruptedException{

        
        for(int i =0; i <toDisplay.length; i++){
            toDisplay[i] = Gameloop.selectionlist[i];
        }

        if(Controller.two== true && selectedConfirmed == false){
            timeToselect += (1/76.0);
            if(timeToselect >= 1.0 ){
                timeToselect = 0.0;
                selectedConfirmed = true;
            }
        }
      

        if(select == 0 && selectedConfirmed == true){

            showOptions = false;
            //display stats
            if(showOptions == false){
            g.drawString("Current Stats ", DungeonCrawlerTest.WIDTH/2-150, 100);
            g.drawString("Current Player Level: "+ Gameloop.playerlevel, DungeonCrawlerTest.WIDTH/2-150, 125 );
            g.drawString("Class: "+ toDisplay[0], DungeonCrawlerTest.WIDTH/2-150, 150 );
            g.drawString("Dex: "+toDisplay[1], DungeonCrawlerTest.WIDTH/2-150, 175 );
            g.drawString("Int: "+toDisplay[2], DungeonCrawlerTest.WIDTH/2-150, 200 );
            g.drawString("Char: "+toDisplay[3], DungeonCrawlerTest.WIDTH/2-150, 225 );
            g.drawString("Wis: "+ toDisplay[4], DungeonCrawlerTest.WIDTH/2-150, 250 );
            g.drawString("Str: "+toDisplay[5], DungeonCrawlerTest.WIDTH/2-150, 275 );
            g.drawString("Const: "+toDisplay[6], DungeonCrawlerTest.WIDTH/2-150, 300 );
            g.drawString("Press 1 to return to Menu", DungeonCrawlerTest.WIDTH/2-150, 350 );
            }
            
            if(Controller.one == true){
                exitChoice += 1.0/12.0;
            }
            if(Controller.one == false){
                exitChoice = 0;
            }

            if(exitChoice >= 1.0){
                exitChoice = 0.0;
                selectedConfirmed = false;
                showOptions = true;
            }

        }
        else if(select == 1 && selectedConfirmed == true){
            
            showOptions = false;
            if(showOptions == false){
                PlayerLevelSystem.addtostat(selectedConfirmed, g, Gameloop.selectionlist);
                }
                
                g.drawString("Press 1 to return to Menu", DungeonCrawlerTest.WIDTH/2-150, 375 );
         
                if(Controller.one == true){
                    exitChoice += 1.0/12.0;
                }
                if(Controller.one == false){
                    exitChoice = 0;
                }
    
                if(exitChoice >= 1.0){
                    exitChoice = 0.0;
                    selectedConfirmed = false;
                    showOptions = true;
                }
    
           
        }
        else if(select == 2 && selectedConfirmed){
            //save
        
         
        }
        else if(select == 3 && selectedConfirmed ){
            // takes you back to the main menu
            Gameloop.selections = "";
            game.ShowStartScreen = true;
            Gameloop.selectionConfirmed = false;
          game.classSelectionComplete = false;
          Gameloop.playerclass = 0;
          game.backtoMenu = true;
         selectedConfirmed = false;
          PlayerLevelSystem.availablePointIncrease = 0;
       
        }


        return select;
    }



}


