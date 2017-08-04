package pkg.paradise.gamestate;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import pkg.paradise.main.Game;
import pkg.paradise.utility.Resources;

public class IntroState extends GameState {

    private int alpha;
    private int ticks;

    private final int FADE_IN = 80;
    private final int LENGTH = 60;
    private final int FADE_OUT = 60;

    public IntroState(GameStateManager gsm) {
        super(gsm);
    }

    /****************************************************
     * Name: init
     * Description: Initializes logo image
     ****************************************************/
    @Override
    public void init() {
        ticks = 0;
    }

    /****************************************************
     * Name: update
     * Description: Creates a fade in / fade out effect
     * for the opening logo. Will also change states
     * once animation is done.
     ****************************************************/
    @Override
    public void update(float delta) {
        Game.keyboard.update();
        handleInput();
        ticks++;
        if (ticks < FADE_IN) {
            alpha = (int) (255 - 255 * (1.0 * ticks / FADE_IN));
            if (alpha < 0) {
                alpha = 0;
            }
        }
        if (ticks > FADE_IN + LENGTH) {
            alpha = (int) (255 * (1.0 * ticks - FADE_IN - LENGTH) / FADE_OUT);
            if (alpha > 255) {
                alpha = 255;
            }
        }
        if (ticks > FADE_IN + LENGTH + FADE_OUT) {
            gsm.setState(GameStateManager.MENU);
        }
    }

    /****************************************************
     * Name: render
     * Description: Draws up logo and effects
     ****************************************************/
    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, Game.SCREEN_WIDTH, Game.SCREEN_HEIGHT);
        g.drawImage(Resources.company_logo, 0, 0, Game.SCREEN_WIDTH * Game.SCALE, Game.SCREEN_HEIGHT * Game.SCALE, null);
        g.setColor(new Color(0, 0, 0, alpha));
        g.fillRect(0, 0, Game.SCREEN_WIDTH * Game.SCALE, Game.SCREEN_HEIGHT * Game.SCALE);
    }

    /****************************************************
     * Name: handleInput
     * Description: If enter is pressed immediately jump to 
     * menu state. 
     ****************************************************/
    public void handleInput() {
        if (Game.keyboard.keyDownOnce(KeyEvent.VK_ENTER)) {
            gsm.setState(GameStateManager.MENU);
        }
    }
}
