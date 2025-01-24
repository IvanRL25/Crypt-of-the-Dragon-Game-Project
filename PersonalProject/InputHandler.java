//package PersonalProject;
/**
 * Handles input from the keyboard which is then used to activate other loops and do things
 * 
 * @author Ivan Lopez
 * @version PersonalProject DungeonCrawlerTest 0.01 Alpha
 * @since 9/26/2023
 * 
 */

import java.awt.event.KeyListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;

public class InputHandler implements KeyListener, FocusListener{

    public boolean[] key = new boolean[68836];

    @Override
    public void focusGained(FocusEvent e) {
     
     //  throw new UnsupportedOperationException("Unimplemented method 'focusGained'");
    }

    @Override
    public void focusLost(FocusEvent e) {
       for( int i = 0; i< key.length;i++){
        key[i] = false;
       }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
       // throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    @Override
    public void keyPressed(KeyEvent e) {
       
        int keyCode = e.getKeyCode();
        if(keyCode > 0 && keyCode < key.length){
          key[keyCode] = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(keyCode >= 0 && keyCode < key.length){
            key[keyCode] = false;
        }
    }

   
    
}
