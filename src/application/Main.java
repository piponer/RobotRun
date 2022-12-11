package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.fxml.FXMLLoader;




public class Main extends Application {
	Button button;
	
	@Override
	public void start(Stage primaryStage) {
		try {
//			StackPane root = new StackPane();
//			Scene scene = new Scene(root,400,400);
//			
//			button = new Button("hello world");
//			root.getChildren().addAll(button);
//			
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//			primaryStage.setScene(scene);
//			primaryStage.show();
			
			MenuApplication menuScreen = new MenuApplication(primaryStage);
			PlayMapScreen mapScreen = new PlayMapScreen(primaryStage);
			menuScreen.getController().setMapScreen(mapScreen);
			PlayRunScreen runScreen = new PlayRunScreen(primaryStage);
			menuScreen.getController().setRunScreen(runScreen);
			PlayAdvScreen advScreen = new PlayAdvScreen(primaryStage);
			menuScreen.getController().setAdvScreen(advScreen);
			
			
			
			
			
			menuScreen.start();
			//mapScreen.start();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
