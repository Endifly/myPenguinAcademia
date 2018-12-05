package application;

import javafx.scene.canvas.Canvas;
import javafx.scene.layout.StackPane;

public class Penguin extends StackPane{
	private int level;
	private int maxHP;
	private int hp;
	private int h,k;
	private Bullet bullet;
	private String name;
	private String bulletType;
	private Canvas penguinPane;
	
	public Penguin() {
		super();
		penguinPane = new Canvas(900, 400);
		this.level = 1;
		this.maxHP = 100;
		this.hp = 100;
		this.bullet = new Bullet();
	}
	public void fire() {
		
	}
	public void update() {
		
	}
}
