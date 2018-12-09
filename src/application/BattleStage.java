package application;

import util.reference;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BattleStage extends VBox{
	private ProgressBar HP;
	private Label score;
	private Penguin player1;
	private Canvas battleStageCanvas;
	private int x = 4*152;
	private int y = 4*118;
	private static ArrayList<Bullet> bullets;
	private static Thread bulletsManager;
	
	public BattleStage() {
		super(10);
		HBox status = new HBox();
		status.setAlignment(Pos.CENTER);
		
		HP = new ProgressBar(1);
		HP.setPrefWidth(util.reference.PREFWIDTH);
		score = new Label("0");
		score.setPrefWidth(util.reference.PREFWIDTH);
		HP.setPrefWidth(util.reference.PREFWIDTH);
		
		battleStageCanvas = new Canvas(util.reference.WIDTH, util.reference.HIGH-60);
		GraphicsContext battleStageGC = battleStageCanvas.getGraphicsContext2D();
		player1 = new Penguin(battleStageGC);
		
		status.getChildren().addAll(score,HP);
		this.getChildren().addAll(status,battleStageCanvas);
		
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
		return battleStageCanvas;
	}
	public void setPenguin1(Canvas penguin1) {
		this.battleStageCanvas = penguin1;
	}
	public static void addBullet(Bullet e) {
		bullets.add(e);
	}
	private Image LoadImage(String imagePath) {
		return new Image(ClassLoader.getSystemResource(imagePath).toString());
	}
}
