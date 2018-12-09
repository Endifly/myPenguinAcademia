package application;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class PauseStage extends StackPane{
	private Button resume;
	private Button backtoMain;
	private Button restart;
	private Button exit;
	
	public PauseStage() {
		super();
		this.setAlignment(Pos.BASELINE_RIGHT);
		
		resume = new Button("RESUME");
		resume.setPrefWidth(util.reference.PREFWIDTH);
		resume.setLayoutX(30);
		resume.setLayoutY(30);
		backtoMain = new Button("BACK TO MAINMENU");
		backtoMain.setPrefWidth(util.reference.PREFWIDTH);
		restart = new Button("RESTART");
		restart.setPrefWidth(util.reference.PREFWIDTH);
		exit = new Button("EXIT");
		exit.setPrefWidth(util.reference.PREFWIDTH);
		
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
