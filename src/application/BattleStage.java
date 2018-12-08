package application;

import util.reference;

import javafx.geometry.Pos;
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
		super(10);
		HBox status = new HBox();
		status.setAlignment(Pos.CENTER);
		
		HP = new ProgressBar(1);
		HP.setPrefWidth(util.reference.PREFWIDTH);
		score = new Label("0");
		score.setPrefWidth(util.reference.PREFWIDTH);
		HP.setPrefWidth(util.reference.PREFWIDTH);
		
		player1 = new Penguin();
		penguin1 = new Canvas(util.reference.WIDTH, util.reference.HIGH-60);
		GraphicsContext penguin1GC = penguin1.getGraphicsContext2D();
		penguin1GC.drawImage(this.LoadImage("untitled.png"), 0, 0);
		penguin1GC.drawImage(this.LoadImage("untitled.png"), 152, 118);
		penguin1GC.drawImage(this.LoadImage("untitled.png"), 2*152, 2*118);
		penguin1GC.drawImage(this.LoadImage("untitled.png"), 3*152, 3*118);
		penguin1GC.drawImage(this.LoadImage("untitled.png"), 4*152, 4*118);
		penguin1GC.drawImage(this.LoadImage("untitled.png"), 5*152, 5*118);
		penguin1GC.drawImage(this.LoadImage("untitled.png"), 6*152, 4*118);
		penguin1GC.drawImage(this.LoadImage("untitled.png"), 7*152, 3*118);
		penguin1GC.drawImage(this.LoadImage("untitled.png"), 8*152, 2*118);
		
		status.getChildren().addAll(score,HP);
		this.getChildren().addAll(status,penguin1);
		
	}
	public ProgressBar getHP() {
		return HP;
	}
	public void setHP(ProgressBar hP) {
		HP = hP;
	}
	public Label getScore() {
		return score;
	}
	public void setScore(Label score) {
		this.score = score;
	}
	public Penguin getPlayer1() {
		return player1;
	}
	public void setPlayer1(Penguin player1) {
		this.player1 = player1;
	}
	public Canvas getPenguin1() {
		return penguin1;
	}
	public void setPenguin1(Canvas penguin1) {
		this.penguin1 = penguin1;
	}
	private Image LoadImage(String imagePath) {
		return new Image(ClassLoader.getSystemResource(imagePath).toString());
	}
}
