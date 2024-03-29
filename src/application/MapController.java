package application;

 

import java.util.ArrayList;
import java.util.List;
import application.Model.Roboter;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import javafx.scene.control.Label;

 


/**
 * A JavaFX controller for the map.
 *  
 *
 */
public class MapController  {

    @FXML
    private GridPane squares;

    
    private Label label;
    
    private Label label1;
    
    private Label label2;
    
    private List<ImageView> initialEntities;

    private Roboter roboter;

    private MapOfRobot mapOfRobot;             
    
    private MenuApplication menuScreen;
    
    private FindPlayer findplayer;    
    
    public MapController(MapOfRobot mapOfRobot, List<ImageView> initialEntities) {
        this.mapOfRobot = mapOfRobot;
        this.roboter = mapOfRobot.getRoboter();
        this.initialEntities = new ArrayList<>(initialEntities);    
        this.findplayer = new FindPlayer(this.mapOfRobot);
        this.label = new Label();
        this.label1 = new Label();
        this.label2 = new Label();     
    }    
	 
	@FXML
    public void initialize() {
        Image ground = new Image("/grass.png");
	 
        // Add the ground first so it is below all other entities
        for (int x = 0; x < mapOfRobot.getWidth(); x++) {
            for (int y = 0; y < mapOfRobot.getHeight(); y++) {
                squares.add(new ImageView(ground), x, y);               
            }
        }

        for (ImageView entity : initialEntities) {
            squares.getChildren().add(entity);   
        }  
        
        this.label1.setText("MOVE\nREPORT"); 
        squares.add(label1,15,0);        
        
        this.label.setText("Output: 0,0,WEST"); 
        label.setPrefWidth(150);   
        squares.add(label,15,1);  
        
        //for user select robot by key 
        // key == 1 means the robot is activated    
        Roboter roboter = mapOfRobot.getRobotsByKey();       
        mapOfRobot.setPlayer(roboter);        
        this.roboter = roboter;        
        
        //show activate robot on the label 
        this.label2.setText("I'm "+ roboter.getName());
        squares.add(label2,15,3);        
    }

    @FXML
    public void handleKeyPress(KeyEvent event) {
    	String report = "";
        switch (event.getCode()) {
        case UP:
        	roboter.moveUp();  
            report = "Output: " + roboter.getX() + "," + roboter.getY()
            + ",NORTH";
        	this.label.setText(report);            
             
            break;
        case DOWN:
        	roboter.moveDown();
        	report = "Output: " + roboter.getX() + "," + roboter.getY()
             + ",SOUTH";
         	this.label.setText(report);
            
            break;
        case LEFT:
        	roboter.moveLeft();
        	report = "Output: " + roboter.getX() + "," + roboter.getY()
            + ",WEST";
        	this.label.setText(report);
            
            break;
        case RIGHT:
        	roboter.moveRight();  
        	report = "Output: " + roboter.getX() + "," + roboter.getY()
            + ",EAST";
        	this.label.setText(report);             
            break;            
        case F:   
        	break;   
        default:
            break;
        }
    }

	public MapOfRobot getMap() {
		return mapOfRobot;
	}	
	
	public void movePlayer(int x,int y) {
			int targetX = mapOfRobot.getHeight() > x? x: mapOfRobot.getHeight();
			int targetY =  mapOfRobot.getWidth() > y? y: mapOfRobot.getWidth();			
			
	        findplayer.setDelay(Duration.seconds(0));
	        findplayer.setPeriod(Duration.seconds(1));
	        
	        findplayer.valueProperty().addListener(new ChangeListener<ArrayList<Integer>>(){
	
				@Override
				public void changed(ObservableValue<? extends ArrayList<Integer>> arg0, ArrayList<Integer> oldint,
						ArrayList<Integer> newint) {					 
					 if(newint != null) {
						 int y = newint.get(0);
						 int x = newint.get(1);	
						 if(y < targetX) {
							 roboter.moveRight(); 
						 }						
						 if(y == targetX) {
							 if(x > targetY) {								
								 roboter.moveUp();
							 }							 
						 }						
						 String report = "Output: " + roboter.getX() + "," + roboter.getY()
				          + ",EAST";
						 label.setText(report); 						  
							 
					 }	 	
				}
	        }); 
	}
	
	public FindPlayer getFindplayer() {
		return findplayer;
	}
	
	public void addEntityView(ImageView view,int x, int y) {
		if(mapOfRobot.getEntity(x, y) != null) {					
			GridPane.setColumnIndex(view, x);
			GridPane.setRowIndex(view, y);
			squares.getChildren().add(view);		
		} else {
			GridPane.setColumnIndex(view, x);
			GridPane.setRowIndex(view, y);
			squares.getChildren().add(view);			
		}
	}
	
	public MapOfRobot getMapOfRobot() {
		return mapOfRobot;
	}
	
	public void setMenuScreen(MenuApplication menuScreen) {
		this.menuScreen = menuScreen;
	}	

}