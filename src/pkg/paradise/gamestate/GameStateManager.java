package pkg.paradise.gamestate;

import java.awt.Graphics;
import pkg.paradise.utility.Keyboard;

public class GameStateManager {

    private boolean paused;
    private PauseState pauseState;

    private GameState[] gameStates;
    private int currentState;
    private int previousState;

    public static final int NUM_STATES = 4;
    public static final int INTRO = 0;
    public static final int MENU = 1;
    public static final int PLAY = 2;
    public static final int GAMEOVER = 3;

    private Keyboard keyboard;

    public GameStateManager(Keyboard keyboard) {
        this.keyboard = keyboard;
        paused = false;
        pauseState = new PauseState(this, keyboard);

        gameStates = new GameState[NUM_STATES];
        setState(INTRO);

    }

    public void setPaused(boolean b) {
        paused = b;
    }

    public void setState(int state) {
        previousState = currentState;
        unloadState(previousState);
        currentState = state;

        switch (state) {
            case INTRO:
                gameStates[state] = new IntroState(this, keyboard);
                gameStates[state].init();
                break;
            case MENU:
                gameStates[state] = new MenuState(this, keyboard);
                gameStates[state].init();
                break;
            case PLAY:
                gameStates[state] = new PlayState(this, keyboard);
                gameStates[state].init();
                break;
            //  gameStates[i] = new GameOverState(this);
            // gameStates[i].init();
            case GAMEOVER:
                break;
            default:
                break;
        }
    }

    public void unloadState(int i) {
        gameStates[i] = null;
    }

    public void update() {
        if (paused) {
            pauseState.update();
        } else if (gameStates[currentState] != null) {
            gameStates[currentState].update();
        }
    }

    public void render(Graphics g) {
        if (paused) {
            pauseState.render(g);
        } else if (gameStates[currentState] != null) {
            gameStates[currentState].render(g);
        }
    }

}
