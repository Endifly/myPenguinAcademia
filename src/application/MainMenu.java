package application;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import util.reference;

public class MainMenu extends VBox{
	private Button start;
	private Button exit;
	private Button leaderBoard;
	
	public MainMenu() {
		super(10);
		this.setAlignment(Pos.CENTER);
		start = new Button("Play");
		leaderBoard = new Button("Leader Board");
		exit = new Button("Exit");
		
		start.setPrefWidth(util.reference.PREFWIDTH);
		leaderBoard.setPrefWidth(util.reference.PREFWIDTH);
		exit.setPrefWidth(util.reference.PREFWIDTH);
		this.getChildren().addAll(start,leaderBoard,exit);
	}

	public Button getStart() {
		return start;
	}

	public Button getExit() {
		return exit;
	}
	
}
