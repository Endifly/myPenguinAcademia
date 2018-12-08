package application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class EventManager {
	private static Stage primary;
	private static Scene battleScene;
	private static Scene menuScene;
	private static Scene pauseScene;
	private static String battlePress;
	
	public EventManager(Scene menu , Scene battle , Scene pause , Stage primary) {
		// TODO Auto-generated constructor stub
		this.primary = primary;
		this.menuScene = menu;
		this.battleScene = battle;
		this.pauseScene = pause;
	}
	
	//mainStage setting
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
	
	//battleStage setting
	public void setBattleKeyPress(Scene battle) {
		battle.setOnKeyPressed((KeyEvent event) -> {
			String new_code = event.getCode().toString();
			battlePress = new_code;
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
			primary.setTitle("Battle");
		});
	}
	public void setPauseStageBacktoMenu(Button pauseStageBacktoMenu) {
		pauseStageBacktoMenu.setOnAction(e -> {
			primary.setScene(menuScene);
			primary.setTitle("menu");
		});
	}
	public void setPauseStageExit(Button pauseStageExit) {
		pauseStageExit.setOnAction(e -> {
			primary.close();
		});
	}
	
	//getter
	public static Stage getPrimary() {
		return primary;
	}

	public static Scene getBattleScene() {
		return battleScene;
	}

	public static Scene getMenuScene() {
		return menuScene;
	}

	public static Scene getPauseScene() {
		return pauseScene;
	}
	
	
}
