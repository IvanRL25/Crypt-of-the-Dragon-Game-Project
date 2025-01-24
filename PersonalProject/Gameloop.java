//package PersonalProject;
/**
 * When shallweplay is called the user is prompted to start the loop
 * when Select class is used the variables to determine stats are set
 * 
 * @author Ivan Lopez
 * @version PersonalProject DungeonCrawlerTest 0.01 Alpha
 * @since 9/26/2023
 * 
 */

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;

import java.util.Scanner;

/**
 * Prompts the user to push the enter key to start the gameloop and close the title screen
 */

public class Gameloop{

    static int WIDTH = DungeonCrawlerTest.WIDTH;
    static int HEIGHT = DungeonCrawlerTest.HEIGHT;
     int i = 0;
    
    public void ShallWePlay( Graphics g){

        Scanner keyboard = new Scanner(System.in);
        boolean go = false;
       

        g.setColor(Color.white);
        g.setFont(new Font("Terminus", 1, 18));

        if(Controller.Enter == true){
               go = Controller.Enter;
               i++;
               game.ShowStartScreen = false;
        

        }
        if(i == 0 && go == false){
         
             g.drawString("SHALL WE PLAY A GAME", WIDTH/2-90, (HEIGHT/4)*2+100);
             g.drawString("[ENTER]", WIDTH/2-30, (HEIGHT/4)*2+136);
             for(int y = 0; y<= WIDTH; y +=18){
               g.drawString("*", y, HEIGHT/2);
              }
              
         }

          
        keyboard.close();
    }

/**
*Displays a prompt asking the user for a class selection. Before this each class and its stats are show
*on screen. The differenct class again be shown again if the user prompts 
*/



