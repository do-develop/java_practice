package javafx_practice;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ExtractValidateInput extends Application{

	Stage window;
	Scene scene;
	Button button;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Lesson - Extract and Validate Input");
		
		//Form
		TextField nameInput = new TextField();
		nameInput.setPromptText("Your age");
		button = new Button ("Click me");
		button.setOnAction(e -> isInt(nameInput, nameInput.getText()));
		
		//Layout
		VBox layout = new VBox(10);
		layout.setPadding(new Insets(20,20,20,20));
		layout.getChildren().addAll(nameInput, button);
		
		Scene scene = new Scene(layout, 250, 250);
		window.setScene(scene);
		window.show();
	}

	private boolean isInt(TextField input, String message) {
		try {
			int age = Integer.parseInt(message);
			System.out.println("User is: " + age);
			return true;
		}catch(NumberFormatException e) {
			System.out.println("Error: " + message + " is not a number");
			input.requestFocus();
			return false;
		}
	}
}
