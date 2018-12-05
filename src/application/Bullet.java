package application;

public class Bullet {
	private String name;
	private String imagePath;
	private int damage;
	private int m,c;
	private double speed;
	
	public Bullet(String name, int damage , String imagePath , int m , int c,Penguin body) {
		this.name = name;
		this.damage = damage;
		this.imagePath = imagePath;
		this.m = m;
		this.c = c;
	}
	public Bullet() {
		this.name = "default";
		this.damage = 10;
		this.imagePath = "eiei";

	}
	
}
