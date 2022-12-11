package application.Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;


public class Entity {

    
    private IntegerProperty x, y;
    
    private String name;  
    
    
    /**
     * Create an entity positioned in square (x,y)     * 
     */
    public Entity(int x, int y) {
        this.x = new SimpleIntegerProperty(x);
        this.y = new SimpleIntegerProperty(y);
    }

    public IntegerProperty x() {
        return x;
    }

    public IntegerProperty y() {
        return y;
    }

    public int getY() {
        return y().get();
    }

    public int getX() {
        return x().get();
    }
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void moveUp() {            
    }
	
	public void moveDown() {          
         
    }

    public void moveLeft() {       
           
    }
    public void moveRight() {        
           
    }
    
    public void moveTo(int x, int y) {
    	x().set(x);
    	y().set(y);
    	
    }
	
	
}
