package application;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;



public class BattleStage extends VBox{
	private ProgressBar HP;
	private Label score;
	private Penguin player1;
	private Canvas penguin1;
	
	public BattleStage() {
		super();
		HBox status = new HBox();
		
		HP = new ProgressBar(1);
		HP.setPrefWidth(200);
		score = new Label("0");
		
		
		player1 = new Penguin();
		penguin1 = new Canvas(600, 600);
		GraphicsContext penguin1GC = penguin1.getGraphicsContext2D();
		penguin1GC.drawImage(this.LoadImage("untitled.png"), 0, 0);
		penguin1GC.drawImage(this.LoadImage("untitled.png"), 152, 118);
		
		status.getChildren().addAll(score,HP);
		this.getChildren().addAll(status,penguin1);
		
	}
	private Image LoadImage(String imagePath) {
		return new Image(ClassLoader.getSystemResource(imagePath).toString());
	}
}
