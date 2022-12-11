package application;

import java.util.ArrayList;
import java.util.Random;

import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;

public class FindPlayer extends ScheduledService<ArrayList<Integer>> {
	 
	private MapOfRobot mapOfRobot;
	
	//private ArrayList<Integer> nextSquare; 
	
	private int nextSquare;
	
	
	
	public FindPlayer(MapOfRobot mapOfRobot) {
		super();
		this.mapOfRobot = mapOfRobot;
		nextSquare = 0;
		//nextSquare = new ArrayList<Integer>(); 
	}
 
	 
	
	
	@Override
	protected Task<ArrayList<Integer>> createTask() {
		
		Task<ArrayList<Integer>> task = new Task<ArrayList<Integer>>(){

			@Override
			protected ArrayList<Integer> call() throws Exception {
				int enemyX = 0;
				int enemyY = 0;
				int enemy1X = 0;
				int enemy1Y = 0;
				
//				for(Entity e : mapOfRobot.getEntities()) {
//					if(e.getName().compareTo("player") ==0) {
//					//System.out.println("enemy is " + e.getX() + " y " + e.getY()); 
//						enemyX = e.getX();
//						enemyY = e.getY();
//					}
//					if(e.getName().compareTo("enemy1") == 0) {
//						enemy1X = e.getX();
//						enemy1Y = e.getY();						
//					}
//				}
				
				int n = nextSquare(enemyX,enemyY);
				
				int n1 = nextSquare(enemy1X,enemy1Y);
				//System.out.println("next step direction is    "  + n);
				
//				Random ra = new Random();
//				
//				int x = ra.nextInt(8);
//				int y = ra.nextInt(8);
				
				int x = mapOfRobot.getRoboter().getX();
				int y = mapOfRobot.getRoboter().getY();
				
				//System.out.println("robot direction is    "  + x);
				
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(x);
				list.add(y);
				
//				list.add(n);
//				list.add(n1);
				
				
				
				//System.out.println("li mian player de wei shi zhi " + dungeon.getPlayer().getX() + " and y " + dungeon.getPlayer().getY());
				
				return list;
			}
			
			
		};
		 
		return task;
	}
	
	public int nextSquare(int enemyX,int enemyY){		
		
		int playX = mapOfRobot.getRoboter().getX();
		int playY =  mapOfRobot.getRoboter().getY();	
		
		//System.out.println("enmey bug!!!!!!!!!!!!! x  " + enemyX + " Y " + enemyY );
		//System.out.println("play bug!!!!!!!!!!!!! x  " + playX + " Y " + playY );
//		if (mapOfRobot.getRoboter() < 1) {
//			if(playX < enemyX ) {
//				nextSquare = 3;						
//			}
//			
//			if(playX > enemyX ) { 
//				nextSquare = 4;
//			}
//			
//			//x xiangdeng  y zhou shang shang xia yi dong
//			if(playX == enemyX) {
//				if(enemyY > playY) {
//					nextSquare = 1;
//				} 
//				if(enemyY < playY) {
//					nextSquare = 2;
//				}
//			}
//			
//			//y xiang deng
//			if(enemyY == playY) {
//				if(playX < enemyX) {
//					nextSquare = 3;
//				} 
//				if(playX > enemyX) {
//					nextSquare = 4;
//				}
//			}
//			
//		} else {
//			
//			if(playX < enemyX ) {
//				nextSquare = 4;						
//			}
//			
//			if(playX > enemyX ) { 
//				nextSquare = 3;
//			}
//			
//			//duo 
//			if(playX == enemyX) {
//				if(enemyY > playY) {
//					nextSquare = 2;
//				} 
//				if(enemyY < playY) {
//					nextSquare = 1;
//				}
//			}
//			
//			//duo 
//			if(enemyY == playY) {
//				if(playX < enemyX) {
//					nextSquare = 4;
//				} 
//				if(playX > enemyX) {
//					nextSquare = 3;
//				}
//			}
//			
//			
//		}
		//System.out.println("wai mian player de wei shi zhi " + dungeon.getPlayer().getX() + " and y " + dungeon.getPlayer().getY()); 
		
		
		return nextSquare;
	}
	
	 
}