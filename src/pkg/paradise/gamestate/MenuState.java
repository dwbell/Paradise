package pkg.paradise.gamestate;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import pkg.paradise.main.Game;
import pkg.paradise.utility.Resources;

public class MenuState extends GameState {

    public MenuState(GameStateManager gsm) {
        super(gsm);
    }

    /****************************************************
     * Name: init
     * Description: Initializes Menu image
     ****************************************************/
    @Override
    public void init() {
       
    }

    /****************************************************
     * Name: update
     * Description: Update keyboard and check user input 
     ****************************************************/
    @Override
    public void update() {
        Game.keyboard.update();
        handleInput();
    }

    /****************************************************
     * Name: render
     * Description: 
     ****************************************************/
    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawImage(Resources.start_menu, 0, 0, Game.SCREEN_WIDTH * Game.SCALE, Game.SCREEN_HEIGHT * Game.SCALE, null);
    }

    /****************************************************
     * Name: handleInput
     * Description: 
     ****************************************************/
    @Override
    public void handleInput() {
        if (Game.keyboard.keyDownOnce(KeyEvent.VK_ENTER)) {
            gsm.setState(GameStateManager.PLAY);
        }
    }

}
