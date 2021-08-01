package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EventHandlerExample extends Application {

	Rectangle rectangle;
	@Override
	public void start(Stage stage) throws Exception {

		Text text = new Text("Type something to change the color of the rectangle");
		text.setLayoutY(50);
		
		rectangle = new Rectangle();
		rectangle.setX(220.0f);
		rectangle.setY(180.0f);
		rectangle.setHeight(150.0f);
		rectangle.setWidth(150.0f);
		rectangle.setFill(Color.ALICEBLUE);
		rectangle.setStrokeWidth(20);
		
		TextField textField = new TextField();
		textField.setLayoutY(70);
		//handle key typed event
		EventHandler<KeyEvent> eventHandlerTextField = new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				changeColor();				
			}
		};
		
		//add the event handler to the text field
		textField.addEventHandler(KeyEvent.KEY_TYPED, eventHandlerTextField);
		
		Group root = new Group(text, textField, rectangle);
		Scene scene = new Scene(root, 580, 400);
		stage.setTitle("Event Handler Example");
		stage.setScene(scene);
		stage.show();
		
	}
	
	public void changeColor() {
		if(rectangle.getFill().equals(Color.ALICEBLUE)) {
			rectangle.setFill(Color.DEEPSKYBLUE);
		}else {
			rectangle.setFill(Color.ALICEBLUE);
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	

}
