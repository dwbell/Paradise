package pkg.paradise.hud;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.JFrame;
import pkg.paradise.client.Sender;
import pkg.paradise.entity.mob.Player;
import pkg.paradise.main.Game;
import pkg.paradise.utility.Resources;

public class HUD extends JFrame implements ActionListener {

    private final Player player;
    public static ArrayList<ChatString> chat = new ArrayList<>();
    private boolean inventoryOpen;
    public static int stringWidth = 0;
    private final int CHAT_TOP = 580;
    private final int CHAT_CHAR_MAX = 135;
    public static Rectangle2D r;

    public HUD(Player player) {
        this.player = player;
        this.inventoryOpen = false;

        //Chat input
        Game.txtField.setVisible(true);
        Game.txtField.addActionListener(this);
        Game.txtField.setDocument(new JTextFieldLimit(CHAT_CHAR_MAX));
        Game.txtField.revalidate();
        Game.txtField.repaint();
    }

    /****************************************************
     * Name: 
     * Description: 
     ****************************************************/
    public void update() {
        if (Game.keyboard.keyDownOnce(KeyEvent.VK_I) && !inventoryOpen) {
            inventoryOpen = true;
        } else if (Game.keyboard.keyDownOnce(KeyEvent.VK_I) && inventoryOpen) {
            inventoryOpen = false;
        }
    }

    /****************************************************
     * Name: 
     * Description: 
     ****************************************************/
    public void render(Graphics g) {
        drawHealthEnergy(g);
        if (inventoryOpen) {
            g.drawImage(Resources.hud_inventory, 3, 80, null);
        }
        drawChatArea(g);
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

    public void drawChatArea(Graphics g) {
        g.setColor(new Color(0, 0, 0, 60));
        g.fillRect(0, 565, 400, 200);
        g.setColor(Color.WHITE);
        g.setFont(Resources.font_small);
        //Measure string width for txtField bounds check
        FontMetrics metrics = g.getFontMetrics(Resources.font_small);
        stringWidth = metrics.stringWidth(Game.txtField.getText());
        for (int i = 0; i < chat.size(); i++) {
            ChatString curr = chat.get(i);
            if (curr.getY() > CHAT_TOP) {
                g.drawString(curr.getMsg(), curr.getX(), curr.getY());
            }
        }
    }

    /****************************************************
     * Name: actionPerformed
     * Description: Called when enter is hit, via the
     * text field for the chat client. Appends text
     * from text field into the text area for viewing.
     ****************************************************/
    @Override
    public void actionPerformed(ActionEvent e) {
        String text = Game.txtField.getText();
        if (!text.isEmpty()) {

            Sender.sendChatMessage(text);
            for (int i = 0; i < chat.size(); i++) {
                ChatString curr = chat.get(i);
                curr.setY(chat.get(i).getY() - 20);
            }
            chat.add(new ChatString(text, chat.size() + 1));
            Game.txtField.selectAll();
            Game.txtField.setText("");
        }
    }
}
