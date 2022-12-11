package application.Model;

import java.util.ArrayList;
import java.util.List;

import application.MapOfRobot;
import application.MoveBehiver;
import application.MoveBehiverRoboter;
import application.NextSquar;
import javafx.util.Pair;
 

public class Roboter extends Entity  {	 

	private MapOfRobot mapOfRobot;
 
	private String name;    
   
    
    private NextSquar nextSquar = new NextSquar(0,0);
    
  
    private MoveBehiver movePlayer = new MoveBehiverRoboter();  
    
    

    
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
        	//PlayerPickup.pickup(this.mapOfRobot, this, getX(), getY()-1 );
        	
        	y().set(getY() - 1);
        	
        	
        	nextSquar.setY(getY() - 1);
        	nextSquar.setX(getX());
        	 
        	
        	//System.out.println("bomb is "+this.bomb + " trease is "+ this.treasure + " sword is " + this.sword); 
        	 
        } else {
        	//System.out.println("bomb is "+this.bomb + " trease is "+ this.treasure + " sword is " + this.sword); 
        	y().set(getY());        	
        }        
    }
    
    @Override
    public void moveDown() {
        if (getY() < mapOfRobot.getHeight() - 1 
        		&& movePlayer.canMoveTo(mapOfRobot, getX() ,(getY() + 1)) == true) {
        	
        	//PlayerPickup.pickup(this.mapOfRobot, this, getX(), getY() + 1);
        	y().set(getY() + 1);  
        	
        	nextSquar.setY(getY() + 1);
        	nextSquar.setX(getX());       	 
         
        	
        	//System.out.println("bomb is "+this.bomb + " trease is "+ this.treasure + " sword is " + this.sword);
        	
        	
        } else {
        	//System.out.println("bomb is "+this.bomb + " trease is "+ this.treasure + " sword is " + this.sword); 
        	 y().set(getY());        	
        }    
         
    }

    @Override
    public void moveLeft() {
        if (getX() > 0  && movePlayer.canMoveTo(mapOfRobot,(getX() - 1) ,getY()) == true) {
        	
         
        	 //PlayerPickup.pickup(this.mapOfRobot, this, (getX() - 1), getY());
        	 
        	 x().set(getX() - 1);
        	 
        	 nextSquar.setX(getX()-1);
        	 nextSquar.setY(getY());
        	 
        	
        	 
        	// System.out.println("bomb is "+this.bomb + " trease is "+ this.treasure + " sword is " + this.sword);
        } else {
        	//System.out.println("bomb is "+this.bomb + " trease is "+ this.treasure + " sword is " + this.sword); 
        	 x().set(getX());
        }
           
    }

    @Override
    public void moveRight() {
        if (getX() < mapOfRobot.getWidth() - 1 
        		&& movePlayer.canMoveTo(mapOfRobot, (getX() + 1) ,getY()) == true) {
        	
        	//PlayerPickup.pickup(this.mapOfRobot, this, (getX() + 1), getY());
        	//System.out.println("bomb is "+this.bomb + " trease is "+ this.treasure + " sword is " + this.sword);
        	
        	x().set(getX() + 1);
        	
        	
        	nextSquar.setX(getX()+1);
       	 	nextSquar.setY(getY());
        	
       	  
        	
        	
        	
        } else {
        	//System.out.println("bomb is "+this.bomb + " trease is "+ this.treasure + " sword is " + this.sword); 
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
 
 
	
    
}
