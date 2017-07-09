package pkg.islandadventure.level;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SpawnLevel extends Level {

    public SpawnLevel(String path) {
        super(path);
    }

    @Override
    protected void loadLevel(String path) {
        try {
            //Loading image from designated path
            BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path));
            int w = width = image.getWidth();
            int h = height = image.getHeight();
            tiles = new int[w * h];

            //Convert image into array of pixels by color
            image.getRGB(0, 0, w, h, tiles, 0, w);
        } catch (IOException e) {
            System.out.println("Exception! Could not level file.");
            e.printStackTrace();
        }
    }

    /****************************************************
     * Name:        generatelevel 
     * Description: This is sets up the level. 
     ****************************************************/
    @Override
    protected void generateLevel() {

    }
}
