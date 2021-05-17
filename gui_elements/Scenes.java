package gui_elements;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
//import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Scenes extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		
		//basic stage elements, a root node and a scene
		Group root = new Group();
		Scene scene = new Scene(root, Color.BLACK);
		
		//prepare icon image
		//Image icon = new Image("alien_icon.png");
		//primaryStage.getIcons().add(icon);
		
		primaryStage.setTitle("Stage Demo Program");
		primaryStage.setWidth(420);
		primaryStage.setHeight(420);
		primaryStage.setResizable(false);
		//primaryStage.setX(50);
		//primaryStage.setY(50);
		primaryStage.setFullScreen(true);
		primaryStage.setFullScreenExitHint("You can escape full screen by pressing q");
		primaryStage.setFullScreenExitKeyCombination(KeyCombination.valueOf("q"));
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
