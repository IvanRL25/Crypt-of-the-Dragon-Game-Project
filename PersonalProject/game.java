//package PersonalProject;

/**
 * runs the body of the loop when called using the dungeoncrawler class
 * 
 * @author Ivan Lopez
 * @version PersonalProject DungeonCrawlerTest 0.01 Alpha
 * @since 9/26/2023
 * 
 */

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JFrame;


public class game extends Canvas implements Runnable{

    public static final int WIDTH = DungeonCrawlerTest.WIDTH;
    public static final int HEIGHT = DungeonCrawlerTest.HEIGHT;
    public static final String TITLE = "DungeonCrawler Alpha 1.0";
    static boolean star = true;
    private InputHandler input;
    static  JFrame Dungeon;

/**
 * 
 * calls all the other methods and runs them if the use when prompt says they want to 
 * start the frame generation for the game
 * 
 * @param frames
 */
static game game1 = new game();
public static void startScreen(Boolean frames){

        frames = star;

        if(frames == true){

        
       
        Dungeon = new JFrame();
        Dungeon.add(game1);
        Dungeon.setVisible(true);
        Dungeon.setTitle(TITLE);
        Dungeon.setResizable(true);
        Dungeon.setSize(WIDTH, HEIGHT);
        Dungeon.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game1.Display();
        game1.startG();
       
        game1.run();
        game1.stop();
         }
        }

     static Thread thread;
    private boolean running = false;
    private gameTime gameTime;

    private BufferedImage img;


/** 
 * creates the peremiters that are used to create the frame on screen
 *  
 */
    public void Display(){
        Dimension size = new Dimension(WIDTH, HEIGHT);
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        gameTime = new gameTime();
        img = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        input = new InputHandler();
        addFocusListener(input);
        addKeyListener(input);    
        }

    public void startG(){
        if(running) 
        return;
        running = true;
        thread = new Thread(this);
        thread.start();
        }
    public void stop(){
        if(!running)
        return;
        running = false;
        try{
        thread.join();
        }
        catch (Exception e){
                e.printStackTrace();
                System.exit(0);
            }

        }

/** 
 * 
 * creates an FPS counter that is going to be displayed on screen
 * also counts the amount time that the "game" has been running
 */
    public void run(){


            double unprocessedSeconds = 0;
            long previoustime = System.nanoTime();
            double secondsPertick = 1 / 60.0;
    
            boolean ticked = false;
    
            while(running){
               long currentTime = System.nanoTime();
               long PassedTime = currentTime - previoustime;
               previoustime = currentTime;
               unprocessedSeconds +=PassedTime/1000000000.0;

               while(unprocessedSeconds > secondsPertick){
                tick();
                unprocessedSeconds -= secondsPertick;
                ticked = true;
               }
               if(ticked){
                
                try {
                   
                 
                    render();
                  
                    
                    
                } catch (InterruptedException | IOException e) {
                
                    e.printStackTrace();
                }
    
               }
               try {
                render();
            } catch (InterruptedException | IOException e) {
         
                e.printStackTrace();
            }
  
            }
        }



    public void tick(){
            gameTime.tick(input.key);
         }
/**
 * 
 * Renders the frame and what is contained within the array that controls the on screen pixels
 * 
 */    

 static boolean ShowStartScreen = true;
 static boolean classSelectionComplete = false;
 static boolean unbeaten = true;
 static boolean lostfight = false;
 static boolean continueadventure = true;
 static boolean backtoMenu = false;
 BufferStrategy bs;
 
int printdelay = 0;

int lastlevel = 0;
boolean levelupped1 = false;
PauseMenu Menu = new PauseMenu();

 gamePlayLoop attempt1 = new gamePlayLoop();

 static Graphics g;

