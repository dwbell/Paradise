package pkg.islandadventure.level.tile;

import pkg.islandadventure.graphics.Screen;
import pkg.islandadventure.graphics.Sprite;
import pkg.islandadventure.level.tile.Tile;


public class WaterTile extends Tile {

    public WaterTile(Sprite sprite){
        super(sprite);
    }
    
    @Override
    public void render(int x, int y, Screen screen){
        screen.renderTile(x << 4, y << 4, this);
    }
}
