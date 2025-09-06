//package PersonalProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;


/**
 * 
 * creates the X boundry of the map that is used in the game
 * 
 * @return x value of the map
 */
public class gamePlayLoop {
        static int x = 0;
        static int y = 0;
        int shownX = -100;
        int shownY = -200;
        int playerX = 0;
        int playerY = 0;
        boolean playerMoved = false;
       private double [] playerMovement = new double[4];
        int movementDelay = 0;
        boolean enemySpawned = false;
        static int mapXlength;
        static int mapYlength;
       
        boolean beatlevels = false;
        private ArrayList<EnemyLocation> listofLoc = new ArrayList<>();
         int gameLevel;
        public int getGameLevel() {
            return gameLevel;
        }

        public void setGameLevel(int gameLevel) {
            this.gameLevel = gameLevel;
        }

        int enemies;
        boolean enemyset = false;

         gamePlayLoop(){
            x = mapCreateX();
            y = mapCreateY();
            mapYlength = y;
            mapXlength = x;
            gameLevel = 1;
            enemies = gameLevel*4;
            map = new String[mapXlength][mapYlength];
            for(int jjj =0; jjj< enemies ;jjj++){
                listofLoc.add(new EnemyLocation(mapXlength, mapYlength, this));
               }
        }

        gamePlayLoop(int L){
            x = mapCreateX();
            y = mapCreateY();
            mapYlength = y;
            mapXlength = x;
            this.gameLevel = L+1;
            enemies = gameLevel*4;
            map = new String[mapXlength][mapYlength];
           
            for(int jjj =0; jjj< enemies ;jjj++){
                listofLoc.add(new EnemyLocation(mapXlength, mapYlength, this));
               }
        }
    
