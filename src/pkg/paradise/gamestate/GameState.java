package pkg.paradise.gamestate;

import java.awt.Graphics;

public abstract class GameState {

    protected GameStateManager gsm;

    public GameState(GameStateManager gsm) {
        this.gsm = gsm;
    }

    public abstract void init();

    public abstract void update(float delta);

    public abstract void render(Graphics g);

    public abstract void handleInput();
}
