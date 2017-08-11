package pkg.paradise.graphics;

import java.util.ArrayList;

public class Sprite {

    protected final int SIZE;
    protected int x, y;
    public int[] pixels;
    protected SpriteSheet sheet;

    //Grass Sprite
    public static Sprite grass = new Sprite(16, 2, 4, SpriteSheet.terrain);

    //Water Sprite
    public static Sprite water = new Sprite(16, 0, 0, SpriteSheet.terrain);

    //Void Sprite
    public static Sprite voidSprite = new Sprite(16, 0x0026FF);

    //Player sprites for downward animation (South)
    private final static Sprite PLAYER_DOWN = new Sprite(16, 0, 0, SpriteSheet.mob);
    private final static Sprite PLAYER_DOWN_1 = new Sprite(16, 0, 1, SpriteSheet.mob);
    private final static Sprite PLAYER_DOWN_2 = new Sprite(16, 0, 2, SpriteSheet.mob);
    //Player sprites for right animation (East)
    private final static Sprite PLAYER_RIGHT = new Sprite(16, 1, 0, SpriteSheet.mob);
    private final static Sprite PLAYER_RIGHT_1 = new Sprite(16, 1, 1, SpriteSheet.mob);
    private final static Sprite PLAYER_RIGHT_2 = new Sprite(16, 1, 2, SpriteSheet.mob);
    //Player sprites for left animation (West)
    private final static Sprite PLAYER_LEFT = new Sprite(16, 2, 0, SpriteSheet.mob);
    private final static Sprite PLAYER_LEFT_1 = new Sprite(16, 2, 1, SpriteSheet.mob);
    private final static Sprite PLAYER_LEFT_2 = new Sprite(16, 2, 2, SpriteSheet.mob);
    //Player sprites for up animation (North)
    private final static Sprite PLAYER_UP = new Sprite(16, 3, 0, SpriteSheet.mob);
    private final static Sprite PLAYER_UP_1 = new Sprite(16, 3, 1, SpriteSheet.mob);
    private final static Sprite PLAYER_UP_2 = new Sprite(16, 3, 2, SpriteSheet.mob);
    public final static Sprite[][] PLAYER_SPRITES = {{PLAYER_DOWN, PLAYER_DOWN_1, PLAYER_DOWN_2}, {PLAYER_RIGHT, PLAYER_RIGHT_1, PLAYER_RIGHT_2},
    {PLAYER_LEFT, PLAYER_LEFT_1, PLAYER_LEFT_2}, {PLAYER_UP, PLAYER_UP_1, PLAYER_UP_2}};

    //1] White Male, Brown Hair, White Shirt, Blue Pants
    private final static Sprite CHAR01_DOWN = new Sprite(16, 0, 0, SpriteSheet.characters);
    private final static Sprite CHAR01_DOWN_1 = new Sprite(16, 1, 0, SpriteSheet.characters);
    private final static Sprite CHAR01_DOWN_2 = new Sprite(16, 2, 0, SpriteSheet.characters);
    private final static Sprite CHAR01_DOWN_3 = new Sprite(16, 3, 0, SpriteSheet.characters);
    private final static Sprite CHAR01_RIGHT = new Sprite(16, 4, 0, SpriteSheet.characters);
    private final static Sprite CHAR01_RIGHT_1 = new Sprite(16, 5, 0, SpriteSheet.characters);
    private final static Sprite CHAR01_RIGHT_2 = new Sprite(16, 6, 0, SpriteSheet.characters);
    private final static Sprite CHAR01_RIGHT_3 = new Sprite(16, 7, 0, SpriteSheet.characters);
    private final static Sprite CHAR01_UP = new Sprite(16, 8, 0, SpriteSheet.characters);
    private final static Sprite CHAR01_UP_1 = new Sprite(16, 9, 0, SpriteSheet.characters);
    private final static Sprite CHAR01_UP_2 = new Sprite(16, 10, 0, SpriteSheet.characters);
    private final static Sprite CHAR01_UP_3 = new Sprite(16, 11, 0, SpriteSheet.characters);
    private final static Sprite CHAR01_LEFT = new Sprite(16, 12, 0, SpriteSheet.characters);
    private final static Sprite CHAR01_LEFT_1 = new Sprite(16, 13, 0, SpriteSheet.characters);
    private final static Sprite CHAR01_LEFT_2 = new Sprite(16, 14, 0, SpriteSheet.characters);
    private final static Sprite CHAR01_LEFT_3 = new Sprite(16, 15, 0, SpriteSheet.characters);
    public final static Sprite[][] CHAR01 = {{CHAR01_DOWN, CHAR01_DOWN_1, CHAR01_DOWN_2, CHAR01_DOWN_3}, {CHAR01_RIGHT, CHAR01_RIGHT_1, CHAR01_RIGHT_2, CHAR01_RIGHT_3},
    {CHAR01_LEFT, CHAR01_LEFT_1, CHAR01_LEFT_2, CHAR01_LEFT_3}, {CHAR01_UP, CHAR01_UP_1, CHAR01_UP_2, CHAR01_UP_3}};

