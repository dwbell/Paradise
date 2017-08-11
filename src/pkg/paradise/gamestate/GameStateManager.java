package pkg.paradise.gamestate;

import java.awt.Graphics;

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

    public GameStateManager() {
        paused = false;
        pauseState = new PauseState(this);

        gameStates = new GameState[NUM_STATES];
        setState(INTRO);

    }

    /****************************************************
     * Name: setPaused
     * Description: Sets paused state status
     ****************************************************/
    public void setPaused(boolean b) {
        paused = b;
    }

    /****************************************************
     * Name: setState
     * Description: Initializes the given game state. 
     * Is the control mechanism for switching states. 
     ****************************************************/
    public void setState(int state) {
        previousState = currentState;
        unloadState(previousState);
        currentState = state;

        switch (state) {
            case INTRO:
                gameStates[state] = new IntroState(this);
                gameStates[state].init();
                break;
            case MENU:
                gameStates[state] = new MenuState(this);
                gameStates[state].init();
                break;
            case PLAY:
                gameStates[state] = new PlayState(this);
                gameStates[state].init();
                break;
            case GAMEOVER:
                // gameStates[i] = new GameOverState(this);
                // gameStates[i].init();
                break;
            default:
                break;
        }
    }

    /****************************************************
     * Name: unloadState
     * Description: Sets a state to null
     ****************************************************/
    public void unloadState(int i) {
        gameStates[i] = null;
    }

     /****************************************************
     * Name: update
     * Description:  Updates with respect to a paused game
     ****************************************************/
    public void update(float delta) {
        if (paused) {
            pauseState.update(delta);
        } else if (gameStates[currentState] != null) {
            gameStates[currentState].update(delta);
        }
    }

     /****************************************************
     * Name: render
     * Description: Renders with respect to a paused game
     ****************************************************/
    public void render(Graphics g) {
        if (paused) {
            pauseState.render(g);
        } else if (gameStates[currentState] != null) {
            gameStates[currentState].render(g);
        }
    }

}
