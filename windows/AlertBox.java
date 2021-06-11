package javafx_practice.windows;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {

	static Stage window;
	
	public static void display(String title, String message) {
		window = new Stage();
		
		//blocks events from being delivered to any other application window
		window.initModality(Modality.APPLICATION_MODAL); 
		window.setTitle(title);
		window.setMinWidth(250);
		window.setOnCloseRequest(e -> {
			e.consume(); //to prevent closing
			closeProgram();
		});
		
		Label label = new Label();
		label.setText(message);
		Button closeButton = new Button("Close the window");
		closeButton.setOnAction(e -> closeProgram());
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, closeButton);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait(); //display the window wait until close

	}
	
	private static void closeProgram() {
		Boolean answer = ConfirmBox.display("Title", "Sure you want to exit?");
		if(answer) {
			window.close();
		}
		
	}

}
