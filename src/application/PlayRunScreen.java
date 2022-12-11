package application;

 
import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PlayRunScreen  {
	private Stage stage;
	private String title;
	private MapController controller;
	private Scene scene;

	public PlayRunScreen(Stage stage) throws IOException {
	    this.stage = stage;
	    title = "Robot Run To Place";
	    
	    
	    MapControllerLoader maponLoader = new MapControllerLoader("map.json");      
	    
	    controller = maponLoader.loadController();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("MapView.fxml"));
	
	   
	    loader.setController(controller);	
	    
	    Parent root = loader.load();
	    scene = new Scene(root);
	    root.requestFocus();
	}

	public void start(int x, int y) {
		stage.setTitle(title);
		stage.setScene(scene);
		stage.show();
		controller.movePlayer(x,y);
		
	    FindPlayer findplayer = controller.getFindplayer();
	    
	    if(findplayer.isRunning() == true) {
        	findplayer.cancel();
        	//findplayer.reset();
        }
 
        findplayer.start();       
        
        
//        ExploreBomb exploreBomb = controller.getExploreBomb();             
//        exploreBomb.start();        
//        if(controller.getBombstate() == 1) {  
//        	exploreBomb.cancel();        	
//        }
//		
//        controller.runInvincibility();
		
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