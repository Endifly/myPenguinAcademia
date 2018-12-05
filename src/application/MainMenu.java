package application;

import javax.swing.GroupLayout.Alignment;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class MainMenu {
	public VBox menu;
	private Button play;
	private Button option;
	private Button exit;
	private boolean enable = false;
	private boolean stop = false;
	
	public MainMenu() {
		menu = new VBox();
		menu.setPrefWidth(400);
		menu.setSpacing(10);
		
		play = new Button("PLAY");
		play.setPrefWidth(200);
		play.setOnAction(e -> {
			 enable = !enable;
		});
		option = new Button("OPTION");
		option.setPrefWidth(200);
		option.setOnAction(e -> {
			enable = !enable;
			
		});
		
		menu.getChildren().add(play);
		menu.getChildren().add(option);
		
	}
	public void update() {
		if (!stop) {
			this.play.setDisable(enable);
		}
	}
	public void stop() {
		stop = true;
	}
	public void run() {
		stop = false;
	}
}
