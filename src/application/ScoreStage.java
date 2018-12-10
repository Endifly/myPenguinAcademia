package application;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class ScoreStage extends Pane{
	private static Label score;
	private Button restart;
	private Button backToMenu;
	public ScoreStage() {
		super();
		score = new Label("score");
		score.setPrefWidth(util.reference.PREFWIDTH);
		score.setPrefHeight(util.reference.PREFHIGH);
		score.setLayoutX(540);
		score.setLayoutY(180);
		score.setFont(new Font("Arial Black",70));
		restart = new Button("restart");
		restart.setPrefWidth(util.reference.PREFWIDTH);
		restart.setPrefHeight(util.reference.PREFHIGH);
		restart.setLayoutX(200);
		restart.setTranslateY(500);
		restart.setOpacity(0);
		backToMenu = new Button("backToMenu");
		backToMenu.setPrefWidth(util.reference.PREFWIDTH);
		backToMenu.setPrefHeight(util.reference.PREFHIGH);
		backToMenu.setLayoutX(700);
		backToMenu.setLayoutY(480);
		backToMenu.setOpacity(0);
		
		this.getChildren().addAll(score,restart,backToMenu);
		
	}
	public Label getScore() {
		return score;
	}
	public Button getRestart() {
		return restart;
	}
	public void setRestart(Button restart) {
		this.restart = restart;
	}
	public Button getBackToMenu() {
		return backToMenu;
	}
	public void setBackToMenu(Button backToMenu) {
		this.backToMenu = backToMenu;
	}
	public static void setScore(String e) {
		score.setText(e);
	}
}
