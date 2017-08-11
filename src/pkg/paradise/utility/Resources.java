package pkg.paradise.utility;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class Resources {

    //Intro Logo
    public static BufferedImage company_logo;
    //Start Menu 
    public static BufferedImage start_menu;
    //HUD
    public static BufferedImage hud_health_energy;
    public static BufferedImage hud_inventory;
    public static BufferedImage hud_chat_background;
    public static Font font_medium = loadFont("HUD/pixel_font.ttf", 40f);
    public static Font font_small = loadFont("HUD/pixel_font.ttf", 20f);

    public Resources() {
        loadImages();
    }

    /****************************************************
     * Name:        loadImages 
     * Description: Loads up some display images.
     ****************************************************/
    private void loadImages() {
        try {
            company_logo = ImageIO.read(getClass().getResourceAsStream("/logo/bell_labs.png"));
            start_menu = ImageIO.read(getClass().getResourceAsStream("/start_menu.png"));
            hud_health_energy = ImageIO.read(getClass().getResourceAsStream("/HUD/hud_health_energy.png"));
            hud_inventory = ImageIO.read(getClass().getResourceAsStream("/HUD/hud_inventory.png"));
            hud_chat_background = ImageIO.read(getClass().getResourceAsStream("/HUD/hud_chat_background.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /****************************************************w
     * Name:        loadFont 
     * Description: This is the general font for the game. 
     * It features a pixel-esque style of font. 
     ****************************************************/
    private static Font loadFont(String path, float size) {
        Font font = null;
        try {
            InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream(path);
            font = Font.createFont(Font.TRUETYPE_FONT, stream).deriveFont(size);
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace();
        }
        return font;
    }
}
