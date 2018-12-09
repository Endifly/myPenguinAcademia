package application;

import javafx.animation.ScaleTransition;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Sun {
	public Circle sun;
	public ScaleTransition scale;
	
	public Sun() {
		sun = new Circle();
		sun.setRadius(100);
		sun.setFill(Color.ORANGE);
		sun.setLayoutX(util.reference.WIDTH-150);
		sun.setLayoutY(150);
		//sun.setStyle("-fx-effect: dropshadow(three-pass-box, orange, 30, 0.5, 0, 0)");
		scale = new ScaleTransition(Duration.seconds(1), sun);
		scale.setToX(27);
		scale.setToY(27);
		scale.setAutoReverse(true);
		scale.setCycleCount(2);
	}
	public void raiseTheSun() {
		scale.play();
	}
	public void setRadius(int r) {
		sun.setRadius(r);
	}
}