    //2] White Male, Red Hair, Blue Shirt, Blue Pants
    private final static Sprite CHAR02_DOWN = new Sprite(16, 0, 1, SpriteSheet.characters);
    private final static Sprite CHAR02_DOWN_1 = new Sprite(16, 1, 1, SpriteSheet.characters);
    private final static Sprite CHAR02_DOWN_2 = new Sprite(16, 2, 1, SpriteSheet.characters);
    private final static Sprite CHAR02_DOWN_3 = new Sprite(16, 3, 1, SpriteSheet.characters);
    private final static Sprite CHAR02_RIGHT = new Sprite(16, 4, 1, SpriteSheet.characters);
    private final static Sprite CHAR02_RIGHT_1 = new Sprite(16, 5, 1, SpriteSheet.characters);
    private final static Sprite CHAR02_RIGHT_2 = new Sprite(16, 6, 1, SpriteSheet.characters);
    private final static Sprite CHAR02_RIGHT_3 = new Sprite(16, 7, 1, SpriteSheet.characters);
    private final static Sprite CHAR02_UP = new Sprite(16, 8, 1, SpriteSheet.characters);
    private final static Sprite CHAR02_UP_1 = new Sprite(16, 9, 1, SpriteSheet.characters);
    private final static Sprite CHAR02_UP_2 = new Sprite(16, 10, 1, SpriteSheet.characters);
    private final static Sprite CHAR02_UP_3 = new Sprite(16, 11, 1, SpriteSheet.characters);
    private final static Sprite CHAR02_LEFT = new Sprite(16, 12, 1, SpriteSheet.characters);
    private final static Sprite CHAR02_LEFT_1 = new Sprite(16, 13, 1, SpriteSheet.characters);
    private final static Sprite CHAR02_LEFT_2 = new Sprite(16, 14, 1, SpriteSheet.characters);
    private final static Sprite CHAR02_LEFT_3 = new Sprite(16, 15, 1, SpriteSheet.characters);
    public final static Sprite[][] CHAR02 = {{CHAR02_DOWN, CHAR02_DOWN_1, CHAR02_DOWN_2, CHAR02_DOWN_3}, {CHAR02_RIGHT, CHAR02_RIGHT_1, CHAR02_RIGHT_2, CHAR02_RIGHT_3},
    {CHAR02_LEFT, CHAR02_LEFT_1, CHAR02_LEFT_2, CHAR02_LEFT_3}, {CHAR02_UP, CHAR02_UP_1, CHAR02_UP_2, CHAR02_UP_3}};

    //3] Hispanic Male, Brown Hair, Red Shirt, Blue Pants
    private final static Sprite CHAR03_DOWN = new Sprite(16, 0, 2, SpriteSheet.characters);
    private final static Sprite CHAR03_DOWN_1 = new Sprite(16, 1, 2, SpriteSheet.characters);
    private final static Sprite CHAR03_DOWN_2 = new Sprite(16, 2, 2, SpriteSheet.characters);
    private final static Sprite CHAR03_DOWN_3 = new Sprite(16, 3, 2, SpriteSheet.characters);
    private final static Sprite CHAR03_RIGHT = new Sprite(16, 4, 2, SpriteSheet.characters);
    private final static Sprite CHAR03_RIGHT_1 = new Sprite(16, 5, 2, SpriteSheet.characters);
    private final static Sprite CHAR03_RIGHT_2 = new Sprite(16, 6, 2, SpriteSheet.characters);
    private final static Sprite CHAR03_RIGHT_3 = new Sprite(16, 7, 2, SpriteSheet.characters);
    private final static Sprite CHAR03_UP = new Sprite(16, 8, 2, SpriteSheet.characters);
    private final static Sprite CHAR03_UP_1 = new Sprite(16, 9, 2, SpriteSheet.characters);
    private final static Sprite CHAR03_UP_2 = new Sprite(16, 10, 2, SpriteSheet.characters);
    private final static Sprite CHAR03_UP_3 = new Sprite(16, 11, 2, SpriteSheet.characters);
    private final static Sprite CHAR03_LEFT = new Sprite(16, 12, 2, SpriteSheet.characters);
    private final static Sprite CHAR03_LEFT_1 = new Sprite(16, 13, 2, SpriteSheet.characters);
    private final static Sprite CHAR03_LEFT_2 = new Sprite(16, 14, 2, SpriteSheet.characters);
    private final static Sprite CHAR03_LEFT_3 = new Sprite(16, 15, 2, SpriteSheet.characters);
    public final static Sprite[][] CHAR03 = {{CHAR03_DOWN, CHAR03_DOWN_1, CHAR03_DOWN_2, CHAR03_DOWN_3}, {CHAR03_RIGHT, CHAR03_RIGHT_1, CHAR03_RIGHT_2, CHAR03_RIGHT_3},
    {CHAR03_LEFT, CHAR03_LEFT_1, CHAR03_LEFT_2, CHAR03_LEFT_3}, {CHAR03_UP, CHAR03_UP_1, CHAR03_UP_2, CHAR03_UP_3}};

