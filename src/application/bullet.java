package application;

public abstract class bullet {
	private String name;
	private String imagePath;
	private int damage;
	private int m,c;
	private double speed;
	
	public bullet(String name, int damage , String imagePath , int m , int c,s=) {
		this.name = name;
		this.damage = damage;
		this.imagePath = imagePath;
		this.m = m;
		this.c = c;
	}
	public bullet() {
		this.name = "default";
		this.damage = 10;
		this.imagePath = "eiei";

	}
}
