package labs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

public class SimpleFileEditor extends Application {
	
	Stage window;
	TextField filePath;
	TextArea fileContent;
	Button browseButton, openButton, saveButton, closeButton;
	FileChooser fchooser = new FileChooser();
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		filePath = new TextField();
		fileContent = new TextArea();
		browseButton = new Button("Browse");
		browseButton.setOnAction(e -> {
			browseFile();
		});
		openButton = new Button("Open");
		openButton.setOnAction(e -> {
			try {
				openFile();
			} catch (IOException ioe) {
				System.out.println("Error: Can't open the file");
				ioe.printStackTrace();
			}
		});
		saveButton = new Button("Save");
		saveButton.setOnAction(e -> {
			try {
				saveFile();
			} catch (IOException ioe) {
				System.out.println("Error: Can't save the file");
				ioe.printStackTrace();
			}
		});
		closeButton = new Button("Close");
		closeButton.setOnAction(e -> {
			closeFile();
		});
		
		FlowPane flow = new FlowPane();
		flow.setPadding(new Insets(15,12,15,12));
		flow.setVgap(10);
		flow.setHgap(10);
		flow.setAlignment(Pos.CENTER);
		flow.getChildren().addAll(filePath, browseButton, openButton, saveButton, closeButton, fileContent);
		
		window = primaryStage;
		Scene scene= new Scene(flow, 500, 300);
		window.setScene(scene);
		window.setTitle("Simple File Editor");
		window.show();
	}
	
	private void browseFile() {
		fchooser = new FileChooser();
		fchooser.setInitialDirectory(new File(System.getProperty("user.dir")));
		ExtensionFilter filter = new ExtensionFilter("text files", "*.txt");
		fchooser.getExtensionFilters().add(filter);
		File file = fchooser.showOpenDialog(window);
		filePath.setText(file.getAbsolutePath());
	}
	
	private void openFile() throws IOException {
		String fileName = filePath.getText();
		String line = "", content = "";
		
		BufferedReader reader = getBufferedReader(fileName);
		while ( (line = reader.readLine()) != null ) {
			content += (line + "\n");
		}
		fileContent.setText(content);
	}
	
	private void saveFile() throws IOException {
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Text Files", "*.txt");
		fchooser.getExtensionFilters().add(extFilter);
		File file = fchooser.showSaveDialog(window);
		String filename = file.getAbsolutePath();
		
		if(file != null) {
			FileWriter fWriter = new FileWriter(new File(filename));
			fWriter.write(fileContent.getText());
			fWriter.close();
		}
	}
	
	private void closeFile() {
		fileContent.clear();
	}
	
	private BufferedReader getBufferedReader(String fileName) throws FileNotFoundException {
		BufferedReader buff = new BufferedReader(
								new InputStreamReader(
									new FileInputStream(
											new File(fileName))));
	
		return buff;
	}
}
