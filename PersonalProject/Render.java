//package PersonalProject;
/**
 *Creates the data that will be used to render the screen and insert colors into the arrays
 * 
 * @author Ivan Lopez
 * @version PersonalProject DungeonCrawlerTest 0.01 Alpha
 * @since 9/26/2023
 * 
 */

public class Render {
    public final int width;
    public final int height; 
    public final int[] pixels;
/**
 *
 * creates an array that will be filled to color the pixels of the on screen display 
 */
    public Render (int width, int height){
        this.width = width;
        this.height = height;
        pixels = new int[width*height];

    }
/*
 * limits the available pixels to ones that are within the range of the created on screen window
 */
    public void draw(Render render, int xOffs, int yOffs){
        for ( int y = 0; y < render.height; y++){
            int yPix = y + yOffs;
            if (yPix < 0 || yPix >= height){
                continue;
            }
        

            for(int x = 0; x< render.width; x++){
                int xPix = x + xOffs;

            if (xPix < 0 || xPix >= width ){
                continue;
            }    

                int alpha = render.pixels[x+y*render.width];
                if(alpha > 0){
                pixels[xPix + yPix * width] = alpha;
                }

            }
        }
    }
    
}
