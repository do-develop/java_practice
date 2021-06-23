package javafx_practice;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChoiceBoxExample extends Application {
	Stage window;
	Scene scene;
	Button button;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("ChoiceBox Demo");
		
		//button
		button  = new Button("Click me");
		
		//Drop down list
		ChoiceBox<String> choiceBox = new ChoiceBox<>();
		//getItems returns the ObservableList object which you can add items to
		choiceBox.getItems().addAll("Apple", "Banana", "Cherry", "Avocado");
		choiceBox.setValue("Apple");//set default value
		
		button.setOnAction(e-> getChoice(choiceBox));
		
		//layout
		VBox layout = new VBox(10);
		layout.setPadding(new Insets(20,20,20,20));
		layout.getChildren().addAll(choiceBox, button);
		
		scene = new Scene(layout, 300, 250);
		window.setScene(scene);
		window.show();
		
	}
	
	private void getChoice(ChoiceBox<String> choiceBox) {
		String fruit = choiceBox.getValue();
		System.out.println(fruit);
	}
	
	
}
