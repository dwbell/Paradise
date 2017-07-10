package pkg.paradise.level;

import java.util.Random;
import pkg.paradise.graphics.Screen;
import pkg.paradise.level.tile.Tile;

public class Level {

    protected int width, height;
    protected int[] tiles;//all the levels tiles
    protected Random rand;

    //Holding the hexadecimal color value for a given tile
    protected final static int grass = 0xff00ff21;
           
    //Random level constructor
    public Level(int width, int height) {
        this.width = width;
        this.height = height;
        generateLevel();
    }

    //Level from file constructor
    public Level(String path) {
        rand = new Random(System.currentTimeMillis());
        loadLevel(path);
        generateLevel();
    }

    /****************************************************
     * Name:        generateLevel
     * Description: Overridable method
     ****************************************************/
    protected void generateLevel() {

    }

    /****************************************************
     * Name:        loadLevel
     * Description: Overridable method that is the basis
     * for loading a level from file
     ****************************************************/
    protected void loadLevel(String path) {

    }

    /****************************************************
     * Name:        update
     * Description: Udates player position to screen's 
     * offset value.
     ****************************************************/
    public void update(int xScroll, int yScroll, Screen screen) {
        screen.setOffset(xScroll, yScroll);

    }

    /****************************************************
     * Name:        render
     * Description: Levels render method which is called
     * from Game class. Renders the level using "corner pins"
     * x0 = left, x1 = right, y0 = top, y1 = bottom to 
     * only render what is visible on screen.
     ****************************************************/
    public void render(int xScroll, int yScroll, Screen screen) {
        screen.setOffset(xScroll, yScroll);
        int x0 = xScroll >> 4;
        int x1 = (xScroll + screen.width + 16) >> 4;
        int y0 = yScroll >> 4;
        int y1 = (yScroll + screen.height + 16) >> 4;

        //Grabbing tiles that are within screen bounds
        for (int y = y0; y < y1; y++) {
            for (int x = x0; x < x1; x++) {
                getTile(x, y).render(x, y, screen);
            }
        }
    }

    /****************************************************
     * Name:        getTile
     * Description: Called from Levels render, this
     * method returns the tile from its x,y position
     ****************************************************/
    public Tile getTile(int x, int y) {
        if (x < 0 || y < 0 || x >= width || y >= height) {
            return Tile.water;
        }
        //Grass
        if (tiles[x + y * width] == grass) {
            return Tile.grass;
        }

        return Tile.voidTile;
    }

    /****************************************************
     * Name:        time
     * Description: Overridable method that gives a level
     * an attribute of time
     ****************************************************/
    private void time() {

    }

}
