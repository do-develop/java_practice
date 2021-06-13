package javafx_practice;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TreeViewExample extends Application {

	Stage window;
	Scene scene;

	TreeView<String> tree;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("JavaFX - Tree view example");
		
		TreeItem<String> root, branch1, branch2;
		
		//root is just a container
		root = new TreeItem<>();
		root.setExpanded(true);
		
		//branch1
		branch1 = makeBranch("Your Favourite", root);
		makeBranch("Bacon", branch1);
		makeBranch("YouTube", branch1);
		makeBranch("Chickens", branch1);

		//branch2
		branch2 = makeBranch("My Favourite", root);
		makeBranch("Makeup", branch2);
		makeBranch("Glitter", branch2);

		tree = new TreeView<>(root);
		tree.setShowRoot(false);
		tree.getSelectionModel().selectedItemProperty()
			.addListener( (v, oldValue, newValue) -> {
				if(newValue != null)
					System.out.println(newValue.getValue());
			});
		
		//layout
		StackPane layout = new StackPane();
		layout.getChildren().add(tree);
		scene = new Scene(layout, 300, 250);
		window.setScene(scene);
		window.show();
	}

	//create branches
	private TreeItem<String> makeBranch(String title, TreeItem<String> parent){
		TreeItem<String> item = new TreeItem<>(title);
		item.setExpanded(true);
		parent.getChildren().add(item);
		
		return item;
	}

}