    //4] White Female, Red Hair, Blue Shirt, Blue Pants
    private final static Sprite CHAR04_DOWN = new Sprite(16, 0, 3, SpriteSheet.characters);
    private final static Sprite CHAR04_DOWN_1 = new Sprite(16, 1, 3, SpriteSheet.characters);
    private final static Sprite CHAR04_DOWN_2 = new Sprite(16, 2, 3, SpriteSheet.characters);
    private final static Sprite CHAR04_DOWN_3 = new Sprite(16, 3, 4, SpriteSheet.characters);
    private final static Sprite CHAR04_RIGHT = new Sprite(16, 4, 3, SpriteSheet.characters);
    private final static Sprite CHAR04_RIGHT_1 = new Sprite(16, 5, 3, SpriteSheet.characters);
    private final static Sprite CHAR04_RIGHT_2 = new Sprite(16, 6, 3, SpriteSheet.characters);
    private final static Sprite CHAR04_RIGHT_3 = new Sprite(16, 7, 3, SpriteSheet.characters);
    private final static Sprite CHAR04_UP = new Sprite(16, 8, 3, SpriteSheet.characters);
    private final static Sprite CHAR04_UP_1 = new Sprite(16, 9, 3, SpriteSheet.characters);
    private final static Sprite CHAR04_UP_2 = new Sprite(16, 10, 3, SpriteSheet.characters);
    private final static Sprite CHAR04_UP_3 = new Sprite(16, 11, 3, SpriteSheet.characters);
    private final static Sprite CHAR04_LEFT = new Sprite(16, 12, 3, SpriteSheet.characters);
    private final static Sprite CHAR04_LEFT_1 = new Sprite(16, 13, 3, SpriteSheet.characters);
    private final static Sprite CHAR04_LEFT_2 = new Sprite(16, 14, 3, SpriteSheet.characters);
    private final static Sprite CHAR04_LEFT_3 = new Sprite(16, 15, 3, SpriteSheet.characters);
    public final static Sprite[][] CHAR04 = {{CHAR04_DOWN, CHAR04_DOWN_1, CHAR04_DOWN_2, CHAR04_DOWN_3}, {CHAR04_RIGHT, CHAR04_RIGHT_1, CHAR04_RIGHT_2, CHAR04_RIGHT_3},
    {CHAR04_LEFT, CHAR04_LEFT_1, CHAR04_LEFT_2, CHAR04_LEFT_3}, {CHAR04_UP, CHAR04_UP_1, CHAR04_UP_2, CHAR04_UP_3}};

    //5] White Female, Brown Hair, Line Shirt, Skirt
    private final static Sprite CHAR05_DOWN = new Sprite(16, 0, 4, SpriteSheet.characters);
    private final static Sprite CHAR05_DOWN_1 = new Sprite(16, 1, 4, SpriteSheet.characters);
    private final static Sprite CHAR05_DOWN_2 = new Sprite(16, 2, 4, SpriteSheet.characters);
    private final static Sprite CHAR05_DOWN_3 = new Sprite(16, 3, 4, SpriteSheet.characters);
    private final static Sprite CHAR05_RIGHT = new Sprite(16, 4, 4, SpriteSheet.characters);
    private final static Sprite CHAR05_RIGHT_1 = new Sprite(16, 5, 4, SpriteSheet.characters);
    private final static Sprite CHAR05_RIGHT_2 = new Sprite(16, 6, 4, SpriteSheet.characters);
    private final static Sprite CHAR05_RIGHT_3 = new Sprite(16, 7, 4, SpriteSheet.characters);
    private final static Sprite CHAR05_UP = new Sprite(16, 8, 4, SpriteSheet.characters);
    private final static Sprite CHAR05_UP_1 = new Sprite(16, 9, 4, SpriteSheet.characters);
    private final static Sprite CHAR05_UP_2 = new Sprite(16, 10, 4, SpriteSheet.characters);
    private final static Sprite CHAR05_UP_3 = new Sprite(16, 11, 4, SpriteSheet.characters);
    private final static Sprite CHAR05_LEFT = new Sprite(16, 12, 4, SpriteSheet.characters);
    private final static Sprite CHAR05_LEFT_1 = new Sprite(16, 13, 4, SpriteSheet.characters);
    private final static Sprite CHAR05_LEFT_2 = new Sprite(16, 14, 4, SpriteSheet.characters);
    private final static Sprite CHAR05_LEFT_3 = new Sprite(16, 15, 4, SpriteSheet.characters);
    public final static Sprite[][] CHAR05 = {{CHAR05_DOWN, CHAR05_DOWN_1, CHAR05_DOWN_2, CHAR05_DOWN_3}, {CHAR05_RIGHT, CHAR05_RIGHT_1, CHAR05_RIGHT_2, CHAR05_RIGHT_3},
    {CHAR05_LEFT, CHAR05_LEFT_1, CHAR05_LEFT_2, CHAR05_LEFT_3}, {CHAR05_UP, CHAR05_UP_1, CHAR05_UP_2, CHAR05_UP_3}};

    //6] White Male, Blonde Hair, Purple Shirt, Blue Pants
    private final static Sprite CHAR06_DOWN = new Sprite(16, 0, 5, SpriteSheet.characters);
    private final static Sprite CHAR06_DOWN_1 = new Sprite(16, 1, 5, SpriteSheet.characters);
    private final static Sprite CHAR06_DOWN_2 = new Sprite(16, 2, 5, SpriteSheet.characters);
    private final static Sprite CHAR06_DOWN_3 = new Sprite(16, 3, 5, SpriteSheet.characters);
    private final static Sprite CHAR06_RIGHT = new Sprite(16, 4, 5, SpriteSheet.characters);
    private final static Sprite CHAR06_RIGHT_1 = new Sprite(16, 5, 5, SpriteSheet.characters);
    private final static Sprite CHAR06_RIGHT_2 = new Sprite(16, 6, 5, SpriteSheet.characters);
    private final static Sprite CHAR06_RIGHT_3 = new Sprite(16, 7, 5, SpriteSheet.characters);
    private final static Sprite CHAR06_UP = new Sprite(16, 8, 4, SpriteSheet.characters);
    private final static Sprite CHAR06_UP_1 = new Sprite(16, 9, 5, SpriteSheet.characters);
    private final static Sprite CHAR06_UP_2 = new Sprite(16, 10, 5, SpriteSheet.characters);
    private final static Sprite CHAR06_UP_3 = new Sprite(16, 11, 5, SpriteSheet.characters);
    private final static Sprite CHAR06_LEFT = new Sprite(16, 12, 5, SpriteSheet.characters);
    private final static Sprite CHAR06_LEFT_1 = new Sprite(16, 13, 5, SpriteSheet.characters);
    private final static Sprite CHAR06_LEFT_2 = new Sprite(16, 14, 5, SpriteSheet.characters);
    private final static Sprite CHAR06_LEFT_3 = new Sprite(16, 15, 5, SpriteSheet.characters);
    public final static Sprite[][] CHAR06 = {{CHAR06_DOWN, CHAR06_DOWN_1, CHAR06_DOWN_2, CHAR06_DOWN_3}, {CHAR06_RIGHT, CHAR06_RIGHT_1, CHAR06_RIGHT_2, CHAR06_RIGHT_3},
    {CHAR06_LEFT, CHAR06_LEFT_1, CHAR06_LEFT_2, CHAR06_LEFT_3}, {CHAR06_UP, CHAR06_UP_1, CHAR06_UP_2, CHAR06_UP_3}};

