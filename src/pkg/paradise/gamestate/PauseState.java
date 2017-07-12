package pkg.paradise.gamestate;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import pkg.paradise.main.Game;

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
        g.setFont(Game.font);
        g.setColor(Color.WHITE);
        g.drawString("FUCKING MENU", 10, 100);
    }

    /****************************************************
     * Name: handleInput
     * Description: 
     ****************************************************/
    @Override
    public void handleInput() {
        if (keyboard.keyDownOnce(KeyEvent.VK_ESCAPE)) {
            gsm.setPaused(false);
        }
    }
}
