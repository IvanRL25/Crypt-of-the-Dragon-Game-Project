//package PersonalProject;
/**
 * Player health is generated based on their stats and chosen class
 * 
 * @param: playerlevel
 * 
 */

import java.util.Random;
import java.awt.Graphics;
import java.awt.Color;
import java.text.DecimalFormat;

public class playerHealth {

public static double playerHealth = 0.0;
static double playerhealthbase = 0.0; 
private static DecimalFormat df = new DecimalFormat("#");

    public static double generatePlayerHealth(int plv){
        Random rand = new Random();

        
       playerHealth += rand.nextInt(100)+50;
       if(playerHealth >= 100){
        playerHealth = 100;
       }
        
       playerHealth = playerHealth + 10*(Integer.parseInt(Gameloop.selectionlist[6]));
       playerhealthbase = (playerHealth); 
        return playerHealth;
    }


    
    public static void PlayerHealthBar(double health, Graphics g){
        double healthleft = health/playerhealthbase;
       
          g.setColor(Color.GREEN);
        if(((int) health/10) > 0){
        String [] healthbar = new String[((int)health/10)];
        for(int i =0; i <= ((int)health/10)-1; i++){
        healthbar[i] = "*";
        }

        for(int i =0; i <= ((int)health/10)-1; i++){

        g.drawString("    "+  healthbar[i] +" ",(DungeonCrawlerTest.WIDTH/3-(10*(Integer.parseInt(Gameloop.selectionlist[6])-1)))+((((int)health/20)+1)+i*18),(DungeonCrawlerTest.HEIGHT/2)+77);
         }
        }

        g.drawString(df.format(healthleft*100)+ "% ", DungeonCrawlerTest.WIDTH/3+-25, (DungeonCrawlerTest.HEIGHT/2)+70);
     
    }
}
