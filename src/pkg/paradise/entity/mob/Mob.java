package pkg.paradise.entity.mob;

import pkg.paradise.entity.Entity;
import pkg.paradise.graphics.Sprite;

public abstract class Mob extends Entity {

    protected Sprite sprite;
    protected int dir = 2;
    protected boolean moving = false;

    /****************************************************
     * Name:        move
     * Description: This method controls mob direction,
     * and also checks for collision detection of a given 
     * mob.
     ****************************************************/
    public void move(int xMove, int yMove) {
        //Controlling mob direction
        if (xMove > 0) {
            dir = 1;
        }
        if (xMove < 0) {
            dir = 3;
        }
        if (yMove > 0) {
            dir = 2;
        }
        if (yMove < 0) {
            dir = 0;
        }

        //Collision detection for movement
        if (!collision(0, yMove)) {
            y += yMove;
        }

        if (!collision(xMove, 0)) {
            x += xMove;
        }
    }

    @Override
    public void update() {

    }

    public void render() {

    }

    private boolean collision(int xMove, int yMove) {
        boolean solid = false;
        for (int c = 0; c < 4; c++) {
            //+ c % 2 *(collision width) - (pixel shift)
            int xt = ((x + xMove) + c % 2 * 9 - 13) / 16;
            int yt = ((y + yMove) + c / 2 * 5 - 8) / 16;
            if (level.getTile(xt, yt).solid()) {
                solid = true;
            }
        }

        return solid;
    }
}
