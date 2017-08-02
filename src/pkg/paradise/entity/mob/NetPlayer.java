package pkg.paradise.entity.mob;

import pkg.paradise.graphics.Screen;
import pkg.paradise.graphics.Sprite;

public class NetPlayer extends Mob {

    private int anim = 0;

    public NetPlayer() {
        this.sprite = Sprite.player_down;
    }

    public NetPlayer(int x, int y) {
        this.x = x;
        this.y = y;
        this.sprite = Sprite.player_down;
    }

    @Override
    public void update() {
        //Capping animation cycle
        if (anim < 7500) {
            anim++;
        } else {
            anim = 0;
        }

        if (moving) {
            if (dir == 0) {
                sprite = Sprite.player_up;
            }
            if (dir == 1) {
                sprite = Sprite.player_right;
            }
            if (dir == 2) {
                sprite = Sprite.player_down;
            }
            if (dir == 3) {
                sprite = Sprite.player_left;
            }
        }
    }

    @Override
    public void render(Screen screen) {
        screen.renderPlayer(x - 16, y - 16, sprite);
    }
}