    //7] Black Female, Brown Hair, White Dress
    private final static Sprite CHAR07_DOWN = new Sprite(16, 0, 6, SpriteSheet.characters);
    private final static Sprite CHAR07_DOWN_1 = new Sprite(16, 1, 6, SpriteSheet.characters);
    private final static Sprite CHAR07_DOWN_2 = new Sprite(16, 2, 6, SpriteSheet.characters);
    private final static Sprite CHAR07_DOWN_3 = new Sprite(16, 3, 6, SpriteSheet.characters);
    private final static Sprite CHAR07_RIGHT = new Sprite(16, 4, 6, SpriteSheet.characters);
    private final static Sprite CHAR07_RIGHT_1 = new Sprite(16, 5, 6, SpriteSheet.characters);
    private final static Sprite CHAR07_RIGHT_2 = new Sprite(16, 6, 6, SpriteSheet.characters);
    private final static Sprite CHAR07_RIGHT_3 = new Sprite(16, 7, 6, SpriteSheet.characters);
    private final static Sprite CHAR07_UP = new Sprite(16, 8, 6, SpriteSheet.characters);
    private final static Sprite CHAR07_UP_1 = new Sprite(16, 9, 6, SpriteSheet.characters);
    private final static Sprite CHAR07_UP_2 = new Sprite(16, 10, 6, SpriteSheet.characters);
    private final static Sprite CHAR07_UP_3 = new Sprite(16, 11, 6, SpriteSheet.characters);
    private final static Sprite CHAR07_LEFT = new Sprite(16, 12, 6, SpriteSheet.characters);
    private final static Sprite CHAR07_LEFT_1 = new Sprite(16, 13, 6, SpriteSheet.characters);
    private final static Sprite CHAR07_LEFT_2 = new Sprite(16, 14, 6, SpriteSheet.characters);
    private final static Sprite CHAR07_LEFT_3 = new Sprite(16, 15, 6, SpriteSheet.characters);
    public final static Sprite[][] CHAR07 = {{CHAR07_DOWN, CHAR07_DOWN_1, CHAR07_DOWN_2, CHAR07_DOWN_3}, {CHAR07_RIGHT, CHAR07_RIGHT_1, CHAR07_RIGHT_2, CHAR07_RIGHT_3},
    {CHAR07_LEFT, CHAR07_LEFT_1, CHAR07_LEFT_2, CHAR07_LEFT_3}, {CHAR07_UP, CHAR07_UP_1, CHAR07_UP_2, CHAR07_UP_3}};

    //8] White Male, Brown Hair, Green Shirt, Gray Pants
    private final static Sprite CHAR08_DOWN = new Sprite(16, 0, 7, SpriteSheet.characters);
    private final static Sprite CHAR08_DOWN_1 = new Sprite(16, 1, 7, SpriteSheet.characters);
    private final static Sprite CHAR08_DOWN_2 = new Sprite(16, 2, 7, SpriteSheet.characters);
    private final static Sprite CHAR08_DOWN_3 = new Sprite(16, 3, 7, SpriteSheet.characters);
    private final static Sprite CHAR08_RIGHT = new Sprite(16, 4, 7, SpriteSheet.characters);
    private final static Sprite CHAR08_RIGHT_1 = new Sprite(16, 5, 7, SpriteSheet.characters);
    private final static Sprite CHAR08_RIGHT_2 = new Sprite(16, 6, 7, SpriteSheet.characters);
    private final static Sprite CHAR08_RIGHT_3 = new Sprite(16, 7, 7, SpriteSheet.characters);
    private final static Sprite CHAR08_UP = new Sprite(16, 8, 7, SpriteSheet.characters);
    private final static Sprite CHAR08_UP_1 = new Sprite(16, 9, 7, SpriteSheet.characters);
    private final static Sprite CHAR08_UP_2 = new Sprite(16, 10, 7, SpriteSheet.characters);
    private final static Sprite CHAR08_UP_3 = new Sprite(16, 11, 7, SpriteSheet.characters);
    private final static Sprite CHAR08_LEFT = new Sprite(16, 12, 7, SpriteSheet.characters);
    private final static Sprite CHAR08_LEFT_1 = new Sprite(16, 13, 7, SpriteSheet.characters);
    private final static Sprite CHAR08_LEFT_2 = new Sprite(16, 14, 7, SpriteSheet.characters);
    private final static Sprite CHAR08_LEFT_3 = new Sprite(16, 15, 7, SpriteSheet.characters);
    public final static Sprite[][] CHAR08 = {{CHAR08_DOWN, CHAR08_DOWN_1, CHAR08_DOWN_2, CHAR08_DOWN_3}, {CHAR08_RIGHT, CHAR08_RIGHT_1, CHAR08_RIGHT_2, CHAR08_RIGHT_3},
    {CHAR08_LEFT, CHAR08_LEFT_1, CHAR08_LEFT_2, CHAR08_LEFT_3}, {CHAR08_UP, CHAR08_UP_1, CHAR08_UP_2, CHAR08_UP_3}};

