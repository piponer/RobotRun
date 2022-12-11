package application.Model;

import java.util.ArrayList;
import java.util.List;

import application.MapOfRobot;
import javafx.util.Pair;
 

public class Roboter extends Entity  {	 

	private MapOfRobot mapOfRobot;
 
	private String name;    
   
    
    private NextSquare nextSquar = new NextSquare(0,0);
    
  
    private MoveBehiver movePlayer = new MoveBehiverRoboter();  
    
    private int key;
    
    

    
	/**
     * Create a player positioned in square (x,y)
     *
     */
    public Roboter(MapOfRobot mapOfRobot, int x, int y) {
        super(x, y);
        this.mapOfRobot = mapOfRobot;        
        
    } 

	
    @Override
	public void moveUp() {
        if (getY() > 0 && movePlayer.canMoveTo(mapOfRobot,getX() ,(getY() - 1)) == true) {    
        	y().set(getY() - 1);    
        	nextSquar.setY(getY() - 1);
        	nextSquar.setX(getX());              	 
        } else {        	
        	y().set(getY());        	
        }        
    }
    
    @Override
    public void moveDown() {
        if (getY() < mapOfRobot.getHeight() - 1 
        		&& movePlayer.canMoveTo(mapOfRobot, getX() ,(getY() + 1)) == true) {        	 
        	y().set(getY() + 1);         	
        	nextSquar.setY(getY() + 1);
        	nextSquar.setX(getX()); 
        } else {         
        	 y().set(getY());        	
        }   
         
    }

    @Override
    public void moveLeft() {
        if (getX() > 0  && movePlayer.canMoveTo(mapOfRobot,(getX() - 1) ,getY()) == true) {        	
        	 x().set(getX() - 1);        	 
        	 nextSquar.setX(getX()-1);
        	 nextSquar.setY(getY());        	 
        } else {         
        	 x().set(getX());
        }
           
    }

    @Override
    public void moveRight() {
        if (getX() < mapOfRobot.getWidth() - 1 
        		&& movePlayer.canMoveTo(mapOfRobot, (getX() + 1) ,getY()) == true) {        	 
        	x().set(getX() + 1);         	
        	nextSquar.setX(getX()+1);
       	 	nextSquar.setY(getY());        	
        } else {         
        	x().set(getX());
        }
           
    } 

    public MoveBehiver getMovePlayer() {
		return movePlayer;
	}

	public void setMovePlayer(MoveBehiver movePlayer) {
		this.movePlayer = movePlayer;
	}	
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;		
	}
 
	public void setKey(int key) {
		this.key = key;
	}
	
	public int getKey() {
		return this.key;		
	}	
    
}
