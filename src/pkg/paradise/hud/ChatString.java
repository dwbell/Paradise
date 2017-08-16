package pkg.paradise.hud;

import java.awt.Graphics;

public class ChatString {

    private final String msg;
    private boolean visible;
    private int index = 0;
    private final int SX = 2;
    private final int SY = 730;
    private int x = SX;
    private int y = SY;

    public ChatString(String msg, int index) {
        this.msg = msg;
        this.index = index;
        this.visible = true;
    }

    public void update() {
        if (this.y < 580) {
            this.visible = false;
        }
    }

    public void render(Graphics g) {

    }

    public boolean isVisible() {
        return this.visible;
    }

    public int getIndex() {
        return this.index;
    }

    public String getMsg() {
        return this.msg;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
