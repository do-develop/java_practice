package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EventFilterExample extends Application {

	Rectangle rectangle;
	@Override
	public void start(Stage stage) throws Exception {
		
		rectangle = new Rectangle();
		rectangle.setX(220.0f);
		rectangle.setY(100.0f);
		rectangle.setHeight(150.0f);
		rectangle.setWidth(150.0f);
		rectangle.setFill(Color.ALICEBLUE);
		rectangle.setStrokeWidth(20);
		
		Text text = new Text("Click on the rectangle to change its color");
		text.setFont(Font.font(null, FontWeight.BOLD, 15));
		text.setX(150);
		text.setY(50);
		
		//create a mouse event handler before registering an event filter
		EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				if(rectangle.getFill().equals(Color.ALICEBLUE)) {
					rectangle.setFill(Color.DEEPSKYBLUE);
				}else {
					rectangle.setFill(Color.ALICEBLUE);
				}
			}
		};
		
		//register the event filter
		rectangle.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
		
		//create group object
		Group root = new Group(rectangle, text);
		Scene scene = new Scene(root, 580, 300);
		stage.setTitle("Event Filters Example");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
