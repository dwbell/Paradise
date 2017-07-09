package pkg.islandadventure.level.tile;

import pkg.islandadventure.graphics.Screen;
import pkg.islandadventure.graphics.Sprite;

public class Tile {

    public int x, y;
    public Sprite sprite;

    //Creating static tiles
    public static Tile grass = new GrassTile(Sprite.grass);

    //Water Tile
    public static Tile water = new WaterTile(Sprite.water);
    
    //Void Tile
    public static Tile voidTile = new VoidTile(Sprite.voidSprite);

    public Tile(Sprite spriteParam) {
        this.sprite = spriteParam;
    }

    /****************************************************
     * Name:        render
     * Description: Tiles render method which is called 
     * from Screen class.
     ****************************************************/
    public void render(int x, int y, Screen screen) {
        
    }
    

    /****************************************************
     * Name:        solid
     * Description: Gives an attribute of solid, which 
     * determines ability of collision detection.
     ****************************************************/
    public boolean solid() {
        return false;
    }
}
