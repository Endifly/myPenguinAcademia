package application;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;

public class Penguin extends StackPane{
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
	
	public Penguin(GraphicsContext gc) {
		super();
		this.level = 1;
		this.maxHP = 100;
		this.hp = 100;
		this.bullet = new Bullet();
		penguinPane = gc;
		penguinPane.drawImage(this.LoadImage("Untitled.png"), h, k);
		
	}
	public void fire() {
		
	}
	public void update() {
		
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
	private Image LoadImage(String imagePath) {
		return new Image(ClassLoader.getSystemResource(imagePath).toString());
	}
}
