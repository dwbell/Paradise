package pkg.paradise.graphics;

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
