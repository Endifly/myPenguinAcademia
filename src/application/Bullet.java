package application;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;

public class Bullet {
	private String name;
	private String imagePath;
	private int damage;
	private int m,c;
	private double speed;
	private Canvas bulletPicture;
	
	public Bullet(String name, int damage , String imagePath , int m , int c,Penguin body) {
		this.name = name;
		this.damage = damage;
		this.imagePath = imagePath;
		this.m = m;
		this.c = c;
		bulletPicture = new Canvas(util.reference.WIDTH, 600);
	}
	private Image LoadImage(String imagePath) {
		return new Image(ClassLoader.getSystemResource(imagePath).toString());
	}
	public Bullet() {
		this.name = "default";
		this.damage = 10;
		this.imagePath = "eiei";

	}
	
}
