package javafx_practice;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MenuExample extends Application {

	Stage window;
	BorderPane layout;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Menu example");
		
		
		//File menu
		Menu fileMenu = new Menu("_File");
		//File menu items
		MenuItem newFile = new MenuItem("New...");
		newFile.setOnAction(e -> System.out.println("Create a new file"));
	
		fileMenu.getItems().add(newFile);
		fileMenu.getItems().add(new MenuItem("Open..."));
		fileMenu.getItems().add(new MenuItem("Save..."));
		fileMenu.getItems().add(new SeparatorMenuItem());
		fileMenu.getItems().add(new MenuItem("Settings..."));
		fileMenu.getItems().add(new SeparatorMenuItem());
		fileMenu.getItems().add(new MenuItem("Exit..."));
		
		//Edit Menu
		Menu editMenu = new Menu("_Edit");
		
		MenuItem paste = new MenuItem("Paste");
		paste.setOnAction(e -> System.out.println("Pasting clip board"));
		
		//Edit menu items
		editMenu.getItems().add(new MenuItem("Cut"));
		editMenu.getItems().add(new MenuItem("Copy"));
		editMenu.getItems().add(paste);
		//paste.setDisable(false);
		
		//Help Menu
		Menu helpMenu = new Menu("_Help");
		CheckMenuItem showLines = new CheckMenuItem("Show Line Numbers");
		showLines.setOnAction(e -> {
			if(showLines.isSelected()) {
				System.out.println("Program will now display line numbers");
			}else {
				System.out.println("Hiding line number");
			}
		});
		CheckMenuItem autoSave = new CheckMenuItem("Enable Autosave");
		autoSave.setSelected(true);
		helpMenu.getItems().addAll(showLines, autoSave);
		
		//Difficult Menu
		Menu difficultyMenu = new Menu("Difficulty");
		ToggleGroup difficultyToggle = new ToggleGroup();
		
		RadioMenuItem easy = new RadioMenuItem("Easy");
		easy.setToggleGroup(difficultyToggle);
		RadioMenuItem medium = new RadioMenuItem("Medium");
		medium.setToggleGroup(difficultyToggle);
		RadioMenuItem hard = new RadioMenuItem("Hard");
		hard.setToggleGroup(difficultyToggle);
		
		difficultyMenu.getItems().addAll(easy, medium, hard);
		
		//Main menu bar
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu, difficultyMenu);
		
		layout = new BorderPane();
		layout.setTop(menuBar);
		
		Scene scene = new Scene(layout, 400, 300);
		window.setScene(scene);
		window.show();
	}

}
