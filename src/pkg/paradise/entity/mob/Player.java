package pkg.paradise.entity.mob;

import com.sun.glass.events.KeyEvent;
import pkg.paradise.graphics.Screen;
import pkg.paradise.graphics.Sprite;
import pkg.paradise.main.Game;

public class Player extends Mob {

    private double aTimer;
    private int currAnim = 0;
    private final double ANIM_TIMER = .0495;

    //Empty constructor
    public Player() {
        sprite = Sprite.PLAYER_DOWN;
    }

    //Constructor with x,y coords to spawn
    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        sprite = Sprite.PLAYER_DOWN;
    }

    /****************************************************
     * Name:        update
     * Description: Players update method, overridden from
     * Entity class. This method checks which key is 
     * pressed and either subtracts or adds to player 
     * position by 1 or - 1. If xa or ya is equal to 0
     * nothing is passed to the move method. 
     ****************************************************/
    @Override
    public void update(float delta) {
        //Checking direction
        int xa = 0, ya = 0;
        if (Game.keyboard.keyDown(KeyEvent.VK_W)) {
            ya--;
        }
        if (Game.keyboard.keyDown(KeyEvent.VK_S)) {
            ya++;
        }
        if (Game.keyboard.keyDown(KeyEvent.VK_A)) {
            xa--;
        }
        if (Game.keyboard.keyDown(KeyEvent.VK_D)) {
            xa++;
        }

        //Sending values to move
        if (xa != 0 || ya != 0) {
            move(xa, ya);
            moving = true;
        } else {
            moving = false;
        }

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

    /****************************************************
     * Name:        render
     * Description: Players render method which is overridden
     * from Entity class. This method is what essentially
     * draws the player given x,y coordinates from entity
     * and a given designated sprite object. Player animation 
     * is controlled in here as well. 
     ****************************************************/
    @Override
    public void render(Screen screen) {
        //Actually renders player with appropiate animation
        screen.renderPlayer(x - 16, y - 16, sprite);
    }

}
