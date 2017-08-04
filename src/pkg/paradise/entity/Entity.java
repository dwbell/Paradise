package pkg.paradise.entity;

import java.util.Random;
import pkg.paradise.graphics.Screen;
import pkg.paradise.level.Level;


public abstract class Entity {

    public int x,y;
    private boolean removed = false;
    protected Level level;
    protected final Random random = new Random();
    
    public void update(float delta){
        
    }
    
    public void render(Screen screen){
        
    }
    
    public void remove(){
        removed = true;
    }
    
    public boolean isRemoved(){
        return removed;
    }
    
    public void init(Level level){
        this.level = level;
    }
}