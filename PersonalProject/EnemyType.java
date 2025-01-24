//package PersonalProject;

import java.util.Random;
public class EnemyType {
    static String EnemyType = "";
    public static String generateEnemyType(gamePlayLoop level){
        Random rand = new Random();
        int typeDecider =0;
         if(level.gameLevel == 1){
           typeDecider = 1;
          }
         else  if(level.gameLevel == 2){
            typeDecider = rand.nextInt(2)+1;
         }
         else  if(level.gameLevel == 3){
            typeDecider = rand.nextInt(3)+1;
         }
         else  if(level.gameLevel == 4){
            typeDecider = rand.nextInt(4)+1;
         }
         else  if(level.gameLevel == 5){
            typeDecider = rand.nextInt(5)+1;
         }
         else  if(level.gameLevel >= 6){
            typeDecider = rand.nextInt(6)+1;
         }

    

        if(typeDecider == 3 ){
            EnemyType = "Orc";
        }
        else if(typeDecider == 2 ){
            EnemyType = "Skeleton";
        }
        else if(typeDecider == 4){
            EnemyType = "Slime";
        }
        else if(typeDecider == 5){
            EnemyType = "Spider";
        }
        else if(typeDecider == 6){
            EnemyType = "Knight";
        }
        else
        EnemyType = "Goblin";

        return EnemyType;
    }

    static int Edex = 0;
    static int Eintel = 0;
    static int Echarisma = 0;
    static int EWisdom = 0;
    static int EStrength = 0;
    static int Econstitution = 0;
    
    public static int[] EnemyStat = new int[6];

    public static int[] SetEnemyStats(){

       switch(EnemyType){
            case "Skeleton" -> {
                            EnemyStat[0] = 1;
                            EnemyStat[1]=2;
                            EnemyStat[2]=1;
                            EnemyStat[3]=3;
                            EnemyStat[4]=1;
                            EnemyStat[5] = 1;
                            }
            case "Goblin" ->{
                            EnemyStat[0] = 3;
                            EnemyStat[1]=1;
                            EnemyStat[2]=1;
                            EnemyStat[3]=1;
                            EnemyStat[4]=2;
                            EnemyStat[5] = 2;
                            }
            case "Orc" ->{
                            EnemyStat[0] = 1;
                            EnemyStat[1]=1;
                            EnemyStat[2]=1;
                            EnemyStat[3]=1;
                            EnemyStat[4]=2;
                            EnemyStat[5] = 3;
                            }
            case "Slime"-> {
                            EnemyStat[0] = 2;
                            EnemyStat[1]=1;
                            EnemyStat[2]=1;
                            EnemyStat[3]=1;
                            EnemyStat[4]=2;
                            EnemyStat[5] = 4;
                            }
            case "Spider" -> {
                            EnemyStat[0] = 3;
                            EnemyStat[1]=2;
                            EnemyStat[2]=1;
                            EnemyStat[3]=1;
                            EnemyStat[4]=3;
                            EnemyStat[5] = 2;
                             }
            case "Knight" -> {
                            EnemyStat[0] = 1;
                            EnemyStat[1]=2;
                            EnemyStat[2]=1;
                            EnemyStat[3]=2;
                            EnemyStat[4]=3;
                            EnemyStat[5] = 3;
                            }
        }
        
            Edex =  EnemyStat[0];
            Eintel = EnemyStat[1];
            Echarisma  = EnemyStat[2];
            EWisdom = EnemyStat[3];
            EStrength = EnemyStat[4];
            Econstitution = EnemyStat[5];
                            
        return EnemyStat;
    }
}
