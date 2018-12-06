package application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class EventManager {
	private Pane menu;
	private Pane battle;
	private Pane pause;
	private Stage primary;
	
	public EventManager(Pane menu , Pane battle , Pane pause , Stage primary) {
		// TODO Auto-generated constructor stub
		this.menu = menu;
		this.battle = battle;
		this.pause = pause;
		this.primary = primary;
	}
	public void setMainMenuStart(Button mainMenuButton) {
		mainMenuButton.setOnAction(e ->{
			primary.setScene(new Scene(battle, 1000, 400));
			primary.setTitle("Battle");
		});
	}
	public void setMainMenuExit(Button mainMenuExit) {
		mainMenuExit.setOnAction(e -> {
			primary.close();
		});
	}
}