    //9] White Female, Brown Hair, Green Shirt, Gray Pants
    private final static Sprite CHAR09_DOWN = new Sprite(16, 0, 8, SpriteSheet.characters);
    private final static Sprite CHAR09_DOWN_1 = new Sprite(16, 1, 8, SpriteSheet.characters);
    private final static Sprite CHAR09_DOWN_2 = new Sprite(16, 2, 8, SpriteSheet.characters);
    private final static Sprite CHAR09_DOWN_3 = new Sprite(16, 3, 8, SpriteSheet.characters);
    private final static Sprite CHAR09_RIGHT = new Sprite(16, 4, 8, SpriteSheet.characters);
    private final static Sprite CHAR09_RIGHT_1 = new Sprite(16, 5, 8, SpriteSheet.characters);
    private final static Sprite CHAR09_RIGHT_2 = new Sprite(16, 6, 8, SpriteSheet.characters);
    private final static Sprite CHAR09_RIGHT_3 = new Sprite(16, 7, 8, SpriteSheet.characters);
    private final static Sprite CHAR09_UP = new Sprite(16, 8, 8, SpriteSheet.characters);
    private final static Sprite CHAR09_UP_1 = new Sprite(16, 9, 8, SpriteSheet.characters);
    private final static Sprite CHAR09_UP_2 = new Sprite(16, 10, 8, SpriteSheet.characters);
    private final static Sprite CHAR09_UP_3 = new Sprite(16, 11, 8, SpriteSheet.characters);
    private final static Sprite CHAR09_LEFT = new Sprite(16, 12, 8, SpriteSheet.characters);
    private final static Sprite CHAR09_LEFT_1 = new Sprite(16, 13, 8, SpriteSheet.characters);
    private final static Sprite CHAR09_LEFT_2 = new Sprite(16, 14, 8, SpriteSheet.characters);
    private final static Sprite CHAR09_LEFT_3 = new Sprite(16, 15, 8, SpriteSheet.characters);
    public final static Sprite[][] CHAR09 = {{CHAR09_DOWN, CHAR09_DOWN_1, CHAR09_DOWN_2, CHAR09_DOWN_3}, {CHAR09_RIGHT, CHAR09_RIGHT_1, CHAR09_RIGHT_2, CHAR09_RIGHT_3},
    {CHAR09_LEFT, CHAR09_LEFT_1, CHAR09_LEFT_2, CHAR09_LEFT_3}, {CHAR09_UP, CHAR09_UP_1, CHAR09_UP_2, CHAR09_UP_3}};

    //10] Asian Male, Black Hair, Black Shirt, Blue Pants
    private final static Sprite CHAR10_DOWN = new Sprite(16, 0, 9, SpriteSheet.characters);
    private final static Sprite CHAR10_DOWN_1 = new Sprite(16, 1, 9, SpriteSheet.characters);
    private final static Sprite CHAR10_DOWN_2 = new Sprite(16, 2, 9, SpriteSheet.characters);
    private final static Sprite CHAR10_DOWN_3 = new Sprite(16, 3, 9, SpriteSheet.characters);
    private final static Sprite CHAR10_RIGHT = new Sprite(16, 4, 9, SpriteSheet.characters);
    private final static Sprite CHAR10_RIGHT_1 = new Sprite(16, 5, 9, SpriteSheet.characters);
    private final static Sprite CHAR10_RIGHT_2 = new Sprite(16, 6, 9, SpriteSheet.characters);
    private final static Sprite CHAR10_RIGHT_3 = new Sprite(16, 7, 9, SpriteSheet.characters);
    private final static Sprite CHAR10_UP = new Sprite(16, 8, 9, SpriteSheet.characters);
    private final static Sprite CHAR10_UP_1 = new Sprite(16, 9, 9, SpriteSheet.characters);
    private final static Sprite CHAR10_UP_2 = new Sprite(16, 10, 9, SpriteSheet.characters);
    private final static Sprite CHAR10_UP_3 = new Sprite(16, 11, 9, SpriteSheet.characters);
    private final static Sprite CHAR10_LEFT = new Sprite(16, 12, 9, SpriteSheet.characters);
    private final static Sprite CHAR10_LEFT_1 = new Sprite(16, 13, 9, SpriteSheet.characters);
    private final static Sprite CHAR10_LEFT_2 = new Sprite(16, 14, 9, SpriteSheet.characters);
    private final static Sprite CHAR10_LEFT_3 = new Sprite(16, 15, 9, SpriteSheet.characters);
    public final static Sprite[][] CHAR10 = {{CHAR10_DOWN, CHAR10_DOWN_1, CHAR10_DOWN_2, CHAR10_DOWN_3}, {CHAR10_RIGHT, CHAR10_RIGHT_1, CHAR10_RIGHT_2, CHAR10_RIGHT_3},
    {CHAR10_LEFT, CHAR10_LEFT_1, CHAR10_LEFT_2, CHAR10_LEFT_3}, {CHAR10_UP, CHAR10_UP_1, CHAR10_UP_2, CHAR10_UP_3}};

