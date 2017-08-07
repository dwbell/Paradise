package pkg.paradise.entity.mob;

import pkg.paradise.graphics.Screen;
import pkg.paradise.graphics.Sprite;

public class NetPlayer extends Mob {

   private final double ANIM_TIMER = 0.0495;
   
    public NetPlayer() {
        this.sprite = Sprite.PLAYER_SPRITES[0][0];
    }

    public NetPlayer(int x, int y) {
        this.x = x;
        this.y = y;
        this.sprite = Sprite.PLAYER_SPRITES[0][0];
    }

    /****************************************************
     * Name: update
     * Description: Simply animates a networked player. 
     * The ACTUAL DATA is sent directly from the receiving
     * thread.
     ****************************************************/
    @Override
    public void update(float delta) {
        animate(delta, ANIM_TIMER, "Player");
    }

    /****************************************************
     * Name: render
     * Description: Renders a net player to screen
     ****************************************************/
    @Override
    public void render(Screen screen) {
        screen.renderPlayer(x - 16, y - 16, sprite);
    }
}
