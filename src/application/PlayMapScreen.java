package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PlayMapScreen {
	private Stage stage;
	private String title;
	private MapController controller;
	private Scene scene;

	public PlayMapScreen(Stage stage) throws IOException {
	    this.stage = stage;
	    title = "Robot Map";	    
	    
	    MapControllerLoader mapOnLoader = new MapControllerLoader("map.json");      
	    
	    controller = mapOnLoader.loadController();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("MapView.fxml"));	
	   
	    loader.setController(controller);	
	    Parent root = loader.load();
	    scene = new Scene(root);
	    root.requestFocus();   
	}

	public void start() {
		stage.setTitle(title);
		stage.setScene(scene);
		stage.show();
	}

	public MapController getController() {
		return controller;
	}
}