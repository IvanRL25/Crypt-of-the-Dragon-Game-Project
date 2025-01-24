//package PersonalProject;
/**
 * 
 * This contains the calculations for the attacks to be used when
 * an enemy is encountered
 * 
 * @author Ivan Lopez
 * @version PersonalProject DungeonCrawlerTest 0.01 Alpha
 * @since 10/10/2023
 * 
 */

import java.util.Random;
import java.awt.Font;
import java.awt.Graphics;

public class Attacks {
     
    
    static int lvl = 1; 
    static int medium =0;
    static int heavy =0;
    static int light =0;
    static int magic = 0;
    static int ranged = 0;

public static int LightAttack(){
light = 9 + (Integer.parseInt(Gameloop.selectionlist[3]));
return light;
}

public static int MediumAttack(){
    medium = 9 + (Integer.parseInt(Gameloop.selectionlist[1]));
    return medium;
}

public static int HeavyAttack(){
    heavy = 9 + (Integer.parseInt(Gameloop.selectionlist[5]));
    return heavy;
}

public static int MagicAttack(){
    magic = 9 + (Integer.parseInt(Gameloop.selectionlist[4]));
    return magic;
}

public static int RangedAttack(){
    ranged =9 + (Integer.parseInt(Gameloop.selectionlist[2]));
    return ranged;
}


/**
 * 
 * generates the enemy attacks and calculates the damage they will do
 * 
 * @param enemylevel the level of enemy
 * @param g graphics style
 * @return RandomAttack: the attack that the enemy uses
 */
public static int RandomAttack;
public static int enemyAttacks(int enemylevel, Graphics g, int gamelevel) throws InterruptedException{
    Random rand = new Random();
   
    if(gamePlayLoop.EnemyHealthstat > 0){
    RandomAttack = rand.nextInt(5)+1;
    if(RandomAttack > 5){
        RandomAttack = 5;
    }
    switch(RandomAttack){
        case 1 ->    playerHealth.playerHealth = playerHealth.playerHealth - Attacks.EnemyLightAttack(gamelevel); 
        case 2 ->    playerHealth.playerHealth = playerHealth.playerHealth - Attacks.EnemyMediumAttack(gamelevel);
        case 3 ->    playerHealth.playerHealth = playerHealth.playerHealth - Attacks.EnemyHeavyAttack(gamelevel);
        case 4 ->    playerHealth.playerHealth = playerHealth.playerHealth - Attacks.EnemyMagicAttack(gamelevel);
        case 5 ->    playerHealth.playerHealth = playerHealth.playerHealth - Attacks.EnemyRangedAttack(gamelevel);
                }
            }     
    return RandomAttack;
            
}

/**
 * Displays the attack and damage the enemy does
 * 
 * @param g graphics styles
 * @param RandomAttacks attack type of enemy
 * @return what is printed out
 */
public static int showenemyAttacks(Graphics g, int RandomAttacks, int gamelevel){
    g.setFont(new Font("Terminus", 0, 14)); 
    switch(RandomAttacks){
        case 1 ->   {
                    g.drawString(EnemyType.EnemyType+ " used a Light Attack for: "+ Attacks.EnemyLightAttack(gamelevel) + " damage",(DungeonCrawlerTest.WIDTH/2)-95,(DungeonCrawlerTest.HEIGHT/2)+185);
                    }
        case 2 ->   {
                    g.drawString(EnemyType.EnemyType+ " used a Medium Attack for: "+ Attacks.EnemyMediumAttack(gamelevel) + " damage",(DungeonCrawlerTest.WIDTH/2)-95,(DungeonCrawlerTest.HEIGHT/2)+185);
                    }
        case 3 ->   {
                    g.drawString(EnemyType.EnemyType+ " used a Heavy Attack for: "+ Attacks.EnemyHeavyAttack(gamelevel) + " damage",(DungeonCrawlerTest.WIDTH/2)-95,(DungeonCrawlerTest.HEIGHT/2)+185);
                    }
        case 4 ->   {
                    g.drawString(EnemyType.EnemyType+ " used a Magic Attack for: "+ Attacks.EnemyMagicAttack(gamelevel) + " damage",(DungeonCrawlerTest.WIDTH/2)-95,(DungeonCrawlerTest.HEIGHT/2)+185);
                    }
        case 5 ->   {
                    g.drawString(EnemyType.EnemyType+" used a Ranged Attack for: "+ Attacks.EnemyRangedAttack(gamelevel) + " damage",(DungeonCrawlerTest.WIDTH/2)-95,(DungeonCrawlerTest.HEIGHT/2)+185);
                    }
        default -> g.drawString(" ",(DungeonCrawlerTest.WIDTH/2)-80,(DungeonCrawlerTest.HEIGHT/2)+170);
                }
        return RandomAttacks;
}
    
   

public static int EnemyLightAttack(int level){
light = ((2*EnemyType.Econstitution)*gamePlayLoop.EnemyLvl);
if(light > 25  && level <= 5 ){
    light = 25;
   }
else if(light >35 && level > 5 && level <=7 ){
    light = 35;
}
else if(light >45 && level > 7 && level <=9 ){
    light = 45;
}
return light;
}

public static int EnemyMediumAttack(int level){
    medium = ((2*EnemyType.Edex)*gamePlayLoop.EnemyLvl);
    if(medium > 25 && level <= 5 ){
        medium = 25;
       }
    else if(medium >35 && level > 5 && level <=7 ){
        medium = 35;
    }
    else if(light >45 && level > 7 && level <=9 ){
        medium = 45;
    }
    return medium;
}

public static int EnemyHeavyAttack(int level){
    heavy = ((2*EnemyType.EStrength)*gamePlayLoop.EnemyLvl);
    if(heavy > 25  && level <= 5){
        heavy = 25;
       }
    else if(heavy >35 && level > 5 && level <=7 ){
        heavy = 35;
    }
    else if(heavy >45 && level > 7 && level <=9 ){
        heavy = 45;
    }
    return heavy;
}

public static int EnemyMagicAttack(int level){
    magic = ((2*EnemyType.Eintel)*gamePlayLoop.EnemyLvl);
    if(magic > 25  && level <= 5){
        magic = 25;
       }
    else if(magic >35 && level > 5 && level <=7 ){
        magic = 35;
    }
    else if(magic >45 && level > 7 && level <=9 ){
        light = 45;
    }
    return magic;
}

public static int EnemyRangedAttack(int level){
    ranged = ((2*EnemyType.EWisdom)*gamePlayLoop.EnemyLvl);
   if(ranged > 25 && level <= 5){
    ranged = 25;
   }
   else if(light >35 && level > 5 && level <=7 ){
    light = 35;
    }
    else if(light >45 && level > 7 && level <=9 ){
    light = 45;
    }
    return ranged;
}

}
