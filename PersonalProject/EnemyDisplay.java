//package PersonalProject;

//import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
public class EnemyDisplay {
      

    public static void showSkeleton(Graphics g) throws IOException{
        loadsprites test = new loadsprites();
        test.getImages();
        test.drawSkeleton(g);

        // g.setColor(Color.white);
        // g.drawString("       ",(DungeonCrawlerTest.WIDTH/2)-50,(DungeonCrawlerTest.HEIGHT/2)-64);
        // g.drawString("    (  )   ",(DungeonCrawlerTest.WIDTH/2)-50,(DungeonCrawlerTest.HEIGHT/2)-46);
        // g.drawString("  ==    \\\\   ",(DungeonCrawlerTest.WIDTH/2)-50,(DungeonCrawlerTest.HEIGHT/2)-28);
        // g.setColor(Color.ORANGE);
        // g.drawString(" |              ",(DungeonCrawlerTest.WIDTH/2)-50,(DungeonCrawlerTest.HEIGHT/2)-28);
        //  g.drawString("  /     ",(DungeonCrawlerTest.WIDTH/2)-50,(DungeonCrawlerTest.HEIGHT/2)-64);
        // g.drawString(" |          ",(DungeonCrawlerTest.WIDTH/2)-50,(DungeonCrawlerTest.HEIGHT/2)-46);
        // g.drawString(" \\   [][]    ",(DungeonCrawlerTest.WIDTH/2)-50,(DungeonCrawlerTest.HEIGHT/2)-10);
       
        // g.setColor(Color.gray);
        // g.drawString("     [][]    ",(DungeonCrawlerTest.WIDTH/2)-50,(DungeonCrawlerTest.HEIGHT/2)-28);
        // g.drawString("     [][]    ",(DungeonCrawlerTest.WIDTH/2)-50,(DungeonCrawlerTest.HEIGHT/2)-10);
        // g.setColor(Color.white);
        // g.drawString("    //  \\\\ ",(DungeonCrawlerTest.WIDTH/2)-50,(DungeonCrawlerTest.HEIGHT/2)+8);
    }

    public static void showGoblin(Graphics g) throws IOException{
        loadsprites test = new loadsprites();
        test.getImages();
        test.drawGobline(g);
        
    //     g.setColor(Color.green);
    //     g.drawString("       ",(DungeonCrawlerTest.WIDTH/2)-50,(DungeonCrawlerTest.HEIGHT/2)-64);
    //     g.drawString("     (  )   ",(DungeonCrawlerTest.WIDTH/2)-50,(DungeonCrawlerTest.HEIGHT/2)-46);
    //     g.drawString("   //    \\\\   ",(DungeonCrawlerTest.WIDTH/2)-50,(DungeonCrawlerTest.HEIGHT/2)-28);
    //     g.setColor(Color.white);
    //     g.drawString("     [][]    ",(DungeonCrawlerTest.WIDTH/2)-50,(DungeonCrawlerTest.HEIGHT/2)-28);
    //     g.drawString("     [][]    ",(DungeonCrawlerTest.WIDTH/2)-50,(DungeonCrawlerTest.HEIGHT/2)-10);
    //     g.setColor(Color.green);
    //     g.drawString("    //  \\\\ ",(DungeonCrawlerTest.WIDTH/2)-50,(DungeonCrawlerTest.HEIGHT/2)+8);
     }

