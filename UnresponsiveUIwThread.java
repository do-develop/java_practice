package lab6.practice;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class UnresponsiveUIwThread extends Application{

	private boolean stopFlag = false;
	private TextField tfCount;
	private int count =1;
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Counter");
		tfCount = new TextField(count + "");
		tfCount.setEditable(false);
		
		Button btnStart = new Button("Start Counting");
		Button btnStop = new Button("Stop Counting");
		GridPane grid = new GridPane();
		
		btnStart.setOnAction(e -> {
			stopFlag = false;
			
			Thread t = new Thread() {
				@Override
				public void run() {
					for(int i=0; i<100_000; ++i) {
						if(stopFlag) break;
						Platform.runLater(()->{
						tfCount.setText(count + "");
						});
						++count;
					}
				}
			};
			t.start();
		});
		
		btnStop.setOnAction(e -> {
			stopFlag = true;
		});
		
		grid.add(tfCount, 0, 0);
		grid.add(btnStart, 1, 0);
		grid.add(btnStop, 2, 0);
		
		Scene scene = new Scene(grid, 300, 120);
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] argv) {
		launch(argv);
		
	}
}
