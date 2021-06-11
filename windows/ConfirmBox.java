package javafx_practice.windows;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

//demonstrates how windows interact each other
public class ConfirmBox {

	//boolean variable
	static boolean answer;
	
	public static boolean display(String title, String message) {
		Stage window = new Stage();
		
		//blocks events from being delivered to any other application window
		window.initModality(Modality.APPLICATION_MODAL); 
		window.setTitle(title);
		window.setMinWidth(250);
		
		Label label = new Label();
		label.setText(message);
		
		Button yesButton = new Button("Yes");
		Button noButton = new Button("No");
		
		yesButton.setOnAction(e-> {
			answer = true;
			window.close();
		});
		
		noButton.setOnAction(e ->{
			answer = false;
			window.close();
		});
		
		//layout
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, yesButton, noButton);
		layout.setAlignment(Pos.CENTER);
		
		//scene
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait(); //display the window wait until close

		return answer;
	}

}