package application;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import util.controlable;
import util.fireable;

public class Penguin extends StackPane implements controlable , fireable{
	private int level;
	private int maxHP;
	private int hp;
	private int h,k;
	private int speedX , speedY;
	private Scene battleControl;
	private Bullet bullet;
	private String name;
	private String bulletType;
	private GraphicsContext penguinPane;
	private static Thread control;
	private static boolean controlRun = true;
	
	public Penguin(GraphicsContext gc) {
		super();
		this.level = 1;
		this.maxHP = 100;
		this.hp = 100;
		this.bullet = new Bullet();
		penguinPane = gc;
		penguinPane.drawImage(this.LoadImage("Untitled.png"), h, k);
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
	public static void stop() {
		controlRun = false;
	}
	private Image LoadImage(String imagePath) {
		return new Image(ClassLoader.getSystemResource(imagePath).toString());
	}

	public void up() {
		// TODO Auto-generated method stub
		penguinPane.clearRect(h, k, 152, 118);
		k = k-speedY-5;
		penguinPane.drawImage(this.LoadImage("untitled.png"), h, k);
	}
	@Override
	public void down() {
		// TODO Auto-generated method stub
		penguinPane.clearRect(h, k, 152, 118);
		k = k+speedY+5;
		penguinPane.drawImage(this.LoadImage("untitled.png"), h, k);
	}
	@Override
	public void right() {
		// TODO Auto-generated method stub
		penguinPane.clearRect(h, k, 152, 118);
		h = h+speedX+5;
		penguinPane.drawImage(this.LoadImage("untitled.png"), h, k);
		
	}
	@Override
	public void left() {
		// TODO Auto-generated method stub
		penguinPane.clearRect(h, k, 152, 118);
		h = h-speedX-5;
		penguinPane.drawImage(this.LoadImage("untitled.png"), h, k);
		
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
					if (EventManager.Z == true) this.fire();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		control.start();
		
	}
	@Override
	public void fire() {
		// TODO Auto-generated method stub
		new Bullet("whatThis", 10, "bullet-default.png", 1, 0, this , penguinPane);
		
	}
}