    private void render() throws InterruptedException, IOException { 
        
       

            if(bs == null ){
               
                createBufferStrategy(2);
                   bs=this.getBufferStrategy();
                     return;
            }
        
            g = bs.getDrawGraphics();
         
            g.drawImage(img, 0 , 0 , WIDTH+10 , HEIGHT+10,null );
     
          
            g.setColor(Color.white);
            g.setFont(new Font("Terminus", 1, 18));
        
  
            
            if(star == true){ 
             Gameloop gameloop = new Gameloop();
          
             borderDraw(g);
            if(backtoMenu == false ){
                runlevel(g, gameloop, backtoMenu);
            }

        if(backtoMenu == true ){
            
       
           Gameloop gameloop2 = new Gameloop();
           Menu = new PauseMenu();
      
           PauseMenu.locationinscroll = 0;
            backtoMenu = false;
            attempt1 = new gamePlayLoop();
            runlevel(g, gameloop2, backtoMenu);
          
           }
          
            }
           
            bs.show();
        
            g.dispose();  
             
    
        }

//displays the main field to the screen and allows for movement and gameplay        
   public void displayscreen(Graphics g, gamePlayLoop attempt2) throws InterruptedException, IOException {
    if( classSelectionComplete == true && ShowStartScreen == false && unbeaten == true && lostfight == false){
         
        attempt2.Mapview(g);

if(attempt2.beatlevels == true){
    unbeaten = false;
}
if(attempt2.Playerlive == false && gamePlayLoop.enemymovement == false){
    lostfight = true;
    
} 
}
   }


// runs the main loop of the game also allows for the game to be restarted through the exit in the pause menu
public void runlevel(Graphics g, Gameloop gameloop, boolean btm) throws InterruptedException, IOException{
    if( ShowStartScreen == true){
        gameloop.ShallWePlay(g);
        }

        if( classSelectionComplete == false && ShowStartScreen == false){
        gameloop.SelectClass(g);
        Gameloop.drawClasses(g);
        }
        if(Controller.Q == true && classSelectionComplete == true && ShowStartScreen == false && gamePlayLoop.enemyEncounter == false){
            
            Menu.pause = true;
         
              } 
              
              
     if(Menu.pause == false && backtoMenu == false){
        displayscreen(g, attempt1);             
      
        if(attempt1.Playerlive == false && gamePlayLoop.enemymovement == false && lostfight == true){
            g.setColor(Color.orange);
           g.drawString("You have lost ",(DungeonCrawlerTest.WIDTH/2)-50,(DungeonCrawlerTest.HEIGHT/2)+50);
         
           }
        if(unbeaten == false && lostfight == false){
            
            if(continueadventure == true ){
                if(levelupped1 == false){
                    lastlevel = attempt1.gameLevel;
                    attempt1 = new gamePlayLoop(attempt1.gameLevel);
                    levelupped1 = true;
            }  
        } 
    }
    
    if(attempt1.gameLevel == lastlevel +1 && lastlevel != 0 && attempt1.gameLevel!= 11){
    
        unbeaten = true;
        levelupped1 = false;
    
        displayscreen(g, attempt1);    
    if(attempt1.Playerlive == false && gamePlayLoop.enemymovement == false && lostfight == true){
        g.setColor(Color.orange);
       g.drawString("You have lost ",(DungeonCrawlerTest.WIDTH/2)-50,(DungeonCrawlerTest.HEIGHT/2)+50);
     
       }
    if(unbeaten == false && lostfight == false){
        if(continueadventure == true ){
            if(levelupped1 == false){
                lastlevel = attempt1.gameLevel;
            attempt1 = new gamePlayLoop(attempt1.gameLevel);
            levelupped1 = true;
          
            } 
        }
    }
}


if(attempt1.gameLevel == 11){
    g.drawString("You ave successfully Beaten all 10 game levels", (DungeonCrawlerTest.WIDTH/2)-175,(DungeonCrawlerTest.HEIGHT/2));
    g.drawString("Thank you for Playing!", (DungeonCrawlerTest.WIDTH/2)-75,(DungeonCrawlerTest.HEIGHT/2)+50);
    }
}                                                       
else if(Menu.pause == true && backtoMenu == false){

    PauseMenu.pausePressed(g, Menu);
    }
}


    
/**
 *
 * draws the outline border for the frame
 *   
 */        
    private void borderDraw(Graphics g){

         g.setColor(Color.white);
            g.setFont(new Font("Terminus", 1, 18));

         for(int i = 0; i<= WIDTH; i +=18){
            g.drawString("*", i, 20);
            }
            for(int i = 20; i<= HEIGHT; i+=18){
             g.drawString("*", 0, i);
            }
            for(int i = 0; i<= WIDTH; i +=18){
            g.drawString("*", i, (HEIGHT-40));
            }
            for(int i = 20; i<= HEIGHT; i +=18){
            g.drawString("*", (WIDTH-25), i);
            }
        }
        
    }
