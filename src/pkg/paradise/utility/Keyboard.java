package pkg.paradise.utility;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

    private boolean[] keys;
    private int[] polled;
    private boolean up, down, left, right, enter, pause;

    public Keyboard() {
        keys = new boolean[256];
        polled = new int[256];
    }

    public void update() {
        poll();
    }

    public boolean keyDown(int keyCode) {
        return polled[keyCode] > 0;
    }

    public boolean keyDownOnce(int keyCode) {
        return polled[keyCode] == 1;

    }

    public synchronized void poll() {
        for (int i = 0; i < keys.length; ++i) {
            if (keys[i]) {
                polled[i]++;
            } else {
                polled[i] = 0;
            }
        }
    }

    @Override
    public synchronized void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode >= 0 && keyCode < keys.length) {
            keys[keyCode] = true;
        }
    }

    @Override
    public synchronized void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode >= 0 && keyCode < keys.length) {
            keys[keyCode] = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not needed
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

    public boolean pause() {
        return pause;
    }
}
