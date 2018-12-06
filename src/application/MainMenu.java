package application;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import util.reference;

public class MainMenu extends VBox{
	private Button start;
	private Button exit;
	
	public MainMenu() {
		super(10);
		this.setAlignment(Pos.CENTER);
		start = new Button("Play");
		exit = new Button("Exit");
		
		start.setAlignment(Pos.CENTER);
		start.setPrefWidth(util.reference.PREFWIDTH);
		exit.setPrefWidth(util.reference.PREFWIDTH);
		this.getChildren().addAll(start,exit);
	}

	public Button getStart() {
		return start;
	}

	public Button getExit() {
		return exit;
	}
	
}
