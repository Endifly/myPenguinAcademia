package application;

import javafx.scene.layout.StackPane;

public class BattleStage extends StackPane{
	private Penguin player1;
	
	public BattleStage() {
		super();
		player1 = new Penguin();
		this.getChildren().addAll(player1);
	}
}
