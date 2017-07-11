package pkg.paradise.gamestate;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import pkg.paradise.main.Game;
import pkg.paradise.utility.Keyboard;

public class MenuState extends GameState {

    private BufferedImage bg;

    public MenuState(GameStateManager gsm, Keyboard keyboard) {
        super(gsm, keyboard);
    }

     /****************************************************
     * Name: init
     * Description: Initializes Menu image
     ****************************************************/
    @Override
    public void init() {
        try {
            bg = ImageIO.read(getClass().getResourceAsStream("/Menu.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     /****************************************************
     * Name: update
     * Description: Update keyboard and check user input 
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
        g.setColor(Color.BLACK);
        g.drawImage(bg, 0, 0, Game.SCREEN_WIDTH * Game.SCALE, Game.SCREEN_HEIGHT * Game.SCALE, null);
    }

    /****************************************************
     * Name: handleInput
     * Description: 
     ****************************************************/
    @Override
    public void handleInput() {
        if (keyboard.enter()) {
            gsm.setState(GameStateManager.PLAY);
        }
    }

}
