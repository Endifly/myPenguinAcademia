package monster;

import application.bulletMonster;
import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Monster2 extends Monster{
	public Monster2(GraphicsContext gc,int h,int k,String imagepath) {
		super(gc,h,k,imagepath);
	}
	public Monster2(int hp,int atk,String imagepath,int score,int m,int c,double speedMon,double speed,GraphicsContext monsterGC) {
		super(hp,atk,"Mon2.jpg",score,m,c,speedMon,speed,monsterGC);
	}
	private Image LoadImage(String imagePath) {
		return new Image(ClassLoader.getSystemResource(imagepath).toString());
	}
	public void draw() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
					monsterGC.clearRect(h, k, 50, 50);
					k = k+10;
					h = h-10;
					monsterGC.drawImage(this.LoadImage("Mon2.jpg"), h, k);
			}
			private Image LoadImage(String imagePath) {
				return new Image(ClassLoader.getSystemResource(imagePath).toString());
			}
		});
	}
	public void fire() {
		// TODO Auto-generated method stub
		new bulletMonster("owen", 80, "bulletMons2.jpg", 1, 0, this, monsterGC);
	}
}
