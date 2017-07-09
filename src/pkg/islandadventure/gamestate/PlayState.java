package pkg.islandadventure.gamestate;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import pkg.islandadventure.entity.mob.Player;
import pkg.islandadventure.graphics.Screen;
import pkg.islandadventure.input.Keyboard;
import pkg.islandadventure.level.Level;
import pkg.islandadventure.level.SpawnLevel;
import pkg.islandadventure.level.TileCoordinate;


public class PlayState extends GameState  {

    private Level level;
    private Player player;
    private Screen screen;
    private Keyboard key;
    
    private BufferedImage image = new BufferedImage(SCREEN_WIDTH, SCREEN_HEIGHT, BufferedImage.TYPE_INT_RGB);
    private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

    private static final int SCREEN_WIDTH = 256;
    private static final int SCREEN_HEIGHT = 256;

    public PlayState(GameStateManager gsm, Keyboard key) {
        super(gsm);
        this.key = key;
        
    }

    @Override
    public void init() {
        screen = new Screen(SCREEN_WIDTH, SCREEN_HEIGHT);
        level = new SpawnLevel("/textures/level.png");
        TileCoordinate playerSpawn = new TileCoordinate(5, 5);
        player = new Player(playerSpawn.x(), playerSpawn.y(), key);
        player.init(level);
    }

    @Override
    public void update() {
        key.update();
        player.update();
        int xScroll = player.x - screen.width / 2;
        int yScroll = player.y - screen.height / 2;
        level.update(xScroll, yScroll, screen);
    }

    @Override
    public void draw(Graphics g) {
        screen.clear();
        
        //Setting player to center of screen
        int xScroll = player.x - screen.width / 2;
        int yScroll = player.y - screen.height / 2;
        //Levels render
        level.render(xScroll, yScroll, screen);
        //Putting player on screen
        player.render(screen);
        System.arraycopy(screen.pixels, 0, pixels, 0, pixels.length);
        g.drawImage(image, 0, 0, SCREEN_WIDTH * 3, SCREEN_HEIGHT * 3, null);
    }
}
