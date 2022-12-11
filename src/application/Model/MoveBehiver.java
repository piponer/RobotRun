package application.Model;

import application.MapOfRobot;

public interface MoveBehiver {	
	public boolean canMoveTo(MapOfRobot mapOfRobot, int x, int y);
	public void pickup(MapOfRobot mapOfRobot,Roboter roboter,int x,int y); 
 
}