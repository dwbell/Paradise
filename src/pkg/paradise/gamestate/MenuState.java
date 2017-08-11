package pkg.paradise.gamestate;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import pkg.paradise.graphics.Sprite;
import pkg.paradise.main.Game;
import pkg.paradise.utility.Resources;

public class MenuState extends GameState {

    private BufferedImage characterImage;
    private final int SIZE = 16;
    private final int SCALE = 6;
    public static int selection;

    public MenuState(GameStateManager gsm) {
        super(gsm);
    }

    /****************************************************
     * Name: init
     * Description: Initializes character image
     ****************************************************/
    @Override
    public void init() {
        selection = 0;
        characterImage = new BufferedImage(SIZE, SIZE, BufferedImage.TYPE_INT_ARGB);
        setCharacterImage();
    }

    /****************************************************
     * Name: update
     * Description: Update keyboard and check user input 
     ****************************************************/
    @Override
    public void update(float delta) {
        Game.keyboard.update();
        handleInput();
    }

    /****************************************************
     * Name: render
     * Description: 
     ****************************************************/
    @Override
    public void render(Graphics g) {
        g.drawImage(Resources.start_menu, 0, 0, Game.SCREEN_WIDTH * Game.SCALE, Game.SCREEN_HEIGHT * Game.SCALE, null);

        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(337, 247, 100, 100);
        g.setColor(Color.BLACK);
        g.drawRect(337, 247, 100, 100);
        g.drawImage(characterImage, 340, 250, SIZE * SCALE, SIZE * SCALE, null);

        g.setColor(Color.WHITE);
        g.setFont(Resources.font_medium);
        g.drawString("Select Character", 300, 210);
        g.drawString("A or <-  -> or D", 310, 234);
    }

    /****************************************************
     * Name: handleInput
     * Description: Handles character selection, as well 
     * as the ability to change to play state
     ****************************************************/
    @Override
    public void handleInput() {
        if (Game.keyboard.keyDownOnce(KeyEvent.VK_ENTER)) {
            gsm.setState(GameStateManager.PLAY);
        }

        if (Game.keyboard.keyDownOnce(KeyEvent.VK_A) || Game.keyboard.keyDownOnce(KeyEvent.VK_LEFT)) {
            selection--;
            if (selection == -1) {
                selection = 15;
            }
            setCharacterImage();
        }
        if (Game.keyboard.keyDownOnce(KeyEvent.VK_D) || Game.keyboard.keyDownOnce(KeyEvent.VK_RIGHT)) {
            selection++;
            if (selection == 16) {
                selection = 0;
            }
            setCharacterImage();
        }
    }

    /****************************************************
     * Name: setCharacterImage
     * Description: Based on the current selection, 
     * takes a Sprite array of a given character, and
     * loads up the default DOWN sprite.
     ****************************************************/
    public void setCharacterImage() {
        int[] tmp = new int[SIZE * SIZE];
        System.arraycopy(Sprite.ALL_CHARACTERS.get(selection)[0][0].pixels, 0, tmp, 0, SIZE * SIZE);
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] == -65281) {
                tmp[i] = 0xFFFFFF;
            }
        }
        characterImage.setRGB(0, 0, SIZE, SIZE, tmp, 0, characterImage.getWidth());
    }
}