        static String [] [] map = new String[mapXlength][mapYlength];
    public static int mapCreateX(){
        Random Random = new Random();
        x = Random.nextInt(10)+5;
        if(x>10){
            x = 10;
        }
       
        return x;
        
    }

/**
 * 
 * randomly generates an int that will be used as the y boundry of the map
 * 
 * @return y value of the map
 */    
    public static int mapCreateY(){
        Random Random = new Random();
        y = Random.nextInt(10)+5;
        if(y>10){
            y = 10;
        }
        return y;
    }

/**
 * 
 * Creates and displays the map that the player moves through when the game is being played
 * If the player lands on the same spot within the map as the enemy, the game calls
 * another method that displays the enemy fight
 * 
 */

 
 double whendisplayed = 0;
 static boolean enemyEncounter = false;
    public void Mapview(Graphics g) throws InterruptedException, IOException {

       if(map != null){
           map[mapXlength-1][mapYlength-1] = "[W]";
           map[(int)playerMovement[0]][(int)playerMovement[1]] = "[ ]";
       }


        g.setFont(new Font("Terminus", 0, 18));
        if(playerMoved == false){
        playerX = 0;
        playerY = (mapYlength/2)-1;
        }
 
  
       
        for(int appearance = 0; appearance<listofLoc.size();appearance++){
            if(playerX == listofLoc.get(appearance).getEnemyX() && playerY == listofLoc.get(appearance).getEnemyY()){
              enemyEncounter =true;
           
            }
            
        }
        if(enemyEncounter == true){
            
            enemyAppears(g);
            if(enemymovement == false){
                 playerTravel(mapXlength, mapYlength, playerMoved);                 // generates the enemies if encountered and then handles player movement once the encounter is over
                playerX = (int)playerMovement[0];
                playerY =(int) playerMovement[1];
                enemyEncounter = false;
            }  
        }
        else {
         
            playerTravel(mapXlength, mapYlength, playerMoved);
            playerX = (int) playerMovement[0];
            playerY =(int) playerMovement[1];
            g.setColor(Color.white);
          
            map[playerX][playerY] = "[X]";                                  // handles player movement throughout the map
            map[mapXlength-1][mapYlength-1] = "[W]";
           
    
           for(int LLL = 0;LLL<listofLoc.size();LLL++){
            listofLoc.get(LLL).displayEnemy(g);
           }

   
       for(int i = 0; i<= mapXlength-1;i++){
            for(int j = 0; j<= mapYlength-1;j++){
                if( map[i][j]== null){
                map [i][j] = "[ ]"; 
                }     
               
                if(listofLoc.isEmpty() && playerX == mapXlength-1 && playerY == mapYlength-1){
                beatlevels = true;
                break;
                }
              
                g.setFont(new Font("Terminus", 0, 18));                                                     // displays the player movement and handles displaying the instructions
                g.drawString("Player = X ",(DungeonCrawlerTest.WIDTH/2)-30,(DungeonCrawlerTest.HEIGHT/2)+50);
                g.drawString("Use WASD for movement",(DungeonCrawlerTest.WIDTH/2)-80,(DungeonCrawlerTest.HEIGHT/2)+75);
                g.drawString("You need "+ (int)PlayerLevelSystem.Expneeded+ " exp to level up", (DungeonCrawlerTest.WIDTH/2)-80,(DungeonCrawlerTest.HEIGHT/2)+125);
                g.drawString("Press Q to access pause menu", (DungeonCrawlerTest.WIDTH/2)-100,(DungeonCrawlerTest.HEIGHT/2)+100);
                if(PlayerLevelSystem.availablePointIncrease != 0){
                    g.drawString("You have "+ PlayerLevelSystem.availablePointIncrease+" stat increase available" , (DungeonCrawlerTest.WIDTH/2)-125,(DungeonCrawlerTest.HEIGHT/2)+150);
                } 
                g.setFont(new Font("Terminus", 1, 25));
              
       
               g.drawString(map[i][j]+" ",DungeonCrawlerTest.WIDTH/2+shownX,(DungeonCrawlerTest.HEIGHT/2)+shownY);
             
                

                shownY += 25;   
                enemymovement = true;
                enemyhealthcreated = false;
            }
            shownX +=25;
            shownY = -200;
        }
        
        enemymovement = true;
       
    }
        shownX = -100;
        playerMoved = true;
    }


/**
 * 
 * Method that enables player movement through the map and limits the player movement to 
 * only certain values
 * 
 * @param int x
 * @param int y
 * @param boolean playermoved
 * @return playermovement
 * 
 */
static double playermoveX = 0;
static double playermoveY = 0;;
private double[] playerTravel(int x, int y, boolean playerMoved){
    
        if(playerMoved == true){
            playerX = (int) playerMovement[0];
            playerY = (int) playerMovement[1];
            playermoveX = playerMovement[2];
            playermoveY = playerMovement[3];

        }


        if(Controller.D == true && playerX <= (x-1)){
            playermoveX = playermoveX + (1.0/56.0);
     
            if(playermoveX >= 1){
            playerX++;
            playermoveX = 0.0;
           
            }
            if(playerX>= (x)){
                playerX = (x-1);
            }
            
        }
        else if(Controller.A == true && playerX != 0){

             playermoveX = playermoveX - (1.0/56.0);
            if(playermoveX <= -1){
            playerX--;
            playermoveX = 0;
          
            }
            if(playerX < 0){
                playerX = 0;
            }
        }


        if(Controller.S == true && playerY <= (y-1)){
            playermoveY = playermoveY + (1.0/56.0);

            if(playermoveY >= 1){
            playerY++;
            playermoveY = 0.0;
           
            }
            if(playerY>= (y)){
                playerY = (y-1);
            }
        }
        else if(Controller.W == true && playerY != 0){
            playermoveY = playermoveY - (1.0/56.0);

            if(playermoveY <= -1){
            playerY--;
            playermoveY = 0.0;
           
            }
             if(playerY < 0){
                playerY = 0;
            }
        }

    playerMovement[0] = playerX;
    playerMovement[1] = playerY;
    playerMovement[2]= playermoveX;
    playerMovement[3]= playermoveY;
    return playerMovement;
}


static int SpawnX = 0;
static int SpawnY =0;




static boolean enemymovement = true;
static int EnemyHealth = 0;
static int EnemyLvl = 0;
static boolean enemyhealthcreated = false;
boolean Playerlive = true;

/**
 * 
 * spawns and displays an enemy if the player lands on the same locatin as the enemy
 * also allows for the player to fight the enemy
 * 
 * @param g
 * @return playermovement and if enemy is defeated
 * 
 */

private static boolean gainedEXP = false;
private static DecimalFormat df = new DecimalFormat("#");
private static double baseEnemyHealthstat = 0;
public boolean enemyAppears(Graphics g) throws InterruptedException, IOException {
  
    Random rand = new Random(5);

   
    if(EnemyLvl == 0){
      EnemyLvl = rand.nextInt(gameLevel+2)+1;
    } 
    if(enemymovement == true){

        if(enemyhealthcreated == false){
            EnemyHealth();
            playerAttacksT[5] = EnemyHealthstat;
            EnemyType.generateEnemyType(this);
            EnemyType.SetEnemyStats();
            enemyhealthcreated = true;
            playerHealth.generatePlayerHealth(Gameloop.playerlevel);
        }
       
        if(Playerlive == true){
            g.setColor(Color.red);

            String [] healthbar = new String[((int)EnemyHealthstat/10)];
            for(int i =0; i <= ((int)EnemyHealthstat/10)-1; i++){
            healthbar[i] = "*";
            }
              for(int i =0; i <= ((int)EnemyHealthstat/10)-1; i++){

            g.drawString("    "+  healthbar[i] +" ",(DungeonCrawlerTest.WIDTH/3)+((((int)EnemyHealthstat/20)+1)+i*18),(DungeonCrawlerTest.HEIGHT/2)-123);
             }
             g.drawString(df.format((EnemyHealthstat/baseEnemyHealthstat)*100)+ "%", DungeonCrawlerTest.WIDTH/3-25, (DungeonCrawlerTest.HEIGHT/2)-123);
            
            playerHealth.PlayerHealthBar(playerHealth.playerHealth, g);

            switch(EnemyType.EnemyType){
                
              case "Goblin" -> {
                EnemyDisplay.showGoblin(g);
                  }
              case "Skeleton" -> {
                EnemyDisplay.showSkeleton(g);
                }
                 case "Orc" -> {
                 EnemyDisplay.showOrc(g);
                 }
                  case "Slime" ->{
                    EnemyDisplay.showSlime(g);
                  }
                   case "Spider" ->{
                    EnemyDisplay.showSpider(g);
                   }
                   case "Knight" ->{
                    EnemyDisplay.showKnight(g);
                     }
        }
            g.setColor(Color.red);
            g.drawString("A lv "+EnemyLvl+" "+ EnemyType.EnemyType + " Has Appeared! ",(DungeonCrawlerTest.WIDTH/2)-100,(DungeonCrawlerTest.HEIGHT/2)+50);

            g.setFont(new Font("Terminus", 0, 14)); 
            g.drawString("Press 1 to use a Light Attack",(DungeonCrawlerTest.WIDTH/2)-80,(DungeonCrawlerTest.HEIGHT/2)+95);
            g.drawString("Press 2 to use a Medium Attack ",(DungeonCrawlerTest.WIDTH/2)-80,(DungeonCrawlerTest.HEIGHT/2)+110);
            g.drawString("Press 3 to use a Heavy Attack ",(DungeonCrawlerTest.WIDTH/2)-80,(DungeonCrawlerTest.HEIGHT/2)+125);
            g.drawString("Press 4 to use a Magic Attack ",(DungeonCrawlerTest.WIDTH/2)-80,(DungeonCrawlerTest.HEIGHT/2)+140);
            g.drawString("Press 5 to use a Ranged Attack ",(DungeonCrawlerTest.WIDTH/2)-80,(DungeonCrawlerTest.HEIGHT/2)+155);
            }
      }
        if(EnemyHealthstat>0.0 && playerHealth.playerHealth > 0.0)
        {
            playerAttacksT[5] = EnemyHealthstat;
          
            playerAttacks(g);
            EnemyHealthstat = playerAttacksT[5];
            
        }

        if (EnemyHealthstat<= 0.0) {
            enemymovement = false;
        }
        if(playerHealth.playerHealth <= 0){
            Playerlive = false;
        }

    if(enemymovement == false){
        if(gainedEXP == false){
            PlayerLevelSystem.gainXp(EnemyLvl,g);
            gainedEXP = true;
        
        }
        
        Done = 0;
        Attacks.RandomAttack = 0;
      
     
        for(int III = 0; III<listofLoc.size();III++){
            if(listofLoc.get(III).getEnemyX() == playerX && listofLoc.get(III).getEnemyY() == playerY){
                listofLoc.remove(III);
                EnemyLvl = 0;
            }
        }

       // Thread.sleep(150);
        }
    if(Playerlive == false){
        g.setColor(Color.orange);
        g.drawString("You have lost ",(DungeonCrawlerTest.WIDTH/2)-50,(DungeonCrawlerTest.HEIGHT/2)+50);
        }
    
    return enemymovement;    
}


static double EnemyHealthstat;
static double baseHealth;

/**
 * 
 * creates and assigns the int value for the enemies health
 * 
 * @return health of enemy
 */

public double EnemyHealth(){
    gainedEXP = false;
    Random rand = new Random();
    baseHealth = rand.nextDouble(75)+25;
    if(baseHealth >= 75){
        baseHealth = 75;
    }

    EnemyHealthstat = baseHealth + (2*EnemyLvl);
    baseEnemyHealthstat = EnemyHealthstat;
    return EnemyHealthstat;
}

static double[] playerAttacksT = new double[6];
static double lightAttackTime = 0.0;
static double mediumAttacktime =0.0;
static double HeavyAttacktime = 0.0;
static double MagicAttacktime =0.0;
static double RangedAttacktime = 0.0;
static int Done = 0;

/**
 * 
 * method that enable the player to attack and do damage to the enemy
 * 
 * @param g
 * @return the amount of damage done to the enemy and enemy health
 */

