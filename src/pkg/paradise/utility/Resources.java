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
    public static Font pixel_font;

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
            company_logo = ImageIO.read(getClass().getResourceAsStream("/logo/bell_labs.png"));
            start_menu = ImageIO.read(getClass().getResourceAsStream("/Start_Menu.png"));
            hud_health_energy = ImageIO.read(getClass().getResourceAsStream("/HUD/HUD_Health_Energy.png"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /****************************************************w
     * Name:        loadFont 
     * Description: This is the general font for the game. 
     * It features a pixel-esque style of font. 
     ****************************************************/
    public void loadFont() {
        try {
            InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream("HUD/pixel_font.ttf");
            pixel_font = Font.createFont(Font.TRUETYPE_FONT, stream).deriveFont(40f);
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace();
        }
    }
}
