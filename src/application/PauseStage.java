package application;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class PauseStage extends VBox{
	private Button resume;
	private Button backtoMain;
	private Button restart;
	private Button exit;
	
	public PauseStage() {
		super();
		resume = new Button("RESUME");
		backtoMain = new Button("BACK TO MAINMENU");
		restart = new Button("RESTART");
		exit = new Button("EXIT");
		this.getChildren().addAll(resume,backtoMain,restart,exit);
	}
}
