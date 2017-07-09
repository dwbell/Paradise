package pkg.islandadventure.level.tile;

import pkg.islandadventure.graphics.Screen;
import pkg.islandadventure.graphics.Sprite;

public class VoidTile extends Tile {

    public VoidTile(Sprite spriteParam) {
        super(spriteParam);
    }

    @Override
    public void render(int x, int y, Screen screen){
        screen.renderTile(x << 4, y << 4, this);
    }
}
