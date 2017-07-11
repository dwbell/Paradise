package pkg.paradise.gamestate;

import java.awt.Graphics;
import pkg.paradise.utility.Keyboard;

public class PauseState extends GameState {

    public PauseState(GameStateManager gsm, Keyboard keyboard) {
        super(gsm, keyboard);
    }

    @Override
    public void init() {
    }

    @Override
    public void update() {
        keyboard.update();
        handleInput();
    }

    @Override
    public void render(Graphics g) {
        g.drawString("FUCK OFF", 10, 10);
    }

    @Override
    public void handleInput() {
        if (keyboard.pause()) {
            gsm.setPaused(false);
        }
    }
}
