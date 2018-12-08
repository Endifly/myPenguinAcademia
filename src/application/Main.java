package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application{
	private static MainMenu menu;
	private static BattleStage battleStage;
	private EventManager eventManager;
	@Override
	public void start(Stage primaryStage)  {
		// TODO Auto-generated method stub
		
		//declare pane
		StackPane rootMenu = new StackPane();
		StackPane rootBattleStage = new StackPane();
		StackPane rootPauseStage = new StackPane();
		
		//declare UI
		menu = new MainMenu();
		battleStage = new BattleStage();
		rootMenu.getChildren().addAll(menu);
		rootBattleStage.getChildren().addAll(battleStage);
		
		//button setting
		eventManager = new EventManager(rootMenu, rootBattleStage, rootPauseStage, primaryStage);
		eventManager.setMainMenuStart(menu.getStart());
		eventManager.setMainMenuExit(menu.getExit());
		
		//declare scene
		Scene sceneFirst = new Scene(rootMenu,util.reference.WIDTH,util.reference.HIGH);
		//Scene sceneBattleStage = new 
		
		//stage setting
		primaryStage.setScene(sceneFirst);
		primaryStage.setResizable(false);
		primaryStage.show();
		
	}
	public static void main(String[] args) {
		launch(args);
	}		

}

