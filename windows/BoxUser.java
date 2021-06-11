package javafx_practice.windows;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class BoxUser extends Application{

	Stage window;
	Button button1;
	Button button2;
	
	public static void main (String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Lesson - Alert Box");
		
		button1 = new Button("Confirm Box");
		button1.setOnAction(e -> {
			boolean result = ConfirmBox.display("Title of Confirm Box", "Are you sure you want do it?");
			System.out.println(result);
		});
		
		button2 = new Button("Alert Box");
		button2.setOnAction(e -> {
			AlertBox.display("Title of Alert Box", "Want to close it?");
		});
		
		HBox layout = new HBox(10);
		layout.setAlignment(Pos.CENTER);
		layout.getChildren().addAll(button1, button2);
		Scene scene = new Scene(layout, 300, 300);
		window.setScene(scene);
		window.show();
	}

}
