//package PersonalProject;
/**
 *Monitors key presses and outputs data to the inputhandler and controller classes
 * 
 * 
 * 
 * @author Ivan Lopez
 * @version PersonalProject DungeonCrawlerTest 0.01 Alpha
 * @since 9/26/2023
 * 
 */

import java.awt.event.KeyEvent;

public class gameTime {
    public int time;
    public Controller controls;

    public gameTime(){
        controls = new Controller();
    }
    
    public void tick(boolean[] key){
        time+=3;
        boolean doA = key[KeyEvent.VK_A];
        boolean doW = key[KeyEvent.VK_W];
        boolean doS = key[KeyEvent.VK_S];
        boolean doD = key[KeyEvent.VK_D];
        boolean doE = key[KeyEvent.VK_E];
        boolean enterE = key[KeyEvent.VK_ENTER];
        boolean doRight = key[KeyEvent.VK_RIGHT];
        boolean doLeft = key[KeyEvent.VK_LEFT];
        boolean do1 = key[KeyEvent.VK_1];
        boolean do2 = key[KeyEvent.VK_2];
        boolean do3 = key[KeyEvent.VK_3];
        boolean do4 = key[KeyEvent.VK_4];
        boolean do5 = key[KeyEvent.VK_5];
        boolean doCAPS = key[KeyEvent.VK_CAPS_LOCK];
        boolean doQ = key[KeyEvent.VK_Q];

        controls.tick(doA, doW, doS, doD,doE, enterE,doLeft, doRight, do1, do2, do3, do4, do5, doCAPS, doQ);

    }
}
