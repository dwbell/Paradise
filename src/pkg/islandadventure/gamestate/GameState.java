package pkg.islandadventure.gamestate;

import java.awt.Graphics;
import pkg.islandadventure.input.Keyboard;

public abstract class GameState {

    protected static final int SCREEN_WIDTH = 256;
    protected static final int SCREEN_HEIGHT = 256;
    protected static final int SCALE = 3;
    
    protected GameStateManager gsm;
    protected Keyboard keyboard;

    public GameState(GameStateManager gsm, Keyboard keyboard) {
        this.gsm = gsm;
        this.keyboard = keyboard;
    }

    public abstract void init();

    public abstract void update();

    public abstract void draw(Graphics g);
    
    public abstract void handleInput();
}
