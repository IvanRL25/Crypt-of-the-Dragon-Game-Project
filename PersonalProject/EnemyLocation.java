//package PersonalProject;

import java.awt.Graphics;
import java.util.Random;
public class EnemyLocation {
    private int enemyX;
    private int enemyY;
    private static gamePlayLoop enemylocatmap = new gamePlayLoop();
   
    public static void setEnemylocatmap(gamePlayLoop enemylocatmap) {
        EnemyLocation.enemylocatmap = enemylocatmap;
    }
    public EnemyLocation(int x, int y, gamePlayLoop t){
        Random rand = new Random();

        enemyX = rand.nextInt(x);
        enemyY = rand.nextInt(y);
        enemylocatmap = t;
    }
    public EnemyLocation(gamePlayLoop t){
        enemyX = 0;
        enemyY = 0;
        enemylocatmap = t;
    }

    public void displayEnemy(Graphics g){

        gamePlayLoop.map[getEnemyX()][getEnemyY()] = "[E]";

    }

    public int getEnemyX(){
        return enemyX;
    }
    public int setEnemyX(int x){
        Random rand = new Random();
        enemyX = rand.nextInt(x);
        return enemyX;
    }
    public int setEnemyY(int y){
        Random rand = new Random();
        enemyY = rand.nextInt(y);
        return enemyY;
    }
    
    public int getEnemyY(){
        return enemyY;
    }

    public static gamePlayLoop getEnemylocatmap() {
        return enemylocatmap;
    }




    public static int [][] enemyLocations = new int[enemylocatmap.gameLevel*4][enemylocatmap.gameLevel*4];

    public int[][] fillEnemylocations(int x, int y){
        for(int i =0; i<(enemylocatmap.gameLevel*4)-1; i++){
            for(int j = 0; j<(enemylocatmap.gameLevel*4)-1;j++){
                enemyLocations[i][j] = 0;
                enemyLocations[i+1][j] = 0;
            }
        }
        return enemyLocations;
    }
}
