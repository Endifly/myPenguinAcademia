package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application{
	private static MainMenu menu;
	private static BattleStage battleStage;
	@Override
	public void start(Stage primaryStage)  {
		// TODO Auto-generated method stub
		StackPane rootMenu = new StackPane();
		StackPane rootBattleStage = new StackPane();
		
		menu = new MainMenu(primaryStage,rootBattleStage);
		battleStage = new BattleStage();
		rootMenu.getChildren().addAll(menu);
		
		Scene sceneFirst = new Scene(rootMenu,600,300);
		//Scene sceneBattleStage = new 
		
		primaryStage.setScene(sceneFirst);
		primaryStage.show();
		
	}
	public static void main(String[] args) {
		launch(args);
	}		

}

