package pkg.paradise.gamestate;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import pkg.paradise.entity.mob.Player;
import pkg.paradise.graphics.Screen;
import pkg.paradise.utility.Keyboard;
import pkg.paradise.level.Level;
import pkg.paradise.level.SpawnLevel;
import pkg.paradise.level.TileCoordinate;
import pkg.paradise.main.Game;

public class PlayState extends GameState {

    private Level level;
    private Player player;
    private Screen screen;

    private BufferedImage image = new BufferedImage(Game.SCREEN_WIDTH, Game.SCREEN_HEIGHT, BufferedImage.TYPE_INT_RGB);
    private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

    public PlayState(GameStateManager gsm, Keyboard keyboard) {
        super(gsm, keyboard);
    }

    @Override
    public void init() {
        screen = new Screen(Game.SCREEN_WIDTH, Game.SCREEN_HEIGHT);
        level = new SpawnLevel("/textures/level.png");
        TileCoordinate playerSpawn = new TileCoordinate(5, 5);
        player = new Player(playerSpawn.x(), playerSpawn.y(), keyboard);
        player.init(level);
    }

    @Override
    public void update() {
        keyboard.update();
        handleInput();
        player.update();
        int xScroll = player.x - screen.width / 2;
        int yScroll = player.y - screen.height / 2;
        level.update(xScroll, yScroll, screen);
    }

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
        System.arraycopy(screen.pixels, 0, pixels, 0, pixels.length);
        g.drawImage(image, 0, 0, Game.SCREEN_WIDTH * Game.SCALE, Game.SCREEN_HEIGHT * Game.SCALE, null);
    }

    @Override
    public void handleInput() {
        System.out.println(keyboard.pause());
        if (keyboard.pause()) {
            gsm.setPaused(true);
        }
    }

}
