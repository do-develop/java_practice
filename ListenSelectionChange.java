package javafx_practice;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListenSelectionChange extends Application {

	Stage window;
	Scene scene;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Listen Selection Change Demo");
		
		//Drop down list
		ChoiceBox<String> choiceBox = new ChoiceBox<>();
		//getItems returns the ObservableList object which you can add items to
		choiceBox.getItems().addAll("Apple", "Watermelon", "Cherry", "Avocado");
		choiceBox.setValue("Apple");//set default value
		
		//Listen for selection changes
		choiceBox.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue) -> System.out.println(newValue) );
		
		//layout
		VBox layout = new VBox(10);
		layout.setPadding(new Insets(20,20,20,20));
		layout.getChildren().addAll(choiceBox);
		
		scene = new Scene(layout, 300, 250);
		window.setScene(scene);
		window.show();
		
	}
	
	
}
