package javafx_practice;

//Switching scenes
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SwitchScene extends Application {

	Stage window;
	Scene scene1, scene2;
	
	public static void main (String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		
		//Layout 1 components
		Label label1 = new Label("Welcome to the first scene!");
		Button button1 = new Button("Go to scene two");
		button1.setOnAction(e -> window.setScene(scene2)); //change to scene2
		
		//Layout 1 - vertical column
		VBox layout1 = new VBox(20);
		layout1.getChildren().addAll(label1, button1);
		scene1 = new Scene(layout1, 200, 200);
		
		//Layout 2 components
		Button button2 = new Button("Go to scene one");
		button2.setOnAction(e -> window.setScene(scene1)); //change to scene2
		
		//Layout 2
		StackPane layout2 = new StackPane();
		layout2.getChildren().add(button2);
		scene2 = new Scene(layout2, 500, 500);
		
		window.setScene(scene1);
		window.setTitle("This is title");
		window.show();
	}

}
