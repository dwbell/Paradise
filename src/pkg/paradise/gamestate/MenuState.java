package pkg.paradise.gamestate;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import pkg.paradise.main.Game;
import pkg.paradise.utility.Keyboard;

public class MenuState extends GameState{
    
    private BufferedImage bg;
    
    public MenuState(GameStateManager gsm, Keyboard keyboard) {
        super(gsm, keyboard);
    }

    @Override
    public void init() {
        try {
            bg = ImageIO.read(getClass().getResourceAsStream("/Menu.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update() {
        
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawImage(bg, 0, 0, Game.SCREEN_WIDTH * Game.SCALE, Game.SCREEN_HEIGHT * Game.SCALE, null);
    }

    @Override
    public void handleInput() {
        if(keyboard.enter()){
            
        }
    }
    
}
