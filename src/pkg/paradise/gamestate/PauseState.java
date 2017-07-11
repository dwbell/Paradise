package pkg.paradise.gamestate;

import java.awt.Graphics;
import pkg.paradise.utility.Keyboard;

public class PauseState extends GameState {

    public PauseState(GameStateManager gsm, Keyboard keyboard) {
        super(gsm, keyboard);
    }

    /****************************************************
     * Name: init
     * Description: 
     ****************************************************/
    @Override
    public void init() {
    }

    /****************************************************
     * Name: update
     * Description: Update keyboard and handle user input 
     ****************************************************/
    @Override
    public void update() {
        keyboard.update();
        handleInput();
    }

    /****************************************************
     * Name: render
     * Description: 
     ****************************************************/
    @Override
    public void render(Graphics g) {
        g.drawString("FUCK OFF", 10, 10);
    }

    /****************************************************
     * Name: handleInput
     * Description: 
     ****************************************************/
    @Override
    public void handleInput() {
        if (keyboard.pause()) {
            gsm.setPaused(false);
        }
    }
}
