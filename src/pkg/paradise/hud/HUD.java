package pkg.paradise.hud;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import pkg.paradise.entity.mob.Player;
import pkg.paradise.utility.Resources;

public class HUD {

    private Player player;
    private BufferedImage bar;

    public HUD(Player player) {
        this.player = player;
        this.bar = Resources.hud_health_energy;
    }

    public void update() {

    }

    public void render(Graphics g) {
        drawHealthEnergy(g);
    }

     /****************************************************
     * Name: drawHealthEnergy
     * Description: Draws up the upper left hand corner
     * HUD which displays a health and energy bar
     ****************************************************/
    public void drawHealthEnergy(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(Resources.pixel_font);
        g.drawImage(bar, 3, 3, null);
        g.drawString("Health:", 9, 31);
        g.drawString("Energy:", 9, 59);
        g.setColor(Color.GREEN);
        g.fillRect(91, 23, 75, 8);
        g.setColor(Color.YELLOW);
        g.fillRect(91, 52, 75, 8);

    }

}
