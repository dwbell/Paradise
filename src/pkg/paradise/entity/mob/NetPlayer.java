package pkg.paradise.entity.mob;

import pkg.paradise.graphics.Screen;
import pkg.paradise.graphics.Sprite;

public class NetPlayer extends Mob {

    private double aTimer;
    private int currAnim = 0;
    private final double ANIM_TIMER = .0495;

    public NetPlayer() {
        this.sprite = Sprite.PLAYER_DOWN;
    }

    public NetPlayer(int x, int y) {
        this.x = x;
        this.y = y;
        this.sprite = Sprite.PLAYER_DOWN;
    }

    @Override
    public void update(float delta) {
        //Running animation sequence
        //dir = 0:Down, 1:Right, 2:Left, 3:Up
        aTimer += delta;
        if (moving) {
            if (aTimer > ANIM_TIMER) {
                sprite = Sprite.PLAYER_SPRITES[dir][currAnim];
                if (currAnim == 2) {
                    currAnim = 0;
                } else {
                    currAnim++;
                }
                aTimer = 0;
            }
        } else {
            sprite = Sprite.PLAYER_SPRITES[dir][0];
            currAnim = 0;
        }

    }

    @Override
    public void render(Screen screen) {
        screen.renderPlayer(x - 16, y - 16, sprite);
    }
}
