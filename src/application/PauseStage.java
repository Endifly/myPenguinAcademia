package application;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class PauseStage extends VBox{
	private Button resume;
	private Button backtoMain;
	private Button restart;
	private Button exit;
	
	public PauseStage() {
		super(10);
		this.setAlignment(Pos.CENTER);
		resume = new Button("RESUME");
		backtoMain = new Button("BACK TO MAINMENU");
		restart = new Button("RESTART");
		exit = new Button("EXIT");
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
