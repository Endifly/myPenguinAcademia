package application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class EventManager {
	private Stage primary;
	private Scene battleScene;
	private Scene menuScene;
	private Scene pauseScene;
	
	public EventManager(Scene menu , Scene battle , Scene pause , Stage primary) {
		// TODO Auto-generated constructor stub
		this.primary = primary;
		this.menuScene = menu;
		this.battleScene = battle;
		this.pauseScene = pause;
	}
	public void setMainMenuStart(Button mainMenuStart) {
		mainMenuStart.setOnAction(e ->{
			primary.setScene(battleScene);
			primary.setTitle("Battle");
		});
	}
	public void setMainMenuExit(Button mainMenuExit) {
		mainMenuExit.setOnAction(e -> {
			primary.close();
		});
	}
	public void setToPauseStage(Scene battle) {
		battle.setOnKeyPressed((KeyEvent event) -> {
			String new_code = event.getCode().toString();
			if (new_code.equals("ESCAPE")) {
				primary.setScene(pauseScene);
				primary.setTitle("pause");
			}
		});
	}
	
	//pauseStage setting
	public void setPauseStageResume(Button pauseStageResume) {
		pauseStageResume.setOnAction(e -> {
			primary.setScene(battleScene);
		});
	}
	public void setPauseStageBacktoMenu(Button pauseStageBacktoMenu) {
		pauseStageBacktoMenu.setOnAction(e -> {
			primary.setScene(menuScene);
		});
	}
}