  static boolean EnAttacksconfirm = false;
public double[] playerAttacks(Graphics g) throws InterruptedException {

    lightAttackTime = playerAttacksT[0];
    mediumAttacktime = playerAttacksT[1];
    HeavyAttacktime = playerAttacksT[2];
    MagicAttacktime = playerAttacksT[3];
    RangedAttacktime = playerAttacksT[4];
    playerAttacksT[5] = EnemyHealthstat;

    if(Controller.one == true && enemymovement == true){
            lightAttackTime = lightAttackTime+(1.0/58.0);
            playerAttacksT[0] = lightAttackTime;
    }else lightAttackTime =0.0;
        
    if(lightAttackTime >= 1.25) {
        playerAttacksT[5] = playerAttacksT[5]-Attacks.LightAttack();
     
       Attacks.enemyAttacks(EnemyLvl, g,gameLevel);
        Done = 1;
        playerAttacksT[0]=0;
     //   Thread.sleep(200);
        }
    if(Controller.two == true && enemymovement == true){
        mediumAttacktime = mediumAttacktime+(1.0/58.0);
        playerAttacksT[1] = mediumAttacktime;
    }else mediumAttacktime = 0.0;

    if(mediumAttacktime >= 1.25) {
        playerAttacksT[5] = playerAttacksT[5]-Attacks.MediumAttack();
     
         Attacks.enemyAttacks(EnemyLvl, g,gameLevel);
        Done = 2;
        playerAttacksT[1]=0;
     //   Thread.sleep(200);
    }
    if(Controller.three == true && enemymovement == true){
        HeavyAttacktime = HeavyAttacktime+(1.0/58.0);
        playerAttacksT[2]= HeavyAttacktime;
    }else HeavyAttacktime = 0.0;

    if(HeavyAttacktime >= 1.25) {
        playerAttacksT[5] = playerAttacksT[5]-Attacks.HeavyAttack();

       Attacks.enemyAttacks(EnemyLvl, g,gameLevel);
        Done = 3; 
        playerAttacksT[2]=0;
      //  Thread.sleep(200);
    }
     if(Controller.four == true && enemymovement == true){
        MagicAttacktime = MagicAttacktime+(1.0/58.0);
        playerAttacksT[3] = MagicAttacktime;
    }else MagicAttacktime = 0.0;

    if(MagicAttacktime >= 1.25) {
        playerAttacksT[5] = playerAttacksT[5]-Attacks.MagicAttack();
        
       Attacks.enemyAttacks(EnemyLvl, g,gameLevel);   
       Done = 4;
       playerAttacksT[3]=0;
     //  Thread.sleep(200);
    }   

    if(Controller.five == true && enemymovement == true){
        RangedAttacktime = RangedAttacktime+(1.0/58.0);
        
        playerAttacksT[4] = RangedAttacktime;
    }
    else RangedAttacktime = 0;

    if(RangedAttacktime >= 1.25) {
        playerAttacksT[5] = playerAttacksT[5]-Attacks.RangedAttack();
        
        Attacks.enemyAttacks(EnemyLvl, g,gameLevel);
        Done = 5; 
        playerAttacksT[4]=0;
      //  Thread.sleep(200);
    }

    g.setColor(Color.YELLOW);
    switch(Done){
        case 1 ->   {
                    g.drawString("You used a Light Attack for: "+ Attacks.LightAttack() + " damage",(DungeonCrawlerTest.WIDTH/2)-95,(DungeonCrawlerTest.HEIGHT/2)+170);
                   
                    Attacks.showenemyAttacks(g,Attacks.RandomAttack,gameLevel);
                   
                    }
        case 2 ->   {
                    g.drawString("You used a Medium Attack for: "+ Attacks.MediumAttack() + " damage",(DungeonCrawlerTest.WIDTH/2)-95,(DungeonCrawlerTest.HEIGHT/2)+170);
               
                    Attacks.showenemyAttacks(g,Attacks.RandomAttack,gameLevel);
                   
                    }
        case 3 ->   {
                    g.drawString("You used a Heavy Attack for: "+ Attacks.HeavyAttack() + " damage",(DungeonCrawlerTest.WIDTH/2)-95,(DungeonCrawlerTest.HEIGHT/2)+170);
                   
                    Attacks.showenemyAttacks(g,Attacks.RandomAttack,gameLevel);
                  
                    }
        case 4 ->   {
                    g.drawString("You used a Magic Attack for: "+ Attacks.MagicAttack() + " damage",(DungeonCrawlerTest.WIDTH/2)-95,(DungeonCrawlerTest.HEIGHT/2)+170);
             
                    Attacks.showenemyAttacks(g,Attacks.RandomAttack,gameLevel);
                  
                    }
        case 5 ->   {
                    g.drawString("You used a Ranged Attack for: "+ Attacks.RangedAttack() + " damage",(DungeonCrawlerTest.WIDTH/2)-95,(DungeonCrawlerTest.HEIGHT/2)+170);
               
                    Attacks.showenemyAttacks(g,Attacks.RandomAttack,gameLevel);
                  
                    }
        default->   g.drawString(" ",(DungeonCrawlerTest.WIDTH/2)-80,(DungeonCrawlerTest.HEIGHT/2)+170);   
    }
    
    return playerAttacksT;
}


 }
    