    //11] Asian Female, Black Hair, Black Shirt, Blue Pants
    private final static Sprite CHAR11_DOWN = new Sprite(16, 0, 10, SpriteSheet.characters);
    private final static Sprite CHAR11_DOWN_1 = new Sprite(16, 1, 10, SpriteSheet.characters);
    private final static Sprite CHAR11_DOWN_2 = new Sprite(16, 2, 10, SpriteSheet.characters);
    private final static Sprite CHAR11_DOWN_3 = new Sprite(16, 3, 10, SpriteSheet.characters);
    private final static Sprite CHAR11_RIGHT = new Sprite(16, 4, 10, SpriteSheet.characters);
    private final static Sprite CHAR11_RIGHT_1 = new Sprite(16, 5, 10, SpriteSheet.characters);
    private final static Sprite CHAR11_RIGHT_2 = new Sprite(16, 6, 10, SpriteSheet.characters);
    private final static Sprite CHAR11_RIGHT_3 = new Sprite(16, 7, 10, SpriteSheet.characters);
    private final static Sprite CHAR11_UP = new Sprite(16, 8, 10, SpriteSheet.characters);
    private final static Sprite CHAR11_UP_1 = new Sprite(16, 9, 10, SpriteSheet.characters);
    private final static Sprite CHAR11_UP_2 = new Sprite(16, 10, 10, SpriteSheet.characters);
    private final static Sprite CHAR11_UP_3 = new Sprite(16, 11, 10, SpriteSheet.characters);
    private final static Sprite CHAR11_LEFT = new Sprite(16, 12, 10, SpriteSheet.characters);
    private final static Sprite CHAR11_LEFT_1 = new Sprite(16, 13, 10, SpriteSheet.characters);
    private final static Sprite CHAR11_LEFT_2 = new Sprite(16, 14, 10, SpriteSheet.characters);
    private final static Sprite CHAR11_LEFT_3 = new Sprite(16, 15, 10, SpriteSheet.characters);
    public final static Sprite[][] CHAR11 = {{CHAR11_DOWN, CHAR11_DOWN_1, CHAR11_DOWN_2, CHAR11_DOWN_3}, {CHAR11_RIGHT, CHAR11_RIGHT_1, CHAR11_RIGHT_2, CHAR11_RIGHT_3},
    {CHAR11_LEFT, CHAR11_LEFT_1, CHAR11_LEFT_2, CHAR11_LEFT_3}, {CHAR11_UP, CHAR11_UP_1, CHAR11_UP_2, CHAR11_UP_3}};

    //12] Indian Male, Black Hair, Blue Shirt, Brown Pants
    private final static Sprite CHAR12_DOWN = new Sprite(16, 0, 11, SpriteSheet.characters);
    private final static Sprite CHAR12_DOWN_1 = new Sprite(16, 1, 11, SpriteSheet.characters);
    private final static Sprite CHAR12_DOWN_2 = new Sprite(16, 2, 11, SpriteSheet.characters);
    private final static Sprite CHAR12_DOWN_3 = new Sprite(16, 3, 11, SpriteSheet.characters);
    private final static Sprite CHAR12_RIGHT = new Sprite(16, 4, 11, SpriteSheet.characters);
    private final static Sprite CHAR12_RIGHT_1 = new Sprite(16, 5, 11, SpriteSheet.characters);
    private final static Sprite CHAR12_RIGHT_2 = new Sprite(16, 7, 11, SpriteSheet.characters);
    private final static Sprite CHAR12_RIGHT_3 = new Sprite(16, 7, 11, SpriteSheet.characters);
    private final static Sprite CHAR12_UP = new Sprite(16, 8, 11, SpriteSheet.characters);
    private final static Sprite CHAR12_UP_1 = new Sprite(16, 9, 11, SpriteSheet.characters);
    private final static Sprite CHAR12_UP_2 = new Sprite(16, 10, 11, SpriteSheet.characters);
    private final static Sprite CHAR12_UP_3 = new Sprite(16, 11, 11, SpriteSheet.characters);
    private final static Sprite CHAR12_LEFT = new Sprite(16, 12, 11, SpriteSheet.characters);
    private final static Sprite CHAR12_LEFT_1 = new Sprite(16, 13, 11, SpriteSheet.characters);
    private final static Sprite CHAR12_LEFT_2 = new Sprite(16, 14, 11, SpriteSheet.characters);
    private final static Sprite CHAR12_LEFT_3 = new Sprite(16, 15, 11, SpriteSheet.characters);
    public final static Sprite[][] CHAR12 = {{CHAR12_DOWN, CHAR12_DOWN_1, CHAR12_DOWN_2, CHAR12_DOWN_3}, {CHAR12_RIGHT, CHAR12_RIGHT_1, CHAR12_RIGHT_2, CHAR12_RIGHT_3},
    {CHAR12_LEFT, CHAR12_LEFT_1, CHAR12_LEFT_2, CHAR12_LEFT_3}, {CHAR12_UP, CHAR12_UP_1, CHAR12_UP_2, CHAR12_UP_3}};

