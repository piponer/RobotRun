package application;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuApplication  {
	
	 	private Stage stage;
	    private String title;
	    private MenuController controller;
	    private Scene scene;
	    private FXMLLoader loader;
	    
	    public MenuApplication(Stage stage) throws IOException {
	        this.stage = stage;
	        title = "Game Menu";

	        controller = new MenuController();
	        loader = new FXMLLoader(getClass().getResource("menu.fxml"));
	        loader.setController(controller);
	    
	        Parent root = loader.load();
	        scene = new Scene(root);
	        root.requestFocus();
	    }

	    public void start() {
	        if(stage.isShowing() == true) {	        	 
	        	stage.close();	        	
	        }
	    	
	    	stage.setTitle(title);
	        stage.setScene(scene);
	        stage.show();	        
	        
	    }   
	    public MenuController getController() {
	        return controller;
	    }
}
