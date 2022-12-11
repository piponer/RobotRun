package application;
 

import java.io.IOException;

import application.Model.Roboter;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class PlayAdvScreen {
	private Stage stage;
	private String title;
	private MapController controller;
	private Scene scene;
	private Roboter roboter;
	private MapControllerLoader mapOnLoader;

	public PlayAdvScreen(Stage stage) throws IOException {
	    this.stage = stage;
	    title = "Robot Map";
	    
	    
	    mapOnLoader = new MapControllerLoader("map.json");      
	    
	    controller = mapOnLoader.loadController();	    		

        FXMLLoader loader = new FXMLLoader(getClass().getResource("MapView.fxml"));
	
	   
	    loader.setController(controller);
	
	    // load into a Parent node called root
	    Parent root = loader.load();
	    scene = new Scene(root);
	    root.requestFocus();
	    
	    
	}

	public void start(int roboterNmber, int pointRobot){
		String name = "robot_";		
		
		
		
		//check the input numbers validate
		int roboterNmberMax = roboterNmber > 5 ? 5 : roboterNmber;
		
		int pointRobotMax = pointRobot > roboterNmber? 0:pointRobot;
		
		pointRobotMax = pointRobot < 0 ? 0:pointRobot;
		
		for(int i = 0; i < roboterNmberMax; i++) {
			roboter = new Roboter(controller.getMapOfRobot(),0,4);
			name = name + (i + 2);
			roboter.setName(name);
			
			ImageView robotView = getIamgeRobot();
	        
	        
			//controller.getMapOfRobot().addEntity(roboter);
			mapOnLoader.addEntity(roboter,robotView);
			//System.out.println("bug xunhuan !!!!!"  + name + "  " + roboter.getX() + " " + roboter.getY());
			name = "robot_";
			
		}
		
		stage.setTitle(title);
		stage.setScene(scene);
		stage.show();
		
		
		
		int x = controller.getMapOfRobot().getRoboter().getX();
		
		int y = controller.getMapOfRobot().getRoboter().getY();
		
		//System.out.println("bug 33333 !!!!!"  + x +  "==" + y);
		
	
		
	}
	
	private ImageView getIamgeRobot() {
		Image playerImage = new Image("/robotstand.png");
		ImageView view = new ImageView(playerImage);	        
        view.setId("player");
        return view;		
	}
	
	
	
	public void stop() {
		if(stage.isShowing() == true) {			 
			stage.close();		
		}
		
	}

	public MapController getController() {
		return controller;
	}
}