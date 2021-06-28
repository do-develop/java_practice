package javafx_practice.property;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

	Stage window;
	Button button;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("JavaFX - Properties");
		
		Person juno = new Person();
		juno.firstNameProperty().addListener( (v, oldValue, newValue) -> {
			System.out.println("Name changed to " + newValue);
			System.out.println("firstNameProperty(): " + juno.firstNameProperty());
			System.out.println("getFirstName(): " + juno.getFirstName());
		} );
		
		button = new Button("Submit");
		button.setOnAction(e -> juno.setFirstName("Porky"));
		
		//bind properties!
		IntegerProperty x = new SimpleIntegerProperty(3);
		IntegerProperty y = new SimpleIntegerProperty();
		//!!bind
		y.bind(x.multiply(10));
		System.out.println("x: "+ x.getValue() + ", y: "+y.getValue());
				
		x.setValue(7);
		System.out.println("x: "+ x.getValue() + ", y: "+y.getValue());
		//end of bind properties
		
		StackPane layout = new StackPane();
		layout.getChildren().add(button);
		Scene scene = new Scene(layout, 300, 250);
		window.setScene(scene);
		window.show();
	}

}
