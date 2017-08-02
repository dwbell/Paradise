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

        //North
        if (dir == 0) {
            sprite = Sprite.player_up;
            if (moving) {
                if (anim % 20 > 10) {
                    sprite = Sprite.player_up_1;
                } else {
                    sprite = Sprite.player_up_2;
                }
            }
        }
        //East
        if (dir == 1) {
            sprite = Sprite.player_right;
            if (moving) {
                if (anim % 20 > 10) {
                    sprite = Sprite.player_right_1;
                } else {
                    sprite = Sprite.player_right_2;
                }
            }
        }
        //South
        if (dir == 2) {
            sprite = Sprite.player_down;
            if (moving) {
                if (anim % 20 > 10) {
                    sprite = Sprite.player_down_1;
                } else {
                    sprite = Sprite.player_down_2;
                }
            }
        }
        //West
        if (dir == 3) {
            sprite = Sprite.player_left;
            if (moving) {
                if (anim % 20 > 10) {
                    sprite = Sprite.player_left_1;
                } else {
                    sprite = Sprite.player_left_2;
                }
            }
        }
    }

    @Override
    public void render(Screen screen) {
        screen.renderPlayer(x - 16, y - 16, sprite);
    }
}
