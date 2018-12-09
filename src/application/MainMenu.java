package application;

import javafx.animation.ScaleTransition;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Scale;
import javafx.util.Duration;
import util.reference;

public class MainMenu extends Pane{
	private Button start;
	private Button exit;
	private Button leaderBoard;
	private static ScaleTransition scale;
	private static Sun sun;
	
	public MainMenu() {
		super();
		//this.setAlignment(Pos.BOTTOM_LEFT);
		
		start = new Button("Play");
		leaderBoard = new Button("Leader Board");
		exit = new Button("Exit");
		
		start.setPrefWidth(util.reference.PREFWIDTH);
		start.setPrefHeight(util.reference.PREFHIGH);
		start.setLayoutX(250);
		start.setLayoutY(320);
		start.setOpacity(0);
		leaderBoard.setPrefWidth(util.reference.PREFWIDTH);
		leaderBoard.setPrefHeight(util.reference.PREFHIGH);
		leaderBoard.setLayoutX(250);
		leaderBoard.setLayoutY(440);
		leaderBoard.setOpacity(0);
		exit.setPrefWidth(util.reference.PREFWIDTH);
		exit.setPrefHeight(util.reference.PREFHIGH);
		exit.setLayoutX(250);
		exit.setLayoutY(550);
		exit.setOpacity(0);
		
		sun = new Sun();
		this.getChildren().addAll(start,leaderBoard,exit,sun.sun);
	}

	public Button getStart() {
		return start;
	}

	public Button getExit() {
		return exit;
	}
	public static void raiseTheSun() {
		sun.raiseTheSun();
	}
	

}
