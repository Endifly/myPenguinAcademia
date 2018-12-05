package application;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class MainMenu extends VBox{
	private Button start;
	private Button exit;
	
	public MainMenu() {
		super();
		start = new Button("Play");
		exit = new Button("Exit");
		this.getChildren().addAll(start,exit);
	}
}
