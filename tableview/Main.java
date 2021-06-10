package javafx_practice.tableview;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

	Stage window;
	TableView<Product> table;
	TextField nameInput, priceInput, quantityInput;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("JavaFX");
		
		//SET UP COLUMNS
		//Name Column
		TableColumn<Product, String> nameColumn = new TableColumn<>("Name");
		nameColumn.setMinWidth(300);
		nameColumn.setCellValueFactory(new PropertyValueFactory("name"));
		
		//Price Column
		TableColumn<Product, Double> priceColumn = new TableColumn<>("Price");
		priceColumn.setMinWidth(150);
		priceColumn.setCellValueFactory(new PropertyValueFactory("price"));
				
		//Quantity Column
		TableColumn<Product, Integer> quantityColumn = new TableColumn<>("Quantity");
		quantityColumn.setMinWidth(150);
		quantityColumn.setCellValueFactory(new PropertyValueFactory("quantity"));
		
		//Name input
		nameInput = new TextField();
		nameInput.setPromptText("Name");
		nameInput.setMinWidth(100);
		
		//Price input
		priceInput = new TextField();
		priceInput.setPromptText("Price");
				
		//Quantity input
		quantityInput = new TextField();
		quantityInput.setPromptText("Quanitity");
		
		//Button
		Button addButton = new Button("Add");
		addButton.setOnAction(e -> addButtonClicked());
		Button deleteButton = new Button("Delete");
		deleteButton.setOnAction(e -> deleteButtonClicked());
		//Hbox layout
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(10,10,10,10));
		hbox.setSpacing(10);
		hbox.getChildren().addAll(nameInput, priceInput, quantityInput, addButton, deleteButton);
		
		table = new TableView<>();
		table.setItems(getProduct());
		table.getColumns().addAll(nameColumn, priceColumn, quantityColumn);
		
		VBox vbox = new VBox();
		vbox.getChildren().addAll(table, hbox);
		
		Scene scene = new Scene(vbox);
		window.setScene(scene);
		window.show();
	}
	
	public ObservableList<Product> getProduct(){
		ObservableList<Product> products = FXCollections.observableArrayList();
		products.add(new Product("Laptop", 859.00, 20));
		products.add(new Product("Toilet", 259.00, 20));
		products.add(new Product("Bouncy Ball", 2.99, 100));
		products.add(new Product("Corn", 1.50, 30));
		products.add(new Product("Table", 1059.00, 10));
		
		return products;
	}
	
	public void addButtonClicked() {
		Product product = new Product();
		product.setName(nameInput.getText());
		product.setPrice(Double.parseDouble(priceInput.getText()));
		product.setQuantity(Integer.parseInt(quantityInput.getText()));
		//add to the table~!
		table.getItems().add(product);
		nameInput.clear();
		priceInput.clear();
		quantityInput.clear();
	}
	
	public void deleteButtonClicked() {
		ObservableList<Product> productSelected, allProducts;
		allProducts = table.getItems();
		productSelected = table.getSelectionModel().getSelectedItems();
		
		productSelected.forEach(allProducts::remove);
	}
	
	
}
