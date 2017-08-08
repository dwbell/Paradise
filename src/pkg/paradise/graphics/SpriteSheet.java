package pkg.paradise.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SpriteSheet {

    private String path;
    private final int SIZE;
    public int[] pixels;

    //Creating static sprite sheets here
    public static SpriteSheet terrain = new SpriteSheet("/sprites/terrain_spritesheet.png", 256);
    public static SpriteSheet mob = new SpriteSheet("/sprites/mob_spritesheet.png", 128);
    public static SpriteSheet characters = new SpriteSheet("/sprites/characters.png", 256);

    public SpriteSheet(String pathParam, int sizeParam) {
        this.path = pathParam;
        this.SIZE = sizeParam;
        pixels = new int[SIZE * SIZE];
        load();
    }

    /****************************************************
     * Name:        load
     * Description: Loads an entire sprite sheet into 
     * pixels array.
     ****************************************************/
    private void load() {

        try {
            BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
            int w = image.getWidth();
            int h = image.getHeight();

            //Translating loaded image into pixels array
            image.getRGB(0, 0, w, h, pixels, 0, w);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /****************************************************
     * Name:        getSpriteSheetSize
     * Description: Getter method for getting Sprite Sheets Size
     ****************************************************/
    public int getSpriteSheetSize() {
        return SIZE;
    }

}
