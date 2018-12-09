package monster;

import application.*;
import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Monster {
	private int hp;
	private int atk;
	private String imagepath;
	private int score;
	private int h,k;
	private int m,c;
	private double speedMon,speed;
	private Canvas bulletPicture;
	private GraphicsContext monsterGC;
	
	public Monster(GraphicsContext gc) {
		this.hp = 1;
		this.atk = 1;
		this.imagepath = "";
		this.score = 100;
		monsterGC = gc;
	}
	public Monster(int hp,int atk,String imagepath,int score,int m,int c,double speedMon,double speed,GraphicsContext monsterGC) {
		this.hp = hp;
		this.atk = atk;
		this.imagepath = imagepath;
		this.score = score;
		this.m = m;
		this.c = c;
		this.speed = speed;
		this.speedMon = speedMon;
		this.monsterGC = monsterGC;
		BattleStage.addMonster(this);
	}
	private Image LoadImage(String imagePath) {
		return new Image(ClassLoader.getSystemResource(imagepath).toString());
	}
	public void draw() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				if (k < 600) {
					monsterGC.clearRect(h, k, 84, 67);
					k = k+10;
					h = h+10;
					monsterGC.drawImage(this.LoadImage("bullet-default.png"), h, k);
				}
			}
			private Image LoadImage(String imagePath) {
				return new Image(ClassLoader.getSystemResource(imagePath).toString());
			}
		});
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getAtk() {
		return atk;
	}
	public void setAtk(int atk) {
		this.atk = atk;
	}
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}
	public int getK() {
		return k;
	}
	public void setK(int k) {
		this.k = k;
	}
	public int getM() {
		return m;
	}
	public void setM(int m) {
		this.m = m;
	}
	public int getC() {
		return c;
	}
	public void setC(int c) {
		this.c = c;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public Canvas getBulletPicture() {
		return bulletPicture;
	}
	public void setBulletPicture(Canvas bulletPicture) {
		this.bulletPicture = bulletPicture;
	}
	public GraphicsContext getMonsterGC() {
		return monsterGC;
	}
	public void setMonsterGC(GraphicsContext monsterGC) {
		this.monsterGC = monsterGC;
	}
	public boolean destroy() {
		return hp==0;
	}
	public void update() {
		
	}
}