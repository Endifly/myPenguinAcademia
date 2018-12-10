package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application{
	private static MainMenu menu;
	private static BattleStage battleStage;
	private static PauseStage pauseStage;
	private EventManager eventManager;
	public static Sun sun;
	public static Time timer;
	@Override
	public void start(Stage primaryStage)  {
		// TODO Auto-generated method stub
		
		//declare pane
		StackPane rootMenu = new StackPane();
		StackPane rootBattleStage = new StackPane();
		StackPane rootPauseStage = new StackPane();
		rootMenu.setId("pane");
		rootPauseStage.setId("pausePane");
		timer = new Time();
		
		//declare UI
		menu = new MainMenu();
		battleStage = new BattleStage();
		pauseStage = new PauseStage();
		rootMenu.getChildren().addAll(menu);
		rootBattleStage.getChildren().addAll(battleStage);
		rootPauseStage.getChildren().addAll(pauseStage);
		sun = new Sun();
		
		//declare scene
		Scene menuScene = new Scene(rootMenu,util.reference.WIDTH,util.reference.HIGH);
		Scene battleScene = new Scene(rootBattleStage , util.reference.WIDTH , util.reference.HIGH);
		Scene pauseScene = new Scene(rootPauseStage , util.reference.WIDTH , util.reference.HIGH);
		menuScene.getStylesheets().addAll(this.getClass().getResource("menu.css").toExternalForm());
		pauseScene.getStylesheets().addAll(this.getClass().getResource("pause.css").toExternalForm());

		
		//event setting
		eventManager = new EventManager(menuScene, battleScene, pauseScene, primaryStage);
		eventManager.setMainMenuStart(menu.getStart());
		eventManager.setMainMenuExit(menu.getExit());
		eventManager.setBattleKeyPress(battleScene);
		eventManager.setPauseStageResume(pauseStage.getResume());
		eventManager.setPauseStageBacktoMenu(pauseStage.getBacktoMain());
		eventManager.setPauseStageExit(pauseStage.getExit());
		
		//stage setting
		primaryStage.setScene(menuScene);
		primaryStage.setResizable(false);
		primaryStage.show();
		
	}
	public static void main(String[] args) {
		launch(args);
	}		

}

