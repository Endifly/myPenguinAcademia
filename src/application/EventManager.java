package application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import util.controlable;

public class EventManager {
	private static Stage PRIMARY;
	private static Scene BATTLESCENE;
	private static Scene MENUSCENE;
	private static Scene PAUSESCENE;
	
	//detect all used key true if it was pressed , false for not.
	public static boolean UP,DOWN,LEFT,RIGHT,ESCAPE,Z,X,C,V ;
	
	public EventManager(Scene menu , Scene battle , Scene pause , Stage primary) {
		// TODO Auto-generated constructor stub
		this.PRIMARY = primary;
		this.MENUSCENE = menu;
		this.BATTLESCENE = battle;
		this.PAUSESCENE = pause;
	}
	
	//mainStage setting
	public void setMainMenuStart(Button mainMenuStart) {
		mainMenuStart.setOnAction(e ->{
			PRIMARY.setScene(BATTLESCENE);
			PRIMARY.setTitle("Battle");
		});
	}
	public void setMainMenuExit(Button mainMenuExit) {
		mainMenuExit.setOnAction(e -> {
			Penguin.stop();
			BattleStage.stop();
			PRIMARY.close();
		});
	}
	
	//battleStage setting
	public void setBattleKeyPress(Scene battle) {
		battle.setOnKeyPressed((KeyEvent event) -> {
			String new_code = event.getCode().toString();
			//System.out.println(new_code);
			if (event.getCode() == KeyCode.UP) UP = true;
			if (event.getCode() == KeyCode.DOWN) DOWN = true;
			if (event.getCode() == KeyCode.RIGHT) RIGHT = true;
			if (event.getCode() == KeyCode.LEFT) LEFT = true;
			if (event.getCode() == KeyCode.Z) Z = true;
			if (event.getCode() == KeyCode.X) X = true;
			if (event.getCode() == KeyCode.C) C = true;
			if (event.getCode() == KeyCode.V) V = true;
			if (event.getCode() == KeyCode.ESCAPE) {
				PRIMARY.setScene(PAUSESCENE);
				PRIMARY.setTitle("pause");
			}
		});
		battle.setOnKeyReleased((KeyEvent event) -> {
			if (event.getCode() == KeyCode.UP) UP = false;
			if (event.getCode() == KeyCode.DOWN) DOWN = false;
			if (event.getCode() == KeyCode.RIGHT) RIGHT = false;
			if (event.getCode() == KeyCode.LEFT) LEFT = false;
			if (event.getCode() == KeyCode.Z) Z = false;
			if (event.getCode() == KeyCode.X) X = false;
			if (event.getCode() == KeyCode.C) C = false;
			if (event.getCode() == KeyCode.V) V = false;
		});
	}
	
	//pauseStage setting
	public void setPauseStageResume(Button pauseStageResume) {
		pauseStageResume.setOnAction(e -> {
			PRIMARY.setScene(BATTLESCENE);
			PRIMARY.setTitle("Battle");
		});
	}
	public void setPauseStageBacktoMenu(Button pauseStageBacktoMenu) {
		pauseStageBacktoMenu.setOnAction(e -> {
			PRIMARY.setScene(MENUSCENE);
			PRIMARY.setTitle("menu");
		});
	}
	public void setPauseStageExit(Button pauseStageExit) {
		pauseStageExit.setOnAction(e -> {
			Penguin.stop();
			PRIMARY.close();
		});
	}
	
	//getter
	public static Stage getPrimary() {
		return PRIMARY;
	}

	public static Scene getBattleScene() {
		return BATTLESCENE;
	}

	public static Scene getMenuScene() {
		return MENUSCENE;
	}

	public static Scene getPauseScene() {
		return PAUSESCENE;
	}
	
	
}
