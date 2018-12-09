package application;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class PauseStage extends Pane{
	private Button resume;
	private Button backtoMain;
	private Button restart;
	private Button exit;
	
	public PauseStage() {
		super();
		//this.setAlignment(Pos.BASELINE_RIGHT);
		
		resume = new Button("RESUME");
		resume.setPrefWidth(util.reference.PREFWIDTH);
		resume.setPrefHeight(util.reference.PREFHIGH);
		resume.setLayoutX(320);
		resume.setLayoutY(200);
		resume.setOpacity(0);
		backtoMain = new Button("BACK TO MAINMENU");
		backtoMain.setPrefWidth(util.reference.PREFWIDTH);
		backtoMain.setPrefHeight(util.reference.PREFHIGH);
		backtoMain.setLayoutX(740);
		backtoMain.setLayoutY(200);
		backtoMain.setOpacity(0);
		restart = new Button("RESTART");
		restart.setPrefWidth(util.reference.PREFWIDTH);
		restart.setPrefHeight(util.reference.PREFHIGH);
		restart.setLayoutX(320);
		restart.setLayoutY(400);
		restart.setOpacity(0);
		exit = new Button("EXIT");
		exit.setPrefWidth(util.reference.PREFWIDTH);
		exit.setPrefHeight(util.reference.PREFHIGH);
		exit.setLayoutX(740);
		exit.setLayoutY(400);
		exit.setOpacity(0);
		
		this.getChildren().addAll(resume,backtoMain,restart,exit);
	}

	public Button getResume() {
		return resume;
	}

	public Button getBacktoMain() {
		return backtoMain;
	}

	public Button getRestart() {
		return restart;
	}

	public Button getExit() {
		return exit;
	}
	
}
