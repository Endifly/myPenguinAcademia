package application;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class dino extends HBox{
	private String imagePath;
	private Canvas dinoPane;
	private boolean stop;
	private Button jump;
	private int move = 4;
	public double y=0;
	public dino() {
		super();
		dinoPane = new Canvas(700, 400);
		dinoPane.getGraphicsContext2D().setFill(Color.AQUA);
		dinoPane.getGraphicsContext2D().setStroke(Color.AQUA);
		dinoPane.getGraphicsContext2D().drawImage(this.LoadImage("dinosaur.jpg"), 0, y);
		jump = new Button("Jump");
		jump.setOnAction(e -> {
			stop = false;
			Thread j2 = new Thread(() -> {
				try {
					while(true) {
						Thread.sleep(8888);
						y -= move;
						if (y<-50) move = -move;
						if (move == -4 && y>1) {
							move = -move;
							stop = true;
							break;
						}
					}
	
				} catch (Exception x) {
					
				}
			});
			j2.start();
			if (stop) j2.interrupt();
		});
		this.getChildren().addAll(jump,dinoPane);
		
	}
	private Image LoadImage(String imagePath) {
		return new Image(ClassLoader.getSystemResource(imagePath).toString());
	}
	public void update() {
		dinoPane.getGraphicsContext2D().drawImage(this.LoadImage("dinosaur.jpg"), 0, y);
	}
	public void setY(double y) {
		this.y = y;
	}

}
