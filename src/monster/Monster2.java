package monster;

import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Monster2 extends Monster{
	public Monster2(GraphicsContext gc,int h,int k) {
		super(gc,h,k);
	}
	public Monster2(int hp,int atk,String imagepath,int score,int m,int c,double speedMon,double speed,GraphicsContext monsterGC) {
		super(hp,atk,"bullet-transperent.jpg",score,m,c,speedMon,speed,monsterGC);
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
					h = h-10;
					monsterGC.drawImage(this.LoadImage("bullet-transperent.jpg"), h, k);
				}
			}
			private Image LoadImage(String imagePath) {
				return new Image(ClassLoader.getSystemResource(imagePath).toString());
			}
		});
	}
}