    //13] Indian Female, Black Hair, Blue Shirt, Brown Pants
    private final static Sprite CHAR13_DOWN = new Sprite(16, 0, 12, SpriteSheet.characters);
    private final static Sprite CHAR13_DOWN_1 = new Sprite(16, 1, 12, SpriteSheet.characters);
    private final static Sprite CHAR13_DOWN_2 = new Sprite(16, 2, 12, SpriteSheet.characters);
    private final static Sprite CHAR13_DOWN_3 = new Sprite(16, 3, 12, SpriteSheet.characters);
    private final static Sprite CHAR13_RIGHT = new Sprite(16, 4, 12, SpriteSheet.characters);
    private final static Sprite CHAR13_RIGHT_1 = new Sprite(16, 5, 12, SpriteSheet.characters);
    private final static Sprite CHAR13_RIGHT_2 = new Sprite(16, 6, 12, SpriteSheet.characters);
    private final static Sprite CHAR13_RIGHT_3 = new Sprite(16, 7, 12, SpriteSheet.characters);
    private final static Sprite CHAR13_UP = new Sprite(16, 8, 12, SpriteSheet.characters);
    private final static Sprite CHAR13_UP_1 = new Sprite(16, 9, 12, SpriteSheet.characters);
    private final static Sprite CHAR13_UP_2 = new Sprite(16, 10, 12, SpriteSheet.characters);
    private final static Sprite CHAR13_UP_3 = new Sprite(16, 11, 12, SpriteSheet.characters);
    private final static Sprite CHAR13_LEFT = new Sprite(16, 12, 12, SpriteSheet.characters);
    private final static Sprite CHAR13_LEFT_1 = new Sprite(16, 13, 12, SpriteSheet.characters);
    private final static Sprite CHAR13_LEFT_2 = new Sprite(16, 14, 12, SpriteSheet.characters);
    private final static Sprite CHAR13_LEFT_3 = new Sprite(16, 15, 12, SpriteSheet.characters);
    public final static Sprite[][] CHAR13 = {{CHAR13_DOWN, CHAR13_DOWN_1, CHAR13_DOWN_2, CHAR13_DOWN_3}, {CHAR13_RIGHT, CHAR13_RIGHT_1, CHAR13_RIGHT_2, CHAR13_RIGHT_3},
    {CHAR13_LEFT, CHAR13_LEFT_1, CHAR13_LEFT_2, CHAR13_LEFT_3}, {CHAR13_UP, CHAR13_UP_1, CHAR13_UP_2, CHAR13_UP_3}};

    //14] Black Male, Brown Mowhak, Brown Shirt, Green Pants
    private final static Sprite CHAR14_DOWN = new Sprite(16, 0, 13, SpriteSheet.characters);
    private final static Sprite CHAR14_DOWN_1 = new Sprite(16, 1, 13, SpriteSheet.characters);
    private final static Sprite CHAR14_DOWN_2 = new Sprite(16, 2, 13, SpriteSheet.characters);
    private final static Sprite CHAR14_DOWN_3 = new Sprite(16, 3, 13, SpriteSheet.characters);
    private final static Sprite CHAR14_RIGHT = new Sprite(16, 4, 13, SpriteSheet.characters);
    private final static Sprite CHAR14_RIGHT_1 = new Sprite(16, 5, 13, SpriteSheet.characters);
    private final static Sprite CHAR14_RIGHT_2 = new Sprite(16, 6, 13, SpriteSheet.characters);
    private final static Sprite CHAR14_RIGHT_3 = new Sprite(16, 7, 13, SpriteSheet.characters);
    private final static Sprite CHAR14_UP = new Sprite(16, 8, 13, SpriteSheet.characters);
    private final static Sprite CHAR14_UP_1 = new Sprite(16, 9, 13, SpriteSheet.characters);
    private final static Sprite CHAR14_UP_2 = new Sprite(16, 10, 13, SpriteSheet.characters);
    private final static Sprite CHAR14_UP_3 = new Sprite(16, 11, 13, SpriteSheet.characters);
    private final static Sprite CHAR14_LEFT = new Sprite(16, 12, 13, SpriteSheet.characters);
    private final static Sprite CHAR14_LEFT_1 = new Sprite(16, 13, 13, SpriteSheet.characters);
    private final static Sprite CHAR14_LEFT_2 = new Sprite(16, 14, 13, SpriteSheet.characters);
    private final static Sprite CHAR14_LEFT_3 = new Sprite(16, 15, 13, SpriteSheet.characters);
    public final static Sprite[][] CHAR14 = {{CHAR14_DOWN, CHAR14_DOWN_1, CHAR14_DOWN_2, CHAR14_DOWN_3}, {CHAR14_RIGHT, CHAR14_RIGHT_1, CHAR14_RIGHT_2, CHAR14_RIGHT_3},
    {CHAR14_LEFT, CHAR14_LEFT_1, CHAR14_LEFT_2, CHAR14_LEFT_3}, {CHAR14_UP, CHAR14_UP_1, CHAR14_UP_2, CHAR14_UP_3}};

    //15] White Female, Blonde Hair, Black Dress
    private final static Sprite CHAR15_DOWN = new Sprite(16, 0, 14, SpriteSheet.characters);
    private final static Sprite CHAR15_DOWN_1 = new Sprite(16, 1, 14, SpriteSheet.characters);
    private final static Sprite CHAR15_DOWN_2 = new Sprite(16, 2, 14, SpriteSheet.characters);
    private final static Sprite CHAR15_DOWN_3 = new Sprite(16, 3, 14, SpriteSheet.characters);
    private final static Sprite CHAR15_RIGHT = new Sprite(16, 4, 14, SpriteSheet.characters);
    private final static Sprite CHAR15_RIGHT_1 = new Sprite(16, 5, 14, SpriteSheet.characters);
    private final static Sprite CHAR15_RIGHT_2 = new Sprite(16, 6, 14, SpriteSheet.characters);
    private final static Sprite CHAR15_RIGHT_3 = new Sprite(16, 7, 14, SpriteSheet.characters);
    private final static Sprite CHAR15_UP = new Sprite(16, 8, 14, SpriteSheet.characters);
    private final static Sprite CHAR15_UP_1 = new Sprite(16, 9, 14, SpriteSheet.characters);
    private final static Sprite CHAR15_UP_2 = new Sprite(16, 10, 14, SpriteSheet.characters);
    private final static Sprite CHAR15_UP_3 = new Sprite(16, 11, 14, SpriteSheet.characters);
    private final static Sprite CHAR15_LEFT = new Sprite(16, 12, 14, SpriteSheet.characters);
    private final static Sprite CHAR15_LEFT_1 = new Sprite(16, 13, 14, SpriteSheet.characters);
    private final static Sprite CHAR15_LEFT_2 = new Sprite(16, 14, 14, SpriteSheet.characters);
    private final static Sprite CHAR15_LEFT_3 = new Sprite(16, 15, 14, SpriteSheet.characters);
    public final static Sprite[][] CHAR15 = {{CHAR15_DOWN, CHAR15_DOWN_1, CHAR15_DOWN_2, CHAR15_DOWN_3}, {CHAR15_RIGHT, CHAR15_RIGHT_1, CHAR15_RIGHT_2, CHAR15_RIGHT_3},
    {CHAR15_LEFT, CHAR15_LEFT_1, CHAR15_LEFT_2, CHAR15_LEFT_3}, {CHAR15_UP, CHAR15_UP_1, CHAR15_UP_2, CHAR15_UP_3}};

