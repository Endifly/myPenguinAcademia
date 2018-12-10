package application;

import java.util.List;

import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import util.fireable;
import util.reference;
import monster.*;

public class Bullet {
	private String name;
	private String imagePath;
	private int damage;
	protected int h,k;
	private int m,c;
	private double speed;
	private int r;
	private GraphicsContext bulletGC;
	
	public Bullet(String name, int damage , String imagePath , int m , int c,fireable firer , GraphicsContext gc) {
		this.name = name;
		this.damage = damage;
		this.imagePath = imagePath;
		this.h = firer.getH();
		this.k = firer.getK();
		this.m = m;
		this.c = c;
		r = (int) (this.LoadImage(imagePath).getHeight())/2;
		//bulletPicture = new Canvas(90, 90);
		bulletGC = gc;
		//bulletGC.drawImage(this.LoadImage(imagePath), h, k);
		this.addBullet();
		//bulletGC.fillRect(0, 0, util.reference.WIDTH, util.reference.HIGH);
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
				bulletGC.clearRect(h, k, this.LoadImage(imagePath).getWidth(), this.LoadImage(imagePath).getHeight());
				k = k-10;
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
	public void remove() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				bulletGC.clearRect(h, k, this.LoadImage(imagePath).getWidth(), this.LoadImage(imagePath).getHeight());
			}
			private Image LoadImage(String imagePath) {
				return new Image(ClassLoader.getSystemResource(imagePath).toString());
			}
		});
	}
	public int getH() {
		return h;
	}
	public int getK() {
		return k;
	}
	public boolean isIn(List<Monster> monster) {
			for (int i=monster.size()-1 ; i >= 0 ; i--) {
				Monster e = monster.get(i);
				int deltaX = e.getCenterX()-this.getCenterX();
				int deltaY = e.getCenterY()-this.getCenterY();
				int deltaR = e.getR()+this.getR();
				if (Math.sqrt((deltaX*deltaX+deltaY*deltaY)) < Math.abs(deltaR)){
					e.setHp(e.getHp()-this.damage);
					if (e.getHp() <= 0) {
						monster.remove(i);
						e.remove();
					}
					/*System.out.println("debug-------------------------------");
					System.out.println(e.getH());
					System.out.println(e.getCenterX());
					System.out.println(e.getK());
					System.out.println(e.getCenterY());
					System.out.println(this.getH());
					System.out.println(this.getCenterX());
					System.out.println(this.getK());
					System.out.println(this.getCenterY());
					System.out.println(deltaR);
					System.out.println("debug-------------------------------");*/
					return true;
				}
			}
			return false;
	}
	public boolean isAt(Penguin e) {
		int deltaX = e.getCenterX()-this.getCenterX();
		int deltaY = e.getCenterY()-this.getCenterY();
		int deltaR = e.getR()+this.getR();
		/*System.out.println("debug-------------------------------");
		System.out.println(e.getH());
		System.out.println(e.getCenterX());
		System.out.println(e.getK());
		System.out.println(e.getCenterY());
		System.out.println(this.getH());
		System.out.println(this.getCenterX());
		System.out.println(this.getK());
		System.out.println(this.getCenterY());
		System.out.println(deltaR);
		System.out.println(Math.sqrt((deltaX*deltaX+deltaY*deltaY)));
		System.out.println("debug-------------------------------");*/
		if (Math.sqrt((deltaX*deltaX+deltaY*deltaY)) < Math.abs(deltaR)) {
			return true;
		}
		else {
			return false;
		}
	}
	public int getCenterX() {
		return this.h+r;
	}
	public int getCenterY() {
		return this.k+r;
	}
	public int getR() {
		return r;
	}
	public int getDamage() {
		return this.damage;
	}
	public void addBullet() {
		BattleStage.addPlayerBullet(this);
	}
	
}
