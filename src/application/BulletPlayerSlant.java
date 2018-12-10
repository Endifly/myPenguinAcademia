package application;

import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import util.fireable;

public class BulletPlayerSlant extends Bullet{
	private GraphicsContext bulletGC;
	private String imagePath;
	public BulletPlayerSlant(String name, int damage , String imagePath , int m , int c,fireable firer , GraphicsContext gc) {
		super(name , damage , imagePath , m , c , firer , gc);
		this.bulletGC = gc;
		this.imagePath = imagePath;
		this.h = firer.getH();
		this.k = firer.getK();
	}
	
	@Override
	public void draw() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				bulletGC.clearRect(h, k, this.LoadImage(imagePath).getWidth(), this.LoadImage(imagePath).getHeight());
				k = k-10;
				h = h+10;
				bulletGC.drawImage(this.LoadImage(imagePath), h, k);
			}
			private Image LoadImage(String imagePath) {
				return new Image(ClassLoader.getSystemResource(imagePath).toString());
			}
		});
	}
	@Override
	public void addBullet() {
		BattleStage.addPlayerBullet(this);
	}
	public int getK() {
		//System.out.println("owering");
		return this.k;
	}
	public int getH() {
		return this.h;
	}
	

}
