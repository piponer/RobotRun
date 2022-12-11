package application;

import java.util.ArrayList;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;

public class FindPlayer extends ScheduledService<ArrayList<Integer>> {
	 
	private MapOfRobot mapOfRobot;	
	
	public FindPlayer(MapOfRobot mapOfRobot) {
		super();
		this.mapOfRobot = mapOfRobot;	
	}	 
	
	
	@Override
	protected Task<ArrayList<Integer>> createTask() {
		
		Task<ArrayList<Integer>> task = new Task<ArrayList<Integer>>(){

			@Override
			protected ArrayList<Integer> call() throws Exception {			
				
				int x = mapOfRobot.getRoboter().getX();
				int y = mapOfRobot.getRoboter().getY();					
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(x);
				list.add(y);					
				return list;
			}		
			
		};
		 
		return task;
	}
	 
}