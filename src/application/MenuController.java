package application;



//import com.sun.glass.events.KeyEvent;
//import com.sun.glass.events.MouseEvent;

 


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;




public class MenuController {
	
	
	@FXML
	private Button maze; 
	
	@FXML
	private Button boulder;
	
	@FXML
	private Button adv;
	
	@FXML
    private GridPane squares;
	
	
	private PlayMapScreen mapScreen;
	
	//private PlayAdvScreen advScreen;
	
	
	public MenuController() {
		super();
		this.maze = new Button("Play Maze");	
		this.boulder = new Button("Play Boulder");
		this.adv  =  new Button("Play Advance");
	}

	
	@FXML
    public void initialize() {
		Image ground = new Image("file:/dirt_0_new.png");
		
        // Add the ground first so it is below all other entities
        for (int x = 0; x < 7; x++) {
            for (int y = 0; y < 6; y++) {
            	ImageView im = new ImageView(ground);
            	im.setFitHeight(40);
            	im.setFitWidth(130);
            	squares.add(im, x, y);                
            }
        }
        
		maze = new Button("Play Maze"); 
		maze.setPrefSize(130, 40);
		GridPane.setColumnIndex(maze, 1);
		GridPane.setRowIndex(maze, 3);
		squares.getChildren().add(maze);
		
		
		boulder = new Button("Play Boulder"); 
		boulder.setPrefSize(130, 40);
		GridPane.setColumnIndex(boulder, 3);
		GridPane.setRowIndex(boulder, 3);
		squares.getChildren().add(boulder);
		
		 
		
		
		changeButtonHandler();
	}
	
	
    public void changeButtonHandler() {
		maze.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                handlePlayMaze();
            }
        });
		
		boulder.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                handlePlayBoulder();
            }
        });
		
	 
	}
	
	
    public void handlePlayMaze() {		
    	mapScreen.start();		
		
	}
    
    public void handlePlayBoulder() {
		System.out.println("bug 33333 !!!!!");
		
		
		//playmaze.start(stage);
	}
    
//    public void handlePlayAdv() {  
//    	advScreen.stop();
//		advScreen.start();
//	}
    
	
//	@FXML
//    public void handleKeyPress(KeyEvent event) {
//		
//	}
//	
//	public void onMouseMove(MouseEvent event) {
//		
//	}


	public PlayMapScreen getMazeScreen() {
		return mapScreen;
	}


	public void setMazeScreen(PlayMapScreen mapScreen) {
		this.mapScreen = mapScreen;
	}


	//public PlayAdvScreen getAdvScreen() {
		//return advScreen;
	//}


	//public void setAdvScreen(PlayAdvScreen advScreen) {
		//this.advScreen = advScreen;
	//}
	
	
	

}
