package application;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import util.controlable;
import util.dieable;
import util.fireable;

public class Penguin extends StackPane implements controlable , fireable, dieable{
	private int level;
	private double maxHP;
	private double hp;
	private int h = 600 , k = 500;
	private int speedX , speedY;
	private Scene battleControl;
	private Bullet bullet;
	private String name;
	private String bulletType;
	private GraphicsContext penguinPane;
	private static Thread control;
	private static boolean controlRun = true;
	private boolean zTriggerd = false , xTriggerd = false;;
	private int r;
	
	public Penguin(GraphicsContext gc) {
		super();
		this.level = 1;
		this.maxHP = 100;
		this.hp = 100;
		this.bullet = new Bullet();
		penguinPane = gc;
		penguinPane.drawImage(this.LoadImage("penguin.jpg"), h, k);
		r = (int) this.LoadImage("penguin.jpg").getHeight()/2;
		this.controlThread();
	}
	public Penguin(GraphicsContext gc , int maxHP , int speedX , int speedY) {
		super();
		this.maxHP = maxHP;
		this.hp = maxHP;
		this.speedX = speedX;
		this.speedY = speedY;
	}

	public int getH() {
		return h;
	}
	public int getK() {
		return k;
	}
	public void setH(int h) {
		this.h = h;
	}
	public void setK(int k) {
		this.k = k;
	}
	public int getLevel() {
		return level;
	}
	public double getMaxHP() {
		return maxHP;
	}
	public void setHP(double hp) {
		this.hp = hp;
	}
	public double getHp() {
		return hp;
	}
	public String getName() {
		return name;
	}
	public GraphicsContext getPenguinPane() {
		return penguinPane;
	}
	public static void stop() {
		controlRun = false;
	}
	private Image LoadImage(String imagePath) {
		return new Image(ClassLoader.getSystemResource(imagePath).toString());
	}

	public void up() {
		// TODO Auto-generated method stub
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				penguinPane.clearRect(h, k, 100, 100);
				k = k-speedY-5;
				penguinPane.drawImage(this.LoadImage("penguin.jpg"), h, k);
			}
			private Image LoadImage(String imagePath) {
				return new Image(ClassLoader.getSystemResource(imagePath).toString());
			}
		});
	}
	@Override
	public void down() {
		// TODO Auto-generated method stub
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				penguinPane.clearRect(h, k, 100, 100);
				k = k+speedY+5;
				penguinPane.drawImage(this.LoadImage("penguin.jpg"), h, k);
			}
			private Image LoadImage(String imagePath) {
				return new Image(ClassLoader.getSystemResource(imagePath).toString());
			}
		});
	}
	@Override
	public void right() {
		// TODO Auto-generated method stub
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				penguinPane.clearRect(h, k, 100, 100);
				h = h+speedX+5;
				penguinPane.drawImage(this.LoadImage("penguin.jpg"), h, k);
			}
			private Image LoadImage(String imagePath) {
				return new Image(ClassLoader.getSystemResource(imagePath).toString());
			}
		});
		
	}
	@Override
	public void left() {
		// TODO Auto-generated method stub
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				penguinPane.clearRect(h, k, 100, 100);
				h = h-speedX-5;
				penguinPane.drawImage(this.LoadImage("penguin.jpg"), h, k);
			}
			private Image LoadImage(String imagePath) {
				return new Image(ClassLoader.getSystemResource(imagePath).toString());
			}
		});
		
	}
	@Override
	public void controlThread() {
		// TODO Auto-generated method stub
		control = new Thread(() -> {
			try {
				while(controlRun) {
					Thread.sleep(16);
					if (EventManager.UP == true) this.up();
					if (EventManager.DOWN == true) this.down();
					if (EventManager.RIGHT == true) this.right();
					if (EventManager.LEFT == true) this.left();
					if (EventManager.Z == true && !zTriggerd) {
						this.fire();
						zTriggerd = true;
					}
					if (EventManager.Z == false) {
						zTriggerd = false;
					}
					if (EventManager.X == true && !xTriggerd) {
						this.fireSlant();
						xTriggerd = true;
					}
					if (EventManager.X == false) {
						xTriggerd = false;
					}
					this.stay();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		control.start();
	}
	public void stay() {
		// TODO Auto-generated method stub
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				penguinPane.clearRect(h, k, 100, 100);
				penguinPane.drawImage(this.LoadImage("penguin.jpg"), h, k);
			}
			private Image LoadImage(String imagePath) {
				return new Image(ClassLoader.getSystemResource(imagePath).toString());
			}
		});
		
	}
	@Override
	public void fire() {
		// TODO Auto-generated method stub
		new Bullet("whatThis", 10, "bullet-transperent.jpg", 1, 0, this , penguinPane);
		
	}
	public void fireSlant() {
		new BulletPlayerSlant("whatThis", 10, "bullet-transperent.jpg", 1, 0, this , penguinPane);
		new BulletPlayerSlantLeft("test", 10, "bullet-transperent.jpg", 1, 0, this, penguinPane);
	}
	@Override
	public void remove() {
		// TODO Auto-generated method stub
		penguinPane.clearRect(h, k, this.LoadImage("penguin.jpg").getWidth(), this.LoadImage("penguin.jpg").getHeight());
	}
	
	public int getCenterX() {
		return this.h+r;
	}
	public int getCenterY() {
		return this.k+r;
	}
	public int getR() {
		return this.r;
	}
}
