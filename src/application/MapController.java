package application;

 

import java.util.ArrayList;
import java.util.List;

//import javax.swing.text.html.parser.Entity;

import javafx.animation.AnimationTimer;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.Button;
 


/**
 * A JavaFX controller for the map.
 *  
 *
 */
public class MapController  {

    @FXML
    private GridPane squares;

    private List<ImageView> initialEntities;

    private Roboter roboter;

    private MapOfRobot mapOfRobot;     
        
    
    private MenuApplication menuScreen;
   
    
    private AnimationTimer timer;
    private Integer i=0;
    
    public MapController(MapOfRobot mapOfRobot, List<ImageView> initialEntities) {
        this.mapOfRobot = mapOfRobot;
        this.roboter = mapOfRobot.getRoboter();
        this.initialEntities = new ArrayList<>(initialEntities);
    
     //   this.findplayer = new FindPlayer(this.mapOfRobot);
       
        
    }    
	 
	@FXML
    public void initialize() {
        Image ground = new Image("/dirt_0_new.png");
	 

        // Add the ground first so it is below all other entities
        for (int x = 0; x < mapOfRobot.getWidth(); x++) {
            for (int y = 0; y < mapOfRobot.getHeight(); y++) {
                squares.add(new ImageView(ground), x, y);
                 
                //System.out.println("init   x is " + x + "    y is " + y);
                
            }
        }

        for (ImageView entity : initialEntities) {
            squares.getChildren().add(entity);
        	System.out.println("entity is ");
        }
        
        
//        Button button = new Button("hello world");
//        squares.getChildren().add(button);
        
    }

    @FXML
    public void handleKeyPress(KeyEvent event) {
        switch (event.getCode()) {
        case UP:
        	roboter.moveUp();  
             
            
             
             
            break;
        case DOWN:
        	roboter.moveDown();
             
            
            break;
        case LEFT:
        	roboter.moveLeft();
            
            
            break;
        case RIGHT:
        	roboter.moveRight();  
             
            
            break;            
        case F:        	      	 
        	 
        	break;
        case B:
        	
        	 
        	
        	break;
        	
        default:
            break;
        }
    }

	public MapOfRobot getDungeon() {
		return mapOfRobot;
	}
	
	 
	
	 
	
//	public FindPlayer getFindplayer() {
//		return findplayer;
//	}




	
//	public void updateView() {
//		
//		Bomb litbomb = (Bomb) dungeon.getEntityByName("litbomb");
//		int bx = litbomb.getX();
//		int by = litbomb.getY();
//		LitBomb litbombing = new LitBomb(bx,by);
//		
//		
//		if(litbomb != null) {
//	 
//			exploreBomb.setDelay(Duration.seconds(0));
//			exploreBomb.setPeriod(Duration.seconds(1));
//			
//			
//			exploreBomb.valueProperty().addListener(new ChangeListener<ArrayList<Integer>>(){
//	
//				@Override
//				public void changed(ObservableValue<? extends ArrayList<Integer>> arg0, ArrayList<Integer> oldint,
//						ArrayList<Integer> newint) {
//					
//				 
//					
//					
//					if(newint != null) {
//						 int x = newint.get(0);	
//						 //System.out.println("sui ji chang sheng de x is ------>" + x);
//						 if(x == 1) {
//							
//							 
//							 
//							 addEntityView(litbombing.getView0(),bx,by);
//							  
//							// System.out.println("bug   0 !!!!" + x); 
//							 dungeon.addEntity(litbombing.getBomb1());
//							
//						 }
//						 if(x == 2) {
//						
//							// System.out.println("bug  1  !!!!" + x); 
//							 dungeon.addEntity(litbombing.getBomb2());
//							 dungeon.removeEntity(litbombing.getBomb1());
//							 
//							 addEntityView(litbombing.getView1(),bx,by);
//							 
//							 squares.getChildren().removeAll(litbombing.getView0());
//						 }
//						 if(x == 3) {
//							
//							// System.out.println("bug 2  !!!!" + x); 
//							 dungeon.addEntity(litbombing.getBomb3());
//							 dungeon.removeEntity(litbombing.getBomb2());
//							 addEntityView(litbombing.getView2(),bx,by);
//							 squares.getChildren().removeAll(litbombing.getView1());
//						 }
//						 
//						 if (x == 4) {
//							
//							 addEntityView(litbombing.getView3l(),bx - 1,by);
//							 addEntityView(litbombing.getView3r(),bx + 1,by);
//							 addEntityView(litbombing.getView3u(),bx,by -1);
//							 addEntityView(litbombing.getView3d(),bx,by + 1);
//							 
//							 
//							// System.out.println("bug 3 !!!!" + x); 
//							 dungeon.addEntity(litbombing.getBomb4());
//							 dungeon.removeEntity(litbombing.getBomb3());
//							 
//							 addEntityView(litbombing.getView3(),bx,by);
//							 squares.getChildren().removeAll(litbombing.getView2());
//							 
//							 player.killBomb(bx, by);
//							 player.killBomb(bx - 1, by);
//							 player.killBomb(bx + 1, by);
//							 player.killBomb(bx, by - 1);
//							 player.killBomb(bx, by + 1);
//						 }
//						 if (x == 5) {
//							
//							 //System.out.println("bug 4 !!!!" + x); 						
//							 
//							 squares.getChildren().removeAll(litbombing.getView3());	  
//
//							  squares.getChildren().removeAll(litbombing.getView3l()); 
//							  squares.getChildren().removeAll(litbombing.getView3r()); 
//							  squares.getChildren().removeAll(litbombing.getView3u());
//							  squares.getChildren().removeAll(litbombing.getView3d());
//							  
//							 dungeon.removeEntityPicture(dungeon.getEntityByName("litbomb")); 
//							 dungeon.addEntity(litbombing.getBomb5());
//							 dungeon.removeEntity(litbombing.getBomb4());
//							 
//							 
//							 bombstate = 1; 
//							 
//						 }
//						 
//					 }				
//				}
//	        });
//		
//		}
//   
//	}
//	
	 
 
	
	public void addEntityView(ImageView view,int x, int y) {
		if(mapOfRobot.getEntity(x, y) != null) {
			if(mapOfRobot.getEntity(x, y).getName().compareTo("wall") != 0) {			
				GridPane.setColumnIndex(view, x);
				GridPane.setRowIndex(view, y);
				squares.getChildren().add(view);
			}
		} else {
			GridPane.setColumnIndex(view, x);
			GridPane.setRowIndex(view, y);
			squares.getChildren().add(view);			
		}
	}
	
 
	
	public void setMenuScreen(MenuApplication menuScreen) {
		this.menuScreen = menuScreen;
	}
	
//	public void setPlayScreen(PlayAdvScreen playScreen) {
//		this.playScreen = playScreen;
//	}

	 
	 
	

}