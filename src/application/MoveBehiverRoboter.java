package application;

import application.Model.Entity;
import application.Model.Roboter;

public class MoveBehiverRoboter implements MoveBehiver {    
	
	@Override
	public boolean canMoveTo(MapOfRobot mapOfRobot,int x, int y) {
		
		if(mapOfRobot.getEntity(x, y) == null) {			
    		return true;
    	} else {
    		Entity entity = mapOfRobot.getEntity(x, y);    		
    		if(entity.getName().compareTo("wall") == 0) {
        		return false;
        	}
    	}     	
    	return true;
	}

	@Override
	public void pickup(MapOfRobot mapOfRobot, Roboter roboter,int x,int y) {
		// TODO Auto-generated method stub		
	}

 
	

}