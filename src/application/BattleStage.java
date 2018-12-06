package application;

import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class BattleStage extends VBox{
	private ProgressBar HP;
	private Label score;
	private Penguin player1;
	
	public BattleStage() {
		super(100);
		HBox status = new HBox();
		
		HP = new ProgressBar(1);
		HP.setPrefWidth(200);
		score = new Label("0");
		
		
		player1 = new Penguin();
		
		status.getChildren().addAll(score,HP);
		this.getChildren().addAll(status);
		
	}
}
