package pkg.islandadventure.main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;
import pkg.islandadventure.gamestate.GameStateManager;
import pkg.islandadventure.input.Keyboard;
import pkg.islandadventure.input.Mouse;

public class Game extends Canvas implements Runnable {

    //Window
    private static final long serialVersionUID = 1L;
    private static final int SCREEN_WIDTH = 256;
    private static final int SCREEN_HEIGHT = 256;
    private static final int SCALE = 3;
    private static final String TITLE = "Island Adventure";

    private Thread thread;
    private JFrame frame;
    private boolean running = false;
    private static Keyboard key;
    private GameStateManager gsm;

    public Game() {

        //JFrame Size
        Dimension size = new Dimension(SCREEN_WIDTH * SCALE, SCREEN_HEIGHT * SCALE);
        setPreferredSize(size);
        setFocusable(true);
        requestFocus();

        //Initializing Classes
        frame = new JFrame();
        key = new Keyboard();

        //Game State Manager
        gsm = new GameStateManager(key);

        //Input Listening
        addKeyListener(key);
        Mouse mouse = new Mouse();
        addMouseListener(mouse);
        addMouseMotionListener(mouse);

    }

    /****************************************************
     * Name:        start 
     * Description: Initiates game loop and thread
     ****************************************************/
    public synchronized void start() {
        running = true;
        thread = new Thread(this, "Display");
        thread.start();
    }

    /****************************************************
     * Name:        stop
     * Description: Terminates game loop and thread
     ****************************************************/
    public synchronized void stop() {
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /****************************************************
     * Name:        run
     * Description: Actual game loop. Includes an FPS 
     * counter set to run at 60 frames per second. This 
     * method is machine independent. 
     ****************************************************/
    public void run() {
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        final double ns = 1000000000.0 / 60.0;
        double difference = 0;
        int updates = 0;
        int frames = 0;
        requestFocus();

        while (running) {

            //Math to only call updates ~60 times per second
            long now = System.nanoTime();
            difference += (now - lastTime) / ns;
            lastTime = now;
            while (difference >= 1) {
                update(); //Restricted
                updates++;
                difference--;
            }

            render(); //Unrestricted
            frames++;

            //Triggers once per second to update counters
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                frame.setTitle(TITLE + "  UPS: " + updates + "  FPS: " + frames);
                updates = 0;
                frames = 0;
            }
        }
        stop();
    }

    /****************************************************
     * Name:        update
     * Description: Restricted to updating ~60 times per
     * second. 
     ****************************************************/
    public void update() {
        gsm.update();
    }

    /****************************************************
     * Name:        render
     * Description: Unrestricted method in which the game
     * is rendered. Set up using "triple buffering".
     ****************************************************/
    public void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }

        //Graphics rendering
        Graphics g = bs.getDrawGraphics();
        {
            gsm.draw(g);
        }

        g.dispose(); //manual garbage collection
        bs.show(); //makes next buffer available
    }

    /***********
     Main Class
     ************/
    public static void main(String[] args) {
        Game game = new Game();
        game.frame.setResizable(false);
        game.frame.setTitle("Island Adventure");
        game.frame.add(game);
        game.frame.pack();
        game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.frame.setLocationRelativeTo(null);
        game.frame.setVisible(true);

        game.start();
    }
}
