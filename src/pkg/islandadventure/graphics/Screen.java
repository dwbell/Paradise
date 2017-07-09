package pkg.islandadventure.graphics;

import pkg.islandadventure.level.tile.Tile;

public class Screen {

    private final int MAP_SIZE = 64;
    public int xOffset, yOffset;
    public int width;
    public int height;
    public int[] pixels;
    public int[] tiles = new int[MAP_SIZE * MAP_SIZE];

    public Screen(int widthParam, int heightParam) {

        this.width = widthParam;
        this.height = heightParam;
        pixels = new int[width * height];

    }

    /****************************************************
     * Name:        clear
     * Description: Clears the pixels in array 
     ****************************************************/
    public void clear() {

        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = 0;
        }
    }

    /****************************************************
     * Name:        renderTile
     * Description: Only renders tiles. xp and yp are 
     * are individual positions of a tile. xa and ya are 
     * absolute values in the "world". 
     ****************************************************/
    public void renderTile(int xp, int yp, Tile tile) {
        xp -= xOffset;
        yp -= yOffset;
        for (int y = 0; y < tile.sprite.getSpriteSize(); y++) {
            int ya = y + yp; //y=0-15 (pixel), yp= tile on map
            for (int x = 0; x < tile.sprite.getSpriteSize(); x++) {
                int xa = x + xp;
                //Only rendering what is visible on screen
                if (xa < -tile.sprite.getSpriteSize() || xa >= width || ya < 0 || ya >= width) {
                    break;
                }
                if (xa < 0) {
                    xa = 0;
                }
                //Rendering what is on screen = rendering the pixels from a sprite
                pixels[xa + ya * width] = tile.sprite.pixels[x + y * tile.sprite.getSpriteSize()];
            }
        }
    }

    /****************************************************
     * Name:        renderPlayer
     * Description: Only renders player. Extremely similar
     * to the above renderTile method. 
     ****************************************************/
    public void renderPlayer(int xp, int yp, Sprite sprite) {
        xp -= xOffset;
        yp -= yOffset;
        for (int y = 0; y < 16; y++) {
            int ya = y + yp; //y=0-15 (pixel), yp= tile on map
            for (int x = 0; x < 16; x++) {
                int xa = x + xp;
                //Only rendering what is visible on screen
                if (xa < - 16 || xa >= width || ya < 0 || ya >= width) {
                    break;
                }
                if (xa < 0) {
                    xa = 0;
                }
                int color = sprite.pixels[x + y * 16];

                //Removing "pink border" from sprite
                if (color != 0xffff00ff) {
                    pixels[xa + ya * width] = sprite.pixels[x + y * 16];
                }
            }
        }
    }

    /****************************************************
     * Name:        setOffset
     * Description: Sets the offset for the map, which
     * which displaces tiles according to position (pixels)
     ****************************************************/
    public void setOffset(int xOffset, int yOffset) {
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }
}
