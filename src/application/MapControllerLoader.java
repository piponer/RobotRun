package application;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import application.Model.Entity;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
 


public class MapControllerLoader extends MapLoader{

	  private List<ImageView> entities;

	    //Images
	    private Image playerImage;		 

		public MapControllerLoader(String filename)
	            throws FileNotFoundException {
	        super(filename);
	        entities = new ArrayList<>();
	        playerImage = new Image("/robotstand.png");	 
	    }

	    @Override
	    public void onLoad(Entity player) {
	        ImageView view = new ImageView(playerImage);	        
	        view.setId("player");
	        addEntity(player, view);
	    } 	    
	    
	    public void addEntity(Entity entity, ImageView view) {
	        trackPosition(entity, view);
	        entities.add(view);        
	    }
	    
	    

	    /**
	     * Set a node in a GridPane to have its position track the position of an
	     * entity in the map. with connecting the model with the view 
	     */
	    private void trackPosition(Entity entity, Node node) {
	        GridPane.setColumnIndex(node, entity.getX());
	        GridPane.setRowIndex(node, entity.getY());
	        entity.x().addListener(new ChangeListener<Number>() {
	            @Override
	            public void changed(ObservableValue<? extends Number> observable,
	                    Number oldValue, Number newValue) {
	                GridPane.setColumnIndex(node, newValue.intValue());	                
	            }
	        });
	        entity.y().addListener(new ChangeListener<Number>() {
	            @Override
	            public void changed(ObservableValue<? extends Number> observable,
	                    Number oldValue, Number newValue) {
	                GridPane.setRowIndex(node, newValue.intValue());	                
	            }
	        });
	    }                    

	    /**
	     * Create a controller that can be attached to the MapView with all the
	     * loaded entities.	     * 
	     * @throws FileNotFoundException
	     */
	    public MapController loadController() throws FileNotFoundException {
	        return new MapController(load(), entities);
	    }
	    
}
