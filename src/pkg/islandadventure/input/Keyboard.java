package pkg.islandadventure.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

    private boolean[] keys = new boolean[120];
    private boolean up, down, left, right, enter;

    /****************************************************
     * Name:        update
     * Description: Keyboards update method which is 
     * called from Games update method.
     ****************************************************/
    public void update() {
        up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
        down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
        enter = keys[KeyEvent.VK_ENTER];

    }

    /*********************************
     * Setting key code inputs into
     * correct position in "keys" array
     *********************************/
    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    /*********************************
     * Getter Methods
     *********************************/
    public boolean up() {
        return up;
    }

    public boolean down() {
        return down;
    }

    public boolean left() {
        return left;
    }

    public boolean right() {
        return right;
    }
    
    public boolean enter() {
        return enter;
    }

}
