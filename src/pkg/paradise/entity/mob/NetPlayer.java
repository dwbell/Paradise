package pkg.paradise.entity.mob;

import pkg.paradise.graphics.Screen;
import pkg.paradise.graphics.Sprite;

public class NetPlayer extends Mob {

    private final double ANIM_TIMER = 0.0395;
    private int selection = 0;
    
    public NetPlayer(int selection, int x, int y) {
        this.selection = selection;
        this.x = x;
        this.y = y;
        this.sprite = Sprite.ALL_CHARACTERS.get(selection)[0][0];
    }

    /****************************************************
     * Name: update
     * Description: Simply animates a networked player. 
     * The ACTUAL DATA is sent directly from the receiving
     * thread.
     ****************************************************/
    @Override
    public void update(float delta) {
        super.animate(delta, ANIM_TIMER, selection);
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
