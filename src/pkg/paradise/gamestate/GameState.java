package pkg.paradise.gamestate;

import java.awt.Graphics;
import pkg.paradise.utility.Keyboard;


public abstract class GameState {

    protected GameStateManager gsm;
    protected Keyboard keyboard;

    public GameState(GameStateManager gsm, Keyboard keyboard) {
        this.gsm = gsm;
        this.keyboard = keyboard;
    }

    public abstract void init();

    public abstract void update();

    public abstract void render(Graphics g);

    public abstract void handleInput();
}
