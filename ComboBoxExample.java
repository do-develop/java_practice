package javafx_practice;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ComboBoxExample extends Application {

	Stage window;
	Scene scene;
	Button button;
	ComboBox<String> comboBox;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("ComboBox Demo");
		
		//button
		button  = new Button("Submit");
		
		//Drop down list
		comboBox = new ComboBox<>();
		comboBox.getItems().addAll(
				"Spongebob squarepants",
				"Starbutterfly vs evil force",
				"We Bare Bears"
		);
		
		comboBox.setPromptText("What is your favorite movie?");
		comboBox.setOnAction(e -> System.out.println("Your selection: "+ comboBox.getValue() ) );
		comboBox.setEditable(true);
		
		button.setOnAction(e -> printMovie());
		
		//layout
		VBox layout = new VBox(10);
		layout.setPadding(new Insets(20,20,20,20));
		layout.getChildren().addAll(comboBox, button);
		
		scene = new Scene(layout, 300, 250);
		window.setScene(scene);
		window.show();
		
	}
	
	//print out a movie
	private void printMovie() {
		if(comboBox.getValue().equals("Starbutterfly vs evil force")) {
			System.out.println("I am a magical princess");
		}
		if(comboBox.getValue().equals("We Bare Bears")) {
			System.out.println("Icebear like refrigerator");
		}
		if(comboBox.getValue().equals("Spongebob squarepants")) {
			System.out.println("hahahahahhaha I love Gary");
		}
		
	}
}
