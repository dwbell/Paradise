package pkg.paradise.hud;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import pkg.paradise.entity.mob.Player;
import pkg.paradise.main.Game;
import pkg.paradise.utility.Resources;

public class HUD {

    private Player player;
    private boolean inventoryOpen;

    public HUD(Player player) {
        this.player = player;
        this.inventoryOpen = false;
    }

    public void update() {
        if (Game.keyboard.keyDownOnce(KeyEvent.VK_I) && !inventoryOpen) {
            inventoryOpen = true;
        } else if (Game.keyboard.keyDownOnce(KeyEvent.VK_I) && inventoryOpen) {
            inventoryOpen = false;
        }
    }

    public void render(Graphics g) {
        drawHealthEnergy(g);
        if (inventoryOpen) {
            g.drawImage(Resources.hud_inventory, 3, 80, null);
        }
    }

    /****************************************************
     * Name: drawHealthEnergy
     * Description: Draws up the upper left hand corner
     * HUD which displays a health and energy bar
     ****************************************************/
    public void drawHealthEnergy(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(Resources.pixel_font);
        g.drawImage(Resources.hud_health_energy, 3, 3, null);
        g.drawString("Health:", 9, 31);
        g.drawString("Energy:", 9, 59);
        g.setColor(Color.GREEN);
        g.fillRect(91, 23, 75, 8);
        g.setColor(Color.YELLOW);
        g.fillRect(91, 52, 75, 8);

    }

}