    public static void showOrc(Graphics g) throws IOException{
        loadsprites test = new loadsprites();
        test.getImages();
        test.drawOrc(g);

        // g.setColor(Color.gray);
        // g.drawString("       ",(DungeonCrawlerTest.WIDTH/2)-50,(DungeonCrawlerTest.HEIGHT/2)-64);
        // g.drawString("     (     )   ",(DungeonCrawlerTest.WIDTH/2)-50,(DungeonCrawlerTest.HEIGHT/2)-46);
        // g.drawString("   //      \\\\   ",(DungeonCrawlerTest.WIDTH/2)-50,(DungeonCrawlerTest.HEIGHT/2)-28);
        // g.setColor(Color.blue);
        // g.drawString("     [][][]    ",(DungeonCrawlerTest.WIDTH/2)-50,(DungeonCrawlerTest.HEIGHT/2)-28);
        // g.drawString("     [][][]   ",(DungeonCrawlerTest.WIDTH/2)-50,(DungeonCrawlerTest.HEIGHT/2)-10);
        // g.setColor(Color.gray);
        // g.drawString("    //    \\\\ ",(DungeonCrawlerTest.WIDTH/2)-50,(DungeonCrawlerTest.HEIGHT/2)+8);
   
    }

    public static void showSlime(Graphics g) throws IOException{
        loadsprites test = new loadsprites();
   
        test.getImages();
        test.drawSlime(g);
        
        // g.setColor(Color.green);
        // g.drawString("   ________  ",(DungeonCrawlerTest.WIDTH/2)-50,(DungeonCrawlerTest.HEIGHT/2)-64);
        // g.drawString("  |                 |   ",(DungeonCrawlerTest.WIDTH/2)-50,(DungeonCrawlerTest.HEIGHT/2)-46);
        // g.drawString("  |                 |   ",(DungeonCrawlerTest.WIDTH/2)-50,(DungeonCrawlerTest.HEIGHT/2)-28);
        
        // g.drawString("  |                 |    ",(DungeonCrawlerTest.WIDTH/2)-50,(DungeonCrawlerTest.HEIGHT/2)-16);
        // g.drawString("  |                 |   ",(DungeonCrawlerTest.WIDTH/2)-50,(DungeonCrawlerTest.HEIGHT/2)-10);
      
        // g.drawString("  |________| ",(DungeonCrawlerTest.WIDTH/2)-50,(DungeonCrawlerTest.HEIGHT/2)+8);
   
    }

    public static void showSpider(Graphics g) throws IOException{
        loadsprites test = new loadsprites();
        test.getImages();
        test.drawSpider(g);
        
    //     g.setColor(Color.gray);
    //     g.drawString("     _______    ",(DungeonCrawlerTest.WIDTH/2)-71,(DungeonCrawlerTest.HEIGHT/2)-64);
    //     g.drawString("    |               |   ",(DungeonCrawlerTest.WIDTH/2)-68,(DungeonCrawlerTest.HEIGHT/2)-46);
    //     g.drawString("  _____|               |_____   ",(DungeonCrawlerTest.WIDTH/2)-111,(DungeonCrawlerTest.HEIGHT/2)-28);
        
    //     g.drawString("/   ____|               |____   \\   ",(DungeonCrawlerTest.WIDTH/2)-110,(DungeonCrawlerTest.HEIGHT/2)-16);
    //     g.drawString("    __|_______|__   ",(DungeonCrawlerTest.WIDTH/2)-90,(DungeonCrawlerTest.HEIGHT/2)-9);
      
    //     g.drawString(" /                                 \\   ",(DungeonCrawlerTest.WIDTH/2)-99,(DungeonCrawlerTest.HEIGHT/2)+2);
    //     g.drawString("     /                        \\",(DungeonCrawlerTest.WIDTH/2)-97,(DungeonCrawlerTest.HEIGHT/2)+8);
    //     g.setColor(Color.RED);
    //     g.drawString("▣▣ ▣▣", (DungeonCrawlerTest.WIDTH/2)-45,(DungeonCrawlerTest.HEIGHT/2)-38);
    //     g.drawString("  ▣▣  ", (DungeonCrawlerTest.WIDTH/2)-35,(DungeonCrawlerTest.HEIGHT/2)-22);
    }

    public static void showKnight(Graphics g) throws IOException{
        loadsprites test = new loadsprites();
        test.getImages();
        test.drawsKnight(g);
        
   
    }

}
