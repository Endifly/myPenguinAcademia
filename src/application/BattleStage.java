package application;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class BattleStage extends BorderPane{
	private Penguin player1;
	
	public BattleStage() {
		super();
		player1 = new Penguin();
		
	}
}
