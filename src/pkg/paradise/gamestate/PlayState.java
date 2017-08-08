package pkg.paradise.gamestate;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.IOException;
import java.net.DatagramSocket;
import java.util.HashMap;
import pkg.paradise.client.*;
import pkg.paradise.entity.mob.NetPlayer;
import pkg.paradise.entity.mob.Player;
import pkg.paradise.graphics.Screen;
import pkg.paradise.hud.HUD;
import pkg.paradise.level.Level;
import pkg.paradise.level.SpawnLevel;
import pkg.paradise.level.TileCoordinate;
import pkg.paradise.main.Game;

public class PlayState extends GameState {

    private Level level;
    public static Player player;
    public static HashMap<String, NetPlayer> netPlayers;
    public static Receiver receiver;
    private Screen screen;
    private HUD hud;

    private BufferedImage image = new BufferedImage(Game.SCREEN_WIDTH, Game.SCREEN_HEIGHT, BufferedImage.TYPE_INT_RGB);
    private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

    public PlayState(GameStateManager gsm) {
        super(gsm);
    }

    /****************************************************
     * Name: init
     * Description: Initialize screen, level, and player. 
     ****************************************************/
    @Override
    public void init() {
        screen = new Screen(Game.SCREEN_WIDTH, Game.SCREEN_HEIGHT);
        level = new SpawnLevel("/sprites/level.png");
        TileCoordinate playerSpawn = new TileCoordinate(5, 5);
        player = new Player(playerSpawn.x(), playerSpawn.y());
        player.init(level);
        hud = new HUD(player);

        //Network
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Sender.setSocket(socket);
        //sender = new Sender(socket);
        receiver = new Receiver(socket);
        netPlayers = new HashMap<>();
        
        //Network receive message 
        Thread rt = new Thread(receiver);
        rt.start();

    }

    /****************************************************
     * Name: update
     * Description: Update keyboard, user input, and 
     * adjust the values for which the screen is centered.
     ****************************************************/
    @Override
    public void update(float delta) {
        Game.keyboard.update();
        handleInput();
        player.update(delta);
        hud.update();

        Sender.update();
        for (NetPlayer np : netPlayers.values()) {
            np.update(delta);
        }
       
        int xScroll = player.x - screen.width / 2;
        int yScroll = player.y - screen.height / 2;
        level.update(xScroll, yScroll, screen);
    }

    /****************************************************
     * Name: render
     * Description: Draws the entirety of the 'Play' 
     * game state. 
     ****************************************************/
    @Override
    public void render(Graphics g) {
        screen.clear();

        //Setting player to center of screen
        int xScroll = player.x - screen.width / 2;
        int yScroll = player.y - screen.height / 2;
        //Levels render
        level.render(xScroll, yScroll, screen);
        //Putting player on screen
        player.render(screen);

        for (NetPlayer np : netPlayers.values()) {
            np.render(screen);
        }

        //Drawing up screen
        System.arraycopy(screen.pixels, 0, pixels, 0, pixels.length);
        g.drawImage(image, 0, 0, Game.SCREEN_WIDTH * Game.SCALE, Game.SCREEN_HEIGHT * Game.SCALE, null);

        //HUD
        hud.render(g);
    }

    /****************************************************
     * Name: handleInput
     * Description: Sets the game state to 'Paused'
     ****************************************************/
    @Override
    public void handleInput() {
        if (Game.keyboard.keyDownOnce(KeyEvent.VK_ESCAPE)) {
            gsm.setPaused(true);
        }
    }
}
