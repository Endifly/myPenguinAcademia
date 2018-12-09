package application;

import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Bullet {
	private String name;
	private String imagePath;
	private int damage;
	private int h,k;
	private int m,c;
	private double speed;
	private Canvas bulletPicture;
	private GraphicsContext bulletGC;
	
	public Bullet(String name, int damage , String imagePath , int m , int c,Penguin firer , GraphicsContext gc) {
		this.name = name;
		this.damage = damage;
		this.imagePath = imagePath;
		this.h = firer.getH();
		this.k = firer.getK();
		this.m = m;
		this.c = c;
		bulletPicture = new Canvas(90, 90);
		bulletGC = gc;
		//bulletGC.drawImage(this.LoadImage(imagePath), h, k);
		BattleStage.addBullet(this);
	}
	private Image LoadImage(String imagePath) {
		return new Image(ClassLoader.getSystemResource(imagePath).toString());
	}
	public Bullet() {
		this.name = "default";
		this.damage = 10;
		this.imagePath = "eiei";

	}
	public void draw() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				bulletGC.clearRect(h, k, 84, 67);
				bulletGC.drawImage(this.LoadImage(imagePath), h, k);
			}
			private Image LoadImage(String imagePath) {
				return new Image(ClassLoader.getSystemResource(imagePath).toString());
			}
		});
	}
	public String getImagePath() {
		return imagePath;
	}
	public int getH() {
		return h;
	}
	public int getY() {
		return k;
	}
	//public void isIn(bullet)
	
}
