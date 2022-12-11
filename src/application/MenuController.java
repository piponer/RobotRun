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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;




public class MenuController {
	
	
	@FXML
	private Button demo; 
	
	@FXML
	private Button boulder;
	
	@FXML
	private Button adv;
	
	@FXML
	private Label label;
	
	@FXML
	private TextField textFieldx;
	
	@FXML
	private TextField textFieldy;	
	
	@FXML
	private Label label2;
	
	@FXML
	private TextField roboterNmber;
	
	@FXML
	private TextField pointRobot;
	
	
	@FXML
    private GridPane squares;
	
	private Stage stage;
	
	
	private PlayMapScreen mapScreen;
	
	private PlayRunScreen runScreen;
	
	private PlayAdvScreen advScreen;
	
	
	public MenuController() {
		super();
		this.demo = new Button("Play Robot");	
		this.boulder = new Button("Place Robot");
		this.adv  =  new Button("Add Robot");
		this.label = new Label();
		this.textFieldx = new TextField();
		this.textFieldy = new TextField();
		this.label2 = new Label();
		this.roboterNmber = new TextField();
		this.pointRobot = new TextField();
		
	}

	
	@FXML
    public void initialize() {
		//Image ground = new Image("file:/dirt_0_new.png");
		
        // Add the ground first so it is below all other entities
//        for (int x = 0; x < 7; x++) {
//            for (int y = 0; y < 6; y++) {
//            	ImageView im = new ImageView(ground);
//            	im.setFitHeight(40);
//            	im.setFitWidth(130);
//            	squares.add(im, x, y);                
//            }
//        }
        
      
        demo.setPrefSize(130, 40);
		GridPane.setColumnIndex(demo, 1);
		GridPane.setRowIndex(demo, 3);
		squares.getChildren().add(demo);
		
		
		boulder.setPrefSize(130, 40);
		GridPane.setColumnIndex(boulder, 3);
		GridPane.setRowIndex(boulder, 3);
		squares.getChildren().add(boulder);
		
		label.setText("Please input y, x");		 
		GridPane.setColumnIndex(label, 3);
		GridPane.setRowIndex(label, 0);
		squares.getChildren().add(label);
		
		textFieldx.setPrefWidth(30);
		GridPane.setColumnIndex(textFieldx, 3);
		GridPane.setRowIndex(textFieldx, 1);
		squares.getChildren().add(textFieldx);
		
		textFieldy.setPrefWidth(30);
		GridPane.setColumnIndex(textFieldy, 3);
		GridPane.setRowIndex(textFieldy, 2);
		squares.getChildren().add(textFieldy);
		
		
		label2.setText("number and point");		 
		GridPane.setColumnIndex(label2, 5);
		GridPane.setRowIndex(label2, 0);
		squares.getChildren().add(label2);
		
		roboterNmber.setPrefWidth(30);
		GridPane.setColumnIndex(roboterNmber, 5);
		GridPane.setRowIndex(roboterNmber, 1);
		squares.getChildren().add(roboterNmber);
		
		pointRobot.setPrefWidth(30);
		GridPane.setColumnIndex(pointRobot, 5);
		GridPane.setRowIndex(pointRobot, 2);
		squares.getChildren().add(pointRobot);
		
		
		adv = new Button("Play Advance"); 
		adv.setPrefSize(130, 40);
		GridPane.setColumnIndex(adv, 5);
		GridPane.setRowIndex(adv, 3);
		squares.getChildren().add(adv);
		
		
		
		changeButtonHandler();
	}
	
	
    public void changeButtonHandler() {
    	demo.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                handlePlay();
            }
        });
		
		boulder.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                handlePlayBoulder();  
            }
        });
		
		adv.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                handlePlayAdv();
            }
        });
		
	 
	}
	
	
    public void handlePlay() {		
    	mapScreen.start();		
		
	}
    
    public void handlePlayBoulder() {
		//System.out.println("bug 33333 !!!!!"  + textFieldx.getText() + textFieldy.getText());
		int x = Integer.parseInt(textFieldx.getText());
		int y = Integer.parseInt(textFieldy.getText());		
		runScreen.start(x,y);
		//runScreen.stop();
		
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
    
    public void handlePlayAdv() {  
    	
		int getroboterNmber = Integer.parseInt(roboterNmber.getText());
		int getpointRobot = Integer.parseInt(pointRobot.getText());		
		
		//System.out.println("bug 33333 !!!!!"  + getroboterNmber +  "==" + getpointRobot);
    	
    	advScreen.stop();
		advScreen.start(getroboterNmber,getpointRobot);
	}


	public PlayMapScreen getMapScreen() {
		return mapScreen;
	}


	public void setMapScreen(PlayMapScreen mapScreen) {
		this.mapScreen = mapScreen;
	}
	
	public PlayRunScreen getRunScreen() {
		return runScreen;
	}


	public void setRunScreen(PlayRunScreen runScreen) {
		this.runScreen = runScreen;
	}


	public PlayAdvScreen getAdvScreen() {
		return advScreen;
	}


	public void setAdvScreen(PlayAdvScreen advScreen) {
		this.advScreen = advScreen;
	}
	
	
	

}
