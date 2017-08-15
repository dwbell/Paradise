package pkg.paradise.main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import pkg.paradise.gamestate.GameStateManager;
import pkg.paradise.utility.Keyboard;
import pkg.paradise.utility.Mouse;
import pkg.paradise.utility.Resources;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;

public class Game extends Canvas implements Runnable {

    //Window
    private static final long serialVersionUID = 1L;
    public static final int SCREEN_WIDTH = 256;
    public static final int SCREEN_HEIGHT = 256;
    public static final int SCALE = 3;
    private static final String TITLE = "Paradise";

    //Loop
    private Thread thread;
    public JFrame frame;
    private boolean running = false;
    private final long SLEEP_TIME = 5L;

    //Declarations
    public static Keyboard keyboard;
    private GameStateManager gsm;
    private final Resources resources;

    public Game() {

        //JFrame Size
        Dimension size = new Dimension(SCREEN_WIDTH * SCALE, SCREEN_HEIGHT * SCALE);
        setPreferredSize(size);
        setFocusable(true);
        requestFocus();

        //Initializing Classes
        resources = new Resources();
        frame = new JFrame();
        keyboard = new Keyboard();

        //Game State Manager
        gsm = new GameStateManager();

        //Input Listening
        addKeyListener(keyboard);
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
    @Override
    public void run() {
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        final double ns = 1000000000.0 / 60.0;
        double difference = 0;
        int updates = 0;
        int frames = 0;
        double nsPerFrame;
        requestFocus();

        while (running) {
            //Math to only call updates ~60 times per second
            long now = System.nanoTime();
            difference += (now - lastTime) / ns;
            nsPerFrame = now - lastTime;
            lastTime = now;
            while (difference >= 1) {
                update((float) (nsPerFrame / 1.0E9)); //Restricted
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
            sleep(SLEEP_TIME);
        }
        stop();
    }

    /****************************************************
     * Name:        update
     * Description: Restricted to updating ~60 times per
     * second. 
     ****************************************************/
    public void update(float delta) {
        gsm.update(delta);
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
            gsm.render(g);
        }

        g.dispose(); //manual garbage collection
        bs.show(); //makes next buffer available
    }

    public void sleep(long sleep) {
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException ex) {
        }
    }

    /***********
     Main Class
     ************/
    public static JTextField txtField;
    public static JTextArea txtArea;
    public static JScrollPane sPane;
    public static JLayeredPane layeredPane;

    public static void main(String[] args) {
        Game game = new Game();
        game.frame.setResizable(false);
        game.frame.setTitle("Paradise");

        //Chat input
        txtField = new JTextField();
        txtField.setEditable(true);
        txtField.setBounds(2, 740, 395, 20);
        txtField.setVisible(false);
        txtField.setBorder(null);
        game.frame.add(txtField);

        
        game.frame.add(game);
        game.frame.pack();
        game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.frame.setLocationRelativeTo(null);
        game.frame.setVisible(true);

        game.start();
    }
}
