package pkg.paradise.level.tile;

import pkg.paradise.graphics.Screen;
import pkg.paradise.graphics.Sprite;
import pkg.paradise.level.tile.Tile;


public class WaterTile extends Tile {

    public WaterTile(Sprite sprite){
        super(sprite);
    }
    
    @Override
    public void render(int x, int y, Screen screen){
        screen.renderTile(x << 4, y << 4, this);
    }
}
