package application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainMenu extends VBox{
	private Button start;
	private Button exit;
	
	public MainMenu(Stage k,StackPane i) {
		super();
		start = new Button("Play");
		exit = new Button("Exit");
		
		start.setOnAction(e -> {
			k.setScene(new Scene(i,600,600));
		});
		this.getChildren().addAll(start,exit);
	}
}