    //16] White Male, BLonde Hair, Brown Shirt, Gray Pants
    private final static Sprite CHAR16_DOWN = new Sprite(16, 0, 15, SpriteSheet.characters);
    private final static Sprite CHAR16_DOWN_1 = new Sprite(16, 1, 15, SpriteSheet.characters);
    private final static Sprite CHAR16_DOWN_2 = new Sprite(16, 2, 15, SpriteSheet.characters);
    private final static Sprite CHAR16_DOWN_3 = new Sprite(16, 3, 15, SpriteSheet.characters);
    private final static Sprite CHAR16_RIGHT = new Sprite(16, 4, 15, SpriteSheet.characters);
    private final static Sprite CHAR16_RIGHT_1 = new Sprite(16, 5, 15, SpriteSheet.characters);
    private final static Sprite CHAR16_RIGHT_2 = new Sprite(16, 6, 15, SpriteSheet.characters);
    private final static Sprite CHAR16_RIGHT_3 = new Sprite(16, 7, 15, SpriteSheet.characters);
    private final static Sprite CHAR16_UP = new Sprite(16, 8, 15, SpriteSheet.characters);
    private final static Sprite CHAR16_UP_1 = new Sprite(16, 9, 15, SpriteSheet.characters);
    private final static Sprite CHAR16_UP_2 = new Sprite(16, 10, 15, SpriteSheet.characters);
    private final static Sprite CHAR16_UP_3 = new Sprite(16, 11, 15, SpriteSheet.characters);
    private final static Sprite CHAR16_LEFT = new Sprite(16, 12, 15, SpriteSheet.characters);
    private final static Sprite CHAR16_LEFT_1 = new Sprite(16, 13, 15, SpriteSheet.characters);
    private final static Sprite CHAR16_LEFT_2 = new Sprite(16, 14, 15, SpriteSheet.characters);
    private final static Sprite CHAR16_LEFT_3 = new Sprite(16, 15, 15, SpriteSheet.characters);
    public final static Sprite[][] CHAR16 = {{CHAR16_DOWN, CHAR16_DOWN_1, CHAR16_DOWN_2, CHAR16_DOWN_3}, {CHAR16_RIGHT, CHAR16_RIGHT_1, CHAR16_RIGHT_2, CHAR16_RIGHT_3},
    {CHAR16_LEFT, CHAR16_LEFT_1, CHAR16_LEFT_2, CHAR16_LEFT_3}, {CHAR16_UP, CHAR16_UP_1, CHAR16_UP_2, CHAR16_UP_3}};

    public final static ArrayList<Sprite[][]> ALL_CHARACTERS = new ArrayList<>();

    static {
        ALL_CHARACTERS.add(CHAR01);
        ALL_CHARACTERS.add(CHAR02);
        ALL_CHARACTERS.add(CHAR03);
        ALL_CHARACTERS.add(CHAR04);
        ALL_CHARACTERS.add(CHAR05);
        ALL_CHARACTERS.add(CHAR06);
        ALL_CHARACTERS.add(CHAR07);
        ALL_CHARACTERS.add(CHAR08);
        ALL_CHARACTERS.add(CHAR09);
        ALL_CHARACTERS.add(CHAR10);
        ALL_CHARACTERS.add(CHAR11);
        ALL_CHARACTERS.add(CHAR12);
        ALL_CHARACTERS.add(CHAR13);
        ALL_CHARACTERS.add(CHAR14);
        ALL_CHARACTERS.add(CHAR15);
        ALL_CHARACTERS.add(CHAR16);
    }

    //Void tile constructor
    public Sprite(int sizeParam, int colorParam) {
        SIZE = sizeParam;
        pixels = new int[SIZE * SIZE];
        setColor(colorParam);
    }

    //Normal tile constructor
    public Sprite(int sizeParam, int xParam, int yParam, SpriteSheet sheetParam) {
        SIZE = sizeParam;
        pixels = new int[SIZE * SIZE];
        this.x = xParam * SIZE;
        this.y = yParam * SIZE;
        this.sheet = sheetParam;
        load();
    }

    /****************************************************
     * Name:        setColor
     * Description: Fills a sprite with a specified color
     ****************************************************/
    private void setColor(int color) {
        for (int i = 0; i < SIZE * SIZE; i++) {
            pixels[i] = color;
        }
    }

    /****************************************************
     * Name:        load
     * Description: Loads a SINGLE sprite given an x and
     * y coordinate. x and y are represented by the entire
     * sprite and are NOT individual pixel coordinates.
     ****************************************************/
    private void load() {
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.getSpriteSheetSize()];
            }
        }
    }

    /****************************************************
     * Name:        getIndividualSpriteSize
     * Description: Getter method for getting a single
     * sprite size
     ****************************************************/
    public int getSpriteSize() {
        return SIZE;
    }
}
