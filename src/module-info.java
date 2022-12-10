module RobotTEST {
	
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	 
	requires org.json;
	opens application to javafx.graphics, javafx.fxml;
}
