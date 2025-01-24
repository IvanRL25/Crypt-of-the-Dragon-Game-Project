//package PersonalProject;
/**
 *Renders an image on the screen in a rotating square
 * 
 * Currently not being used
 * 
 * @author Ivan Lopez
 * @version PersonalProject DungeonCrawlerTest 0.01 Alpha
 * @since 9/26/2023
 * 
 */

import java.util.Random;

public class Screen extends Render{
   
    private Render test;
    public Screen(int width, int height) {
        
        super(width, height);
        Random random = new Random();
        test = new Render(128, 128);
        for (int i = 0; i< 128*128; i++){
            test.pixels[i] = random.nextInt() * (random.nextInt(5)/4);

        }
    }

/**
 * 
 * Renders a moving cube like object
 * 
 */    

    public void render(gameTime gameTime){
        for( int i = 0; i< width*height; i++){
            pixels[i] = 0;
        }
        for(int i = 0; i< 25;i++){
       // int anim = (int) (Math.sin((gameTime.time+i*2)%1000.0/100)*100);
        //int anim2 = (int)(Math.cos((gameTime.time+i*2)%1000.0/100)*100);
       // draw(test,(width-256)/2 + anim ,(height-256)/2 + anim2);
        }
    }
    
}
