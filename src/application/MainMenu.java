package application;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import util.reference;

public class MainMenu extends VBox{
	private Button start;
	private Button exit;
	private Button leaderBoard;
	private Circle sun;
	
	public MainMenu() {
		super(30);
		this.setAlignment(Pos.BOTTOM_LEFT);
		
		start = new Button("Play");
		leaderBoard = new Button("Leader Board");
		exit = new Button("Exit");
		Button non = new Button("");
		sun = new Circle();
		sun.setRadius(30);
		sun.setFill(Color.ORANGE);
		sun.setLayoutX(1000);
		sun.setLayoutY(50);
		
		start.setPrefWidth(600);
		start.setPrefHeight(util.reference.PREFHIGH);
		start.setOpacity(0);
		leaderBoard.setPrefWidth(600);
		leaderBoard.setPrefHeight(util.reference.PREFHIGH);
		leaderBoard.setOpacity(0);
		exit.setPrefWidth(600);
		exit.setPrefHeight(util.reference.PREFHIGH);
		exit.setOpacity(0);
		non.setPrefHeight(util.reference.PREFHIGH);
		non.setOpacity(0);
		this.getChildren().addAll(start,leaderBoard,exit,non);
	}

	public Button getStart() {
		return start;
	}

	public Button getExit() {
		return exit;
	}
	
}
