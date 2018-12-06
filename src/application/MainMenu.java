package application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainMenu extends VBox{
	private Button start;
	private Button exit;
	
	public MainMenu() {
		super();
		start = new Button("Play");
		exit = new Button("Exit");
		
		this.getChildren().addAll(start,exit);
	}

	public Button getStart() {
		return start;
	}

	public Button getExit() {
		return exit;
	}
	
}