    static int dex = 0;
    static int intel = 0;
    static int charisma = 0;
    static int Wisdom = 0;
    static int Strength = 0;
    static int constitution = 0;
    static int playerclass = 0;
    static boolean selectionConfirmed = false;
    static String selections = "";
    public static String [] selectionlist = new String[7];
    static int classScroll = 0;
    public static int playerlevel=0;
    
    
    public void SelectClass(Graphics g){


        g.setColor(Color.white);
        g.setFont(new Font("Terminus", 1, 18));
        g.drawString("Select a Class", WIDTH/2-90, (HEIGHT/2)+90);
        for(int y = 0; y<= WIDTH; y +=18){
           g.drawString("*", y, HEIGHT/2);
          }

        g.drawString("Press A to Select Wizard", 25, (HEIGHT/2)+135); 
        g.drawString("Press S to Select Barbarian", 25, (HEIGHT/2)+185); 
        g.drawString("Press D to Select Knight", 300, (HEIGHT/2)+135); 
        g.drawString("Press W to Select Druid", 300, (HEIGHT/2)+185); 
        g.drawString("Press E to Select Bard", 550, (HEIGHT/2)+135); 
       
        if(Controller.A == true){
            selections = "a";
           
        }
         if(Controller.S == true){
            selections = "s";
            
        }
        if(Controller.D == true){
            selections = "d";
            
        }
         if(Controller.W == true){
            selections = "w";
            
        }
         if(Controller.E == true){
            selections = "e";
            
        }
      
        
        playerclass = switch(selections)
        {
            case "a" -> 1;
            case "s"-> 2;
            case "d" -> 3;
            case "w" -> 4;
            case "e"-> 5;
            default -> 0;
        };

        if(playerclass == 1){
            dex = 2;
            intel = 1;
            charisma = 3;
            Wisdom = 2;
            Strength = 1;
            constitution = 1;
        }
        if(playerclass == 2){
            dex = 1;
            intel = 2;
            charisma = 1;
            Wisdom = 2;
            Strength = 3;
            constitution = 1;
        }
        if(playerclass == 3){
            dex = 3;
            intel = 2;
            charisma = 1;
            Wisdom = 1;
            Strength = 2;
            constitution = 2;
        }
        if(playerclass == 4){
            dex = 1;
            intel = 2;
            charisma = 1;
            Wisdom = 3;
            Strength = 1;
            constitution = 2;
        }
        if(playerclass == 5){
            dex = 2;
            intel = 1;
            charisma = 1;
            Wisdom = 2;
            Strength = 1;
            constitution = 3;

        }

        if(selectionConfirmed == false && playerclass != 0 ){
             g.drawString("Press Enter to confirm selection", (WIDTH/2)-155, (HEIGHT/2)+225);
             if(Controller.Enter == true){
                selectionConfirmed = true;
                gatherClassSelection();
                playerlevel = 1;
                PlayerLevelSystem.setExpneeded();
             }  
        }
    
        
        if(selectionConfirmed == true && playerclass != 0){
            game.classSelectionComplete = true;
         
        }
       
    }

/**
 * 
 * prints out the different available classes for the user
 * also allows for the user to scroll through the available classes
 * 
 * @param g
 */


static double scrollSelection = 0.0;
public static int drawClasses(Graphics g ){
    
        g.setColor(Color.white);
        g.setFont(new Font("Terminus", 1, 18));
        String  [] classList = new String[5];
        classList [0] = "Wizard";
        classList[1] = "Barbarian";
        classList[2] = "Knight";
        classList[3] = "Druid";
        classList[4] = "Bard";

        String[][] attributes = new String[5][6];
        
        attributes[0][0]="Dex = 2";
        attributes[0][1]="Int = 1";
        attributes[0][2]="Char = 3";
        attributes[0][3]="Wis = 2";
        attributes[0][4]="Str = 1";
        attributes[0][5]="Const = 2";

        attributes[1][0]="Dex = 1";
        attributes[1][1]="Int = 3";
        attributes[1][2]="Char = 1";
        attributes[1][3]="Wis = 2";
        attributes[1][4]="Str = 3";
        attributes[1][5]="Const = 1";

        attributes[2][0]="Dex = 3";
        attributes[2][1]="Int = 2";
        attributes[2][2]="Char = 1";
        attributes[2][3]="Wis = 1";
        attributes[2][4]="Str = 2";
        attributes[2][5]="Const = 2";

        attributes[3][0]="Dex = 1";
        attributes[3][1]="Int = 2";
        attributes[3][2]="Char = 1";
        attributes[3][3]="Wis = 3";
        attributes[3][4]="Str = 1";
        attributes[3][5]="Const = 2";

        attributes[4][0]="Dex = 2";
        attributes[4][1]="Int = 1";
        attributes[4][2]="Char = 1";
        attributes[4][3]="Wis = 2";
        attributes[4][4]="Str = 1";
        attributes[4][5]="Const = 3";


        if(selectionConfirmed == false){
            
              

            if(Controller.right == true){
                if(classScroll == 4 && Controller.right == true){
                    classScroll = 0;
                }
                else{
                scrollSelection = scrollSelection + (1.0/96.0);
                }
                if(scrollSelection >= 1){
                    classScroll++;
                    scrollSelection = 0.0;
                }
            }
            else if(Controller.left == true){
                if(classScroll == 0 && Controller.left == true){
                    classScroll = 4;
                }
                else
                {
                scrollSelection = scrollSelection - (1.0/96.0);
                }

                if(scrollSelection <= -1){
                    classScroll--;
                    scrollSelection = 0.0;
                }
            }     
            g.drawString(classList[classScroll], WIDTH/2-45, (HEIGHT/2)-200);
            g.setFont(new Font("Terminus", 0, 18));
            g.drawString(attributes[classScroll][0],WIDTH/2-45,(HEIGHT/2)-175);
            g.drawString(attributes[classScroll][1],WIDTH/2-45,(HEIGHT/2)-150);
            g.drawString(attributes[classScroll][2],WIDTH/2-45,(HEIGHT/2)-125);
            g.drawString(attributes[classScroll][3],WIDTH/2-45,(HEIGHT/2)-100);
            g.drawString(attributes[classScroll][4],WIDTH/2-45,(HEIGHT/2)-75);
            g.drawString(attributes[classScroll][5],WIDTH/2-45,(HEIGHT/2)-50);
            g.setFont(new Font("Terminus", 1, 18));

            if(classScroll - 1 == -1 ){
                    g.drawString(classList[4], WIDTH/2-150, (HEIGHT/2)-200);
                g.setFont(new Font("Terminus", 0, 18));
                g.drawString(attributes[4][0],WIDTH/2-150,(HEIGHT/2)-175);
                g.drawString(attributes[4][1],WIDTH/2-150,(HEIGHT/2)-150);
                g.drawString(attributes[4][2],WIDTH/2-150,(HEIGHT/2)-125);
                g.drawString(attributes[4][3],WIDTH/2-150,(HEIGHT/2)-100);
                g.drawString(attributes[4][4],WIDTH/2-150,(HEIGHT/2)-75);
                g.drawString(attributes[4][5],WIDTH/2-150,(HEIGHT/2)-50);
                g.setFont(new Font("Terminus", 1, 18));
                }
            else if(classScroll != 0 ){
                    g.drawString(classList[classScroll-1], WIDTH/2-150, (HEIGHT/2)-200);
                    g.setFont(new Font("Terminus", 0, 18));
                    g.drawString(attributes[classScroll-1][0],WIDTH/2-150,(HEIGHT/2)-175);
                    g.drawString(attributes[classScroll-1][1],WIDTH/2-150,(HEIGHT/2)-150);
                    g.drawString(attributes[classScroll-1][2],WIDTH/2-150,(HEIGHT/2)-125);
                    g.drawString(attributes[classScroll-1][3],WIDTH/2-150,(HEIGHT/2)-100);
                    g.drawString(attributes[classScroll-1][4],WIDTH/2-150,(HEIGHT/2)-75);
                    g.drawString(attributes[classScroll-1][5],WIDTH/2-150,(HEIGHT/2)-50);
                    g.setFont(new Font("Terminus", 1, 18));
                }

            if(classScroll +1 == 5){
                g.drawString(classList[0], WIDTH/2+50, (HEIGHT/2)-200);
                g.setFont(new Font("Terminus", 0, 18));
                g.drawString(attributes[0][0],WIDTH/2+50,(HEIGHT/2)-175);
                g.drawString(attributes[0][1],WIDTH/2+50,(HEIGHT/2)-150);
                g.drawString(attributes[0][2],WIDTH/2+50,(HEIGHT/2)-125);
                g.drawString(attributes[0][3],WIDTH/2+50,(HEIGHT/2)-100);
                g.drawString(attributes[0][4],WIDTH/2+50,(HEIGHT/2)-75);  
                g.drawString(attributes[0][5],WIDTH/2+50,(HEIGHT/2)-50);  
                g.setFont(new Font("Terminus", 1, 18));
                }
            else if(classScroll != 4 ){
                g.drawString(classList[classScroll+1], WIDTH/2+50, (HEIGHT/2)-200);
                g.setFont(new Font("Terminus", 0, 18));
                g.drawString(attributes[classScroll+1][0],WIDTH/2+50,(HEIGHT/2)-175);
                g.drawString(attributes[classScroll+1][1],WIDTH/2+50,(HEIGHT/2)-150);
                g.drawString(attributes[classScroll+1][2],WIDTH/2+50,(HEIGHT/2)-125);
                g.drawString(attributes[classScroll+1][3],WIDTH/2+50,(HEIGHT/2)-100);
                g.drawString(attributes[classScroll+1][4],WIDTH/2+50,(HEIGHT/2)-75);
                g.drawString(attributes[classScroll+1][5],WIDTH/2+50,(HEIGHT/2)-50);
                g.setFont(new Font("Terminus", 1, 18));
                }
                
        }
        return classScroll;
}

/**
 * assigns the values of character class and stats to an array that is carried on and can be used in other class
 * The array makes it easier to keep track of player states.
 * 
 */

public void gatherClassSelection(){

        if( playerclass != 0){

        Integer dex1 = dex;
        Integer intel1 = intel;
        Integer charisma1 = charisma;
        Integer Wisdom1 = Wisdom;
        Integer Strength1 = Strength;
        Integer constitution1 = constitution;

        switch(playerclass){
            case 1 -> selectionlist[0] = "Wizard";
            case 2 -> selectionlist[0] = "Barbarian";
            case 3 -> selectionlist[0] = "Knight";
            case 4 -> selectionlist[0] = "Druid";
            case 5 -> selectionlist[0] = "Bard";
        }
        
        selectionlist[1] =  dex1.toString();
        selectionlist[2] =  intel1.toString();
        selectionlist[3] =  charisma1.toString();
        selectionlist[4] =  Wisdom1.toString();
        selectionlist[5] =  Strength1.toString();
        selectionlist[6] =  constitution1.toString();
        }
    }

   
}
