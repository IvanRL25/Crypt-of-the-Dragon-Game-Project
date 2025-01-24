import java.awt.Graphics;
import java.awt.Image;

import java.io.IOException;

import javax.imageio.*;

public class loadsprites {

Image slime1;
Image goblin1;
Image orc1;
Image skeleton1;
Image spider1;
Image knight1;
public void getImages() throws IOException{
   
    try {
          slime1 = ImageIO.read(getClass().getResourceAsStream("/sprites/slime/Slime.png"));
          goblin1 =  ImageIO.read(getClass().getResourceAsStream("/sprites/goblin/Gobline.png"));
          orc1 = ImageIO.read(getClass().getResourceAsStream("/sprites/orc/orcs.png"));
          skeleton1 =  ImageIO.read(getClass().getResourceAsStream("/sprites/skeleton/Skeletons.png"));
          spider1 =  ImageIO.read(getClass().getResourceAsStream("/sprites/spider/sPiders.png"));
          knight1 =  ImageIO.read(getClass().getResourceAsStream("/sprites/knight/knights.png"));

    } catch (Exception e) {
        System.out.println("failed");
     
    }
    }


public void drawOrc( Graphics g){
    g.drawImage(orc1, DungeonCrawlerTest.WIDTH/2 - 225, DungeonCrawlerTest.HEIGHT/2-190, 512,256,null );
}

public void drawSkeleton( Graphics g){
    g.drawImage(skeleton1, DungeonCrawlerTest.WIDTH/2 - 225, (DungeonCrawlerTest.HEIGHT/2)-160,475,200, null );
}

public void drawSpider( Graphics g){
    g.drawImage(spider1, DungeonCrawlerTest.WIDTH/2 - 305, (DungeonCrawlerTest.HEIGHT/2-180),512,256, null );
}

public void drawsKnight( Graphics g){
    g.drawImage(knight1, DungeonCrawlerTest.WIDTH/2 - 215, (DungeonCrawlerTest.HEIGHT/2)-135,475,225,null );
}

public void drawSlime( Graphics g){
    g.drawImage(slime1, DungeonCrawlerTest.WIDTH/2 - 120, DungeonCrawlerTest.HEIGHT/2-150, null );
}

public void drawGobline( Graphics g){
    g.drawImage(goblin1, DungeonCrawlerTest.WIDTH/2 - 125, (DungeonCrawlerTest.HEIGHT/2)-190,240,240, null );
}
}
