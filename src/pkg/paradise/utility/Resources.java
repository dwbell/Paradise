package pkg.paradise.utility;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class Resources {

    public static Font font;
    public static BufferedImage logo;
    public static BufferedImage menu_bg;

    public Resources() {
        loadImages();
        loadFont();
    }

    /****************************************************
     * Name:        loadImages 
     * Description: Loads up the 
     ****************************************************/
    public void loadImages() {
        try {
            logo = ImageIO.read(getClass().getResourceAsStream("/bell_labs.png"));
            menu_bg = ImageIO.read(getClass().getResourceAsStream("/Menu.png"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /****************************************************
     * Name:        loadFont 
     * Description: This is the general font for the game. 
     * It features a pixel-esque style of font. 
     ****************************************************/
    public void loadFont() {
        try {
            InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream("pixel_font.ttf");
            font = Font.createFont(Font.TRUETYPE_FONT, stream).deriveFont(120f);
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace();
        }
    }
}
