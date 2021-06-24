package javafx_practice;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GridPaneLesson extends Application{

	Stage window;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Lesson - GridPane");
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8); //spacing between cells
		grid.setHgap(10);
		
		//Name label
		Label nameLabel = new Label("Username: ");
		GridPane.setConstraints(nameLabel, 0, 0); //first column, first row
		
		//Name input
		TextField nameInput = new TextField("Default Text");
		GridPane.setConstraints(nameInput, 1, 0);
		
		//Password label
		Label passLabel = new Label("Password: ");
		GridPane.setConstraints(passLabel, 0, 1); //first column, second row
		
		//Password input
		TextField passInput = new TextField();
		passInput.setPromptText("Prompt Text"); //placeholder
		GridPane.setConstraints(passInput, 1, 1);
		
		Button loginButton = new Button("Log In");
		GridPane.setConstraints(loginButton, 1, 2);
		
		grid.getChildren().addAll(nameLabel, nameInput, passLabel, passInput, loginButton);
		
		Scene scene = new Scene(grid, 250, 200);
		window.setScene(scene);
		window.show();
	}

}
