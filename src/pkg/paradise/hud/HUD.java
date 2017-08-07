package pkg.paradise.hud;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import pkg.paradise.client.Sender;
import pkg.paradise.entity.mob.Player;
import pkg.paradise.main.Game;
import pkg.paradise.utility.Resources;

public class HUD implements ActionListener {

    private Player player;
    private boolean inventoryOpen;

    public HUD(Player player) {
        this.player = player;

        //Chat communication 
        this.inventoryOpen = false;
        Game.textfield.setVisible(true);
        Game.textfield.addActionListener(this);
        Game.textfield.revalidate();
        Game.textfield.repaint();

        Game.scrollPane.setVisible(true);
        Game.scrollPane.revalidate();
        Game.scrollPane.repaint();

        Game.textArea.setVisible(true);
        Game.textArea.revalidate();
        Game.textArea.repaint();

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
        g.setFont(Resources.font_medium);
        g.drawImage(Resources.hud_health_energy, 3, 3, null);
        g.drawString("Health:", 9, 31);
        g.drawString("Energy:", 9, 59);
        g.setColor(Color.GREEN);
        g.fillRect(91, 23, 75, 8);
        g.setColor(Color.YELLOW);
        g.fillRect(91, 52, 75, 8);
    }

    /****************************************************
     * Name: actionPerformed
     * Description: Called when enter is hit, via the
     * text field for the chat client. Appends text
     * from text field into the text area for viewing.
     ****************************************************/
    @Override
    public void actionPerformed(ActionEvent e) {
        String text = Game.textfield.getText();
        Sender.sendChatMessage(text);
        Game.textArea.append(text + "\n");
        Game.textfield.selectAll();
        Game.textfield.setText("");
    }
}
