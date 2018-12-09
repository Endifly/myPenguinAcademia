package application;

import util.reference;
import monster.*;

import java.util.List;
import java.beans.DefaultPersistenceDelegate;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

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
import monster.Monster;

public class BattleStage extends VBox{
	private ProgressBar HP;
	private Label score;
	private Penguin player1;
	private Canvas battleStageCanvas;
	private static List<Bullet> bullets;
	private static List<Monster> monster;
	private  static Thread bulletsManager;
	private static Thread sekMonster;
	private static Thread monsterManager;
	
	public BattleStage() {
		super(10);
		HBox status = new HBox();
		status.setAlignment(Pos.CENTER);
		
		HP = new ProgressBar(1);
		HP.setPrefWidth(util.reference.PREFWIDTH);
		score = new Label("0");
		score.setPrefWidth(util.reference.PREFWIDTH);
		HP.setPrefWidth(util.reference.PREFWIDTH);
		bullets = new CopyOnWriteArrayList<Bullet>();
		monster = new CopyOnWriteArrayList<Monster>();
		
		battleStageCanvas = new Canvas(util.reference.WIDTH, util.reference.HIGH-60);
		GraphicsContext battleStageGC = battleStageCanvas.getGraphicsContext2D();
		player1 = new Penguin(battleStageGC);
		
		this.bulletsManagerThread();
		
		//monster manager
		sekMonster = new Thread(() -> {
			monster.clear();
			System.out.println("sekMonster");
			for (int i=0 ; i<8 ; i++) {
				monster.add(new Monster(battleStageGC));
			}
			//System.out.println(monster.size());
			monsterManager.start();
		});
		monsterManager = new Thread(() -> {
			try {
				System.out.println("monsterManager");
				while(true) {
					Thread.sleep(100);
					for (int i = monster.size()-1 ; i >= 0 ; i--) {
						System.out.println(i);
						monster.get(i).draw();
					}
				}
				//sekMonster.start();

			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		sekMonster.start();
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
	public static void addMonster(Monster e) {
		monster.add(e);
	}
	private Image LoadImage(String imagePath) {
		return new Image(ClassLoader.getSystemResource(imagePath).toString());
	}
	private void bulletsManagerThread() {
		bulletsManager = new Thread(() -> {
			try {
				while(true) {
					Thread.sleep(16);
					//System.out.println( bullets.size());
					for (int i = bullets.size()-1 ; i >= 0 ; i--) {
						bullets.get(i).draw();
						if (bullets.get(i).getK() < -80) {
							//System.out.println("removed");
							bullets.get(i).remove();
							bullets.remove(i);
						}
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		bulletsManager.start();
	} 
	/*private void sekMonster() {
		sekMonster = new Thread(() -> {
			monster.clear();
			for (int i=0 ; i<8 ; i++) {
				monster.add(new Monster());
			}
		});
		monsterManager.start();
	}
	private void monsterManagerThread() {
		monsterManager = new Thread(() -> {
			try {
				while(true) {
					Thread.sleep(16);
					for (int i = monster.size()-1 ; i >= 0 ; i--) {
						monster.get(i).draw();

					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		sekMonster.start();
	} */

	public static void stop() {
		bulletsManager.interrupt();
		sekMonster.interrupt();
		monsterManager.interrupt();
		bullets.clear();
		monster.clear();
	}
}
