package application;
	
import java.awt.Canvas;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;


public class Main extends Application {
	private MainMenu main;
	private dino dino;
	private Button exit;
	@Override
	public void start(Stage primaryStage) {
		try {
			//default pane
			GridPane root = new GridPane();
			root.setPadding(new Insets(15));
			root.setVgap(10);
			root.setHgap(10);
			root.setPrefHeight(5);
			root.setPrefWidth(5);
			//Canvas canvas = new Canvas(200 , 200);
			
			main = new MainMenu();
			dino = new dino();
			
			root.setConstraints(main.menu,0,0);
			root.setConstraints(dino, 0, 30);
			root.getChildren().add(main.menu);
			root.getChildren().add(dino);
			
			//thread for update ui
			Thread update = new Thread(() -> {
				while(true) {
					try {
					Thread.sleep(16);
					updateUI();
					} catch (Exception r) {
						r.printStackTrace();
					}
					
				}
			});
			update.start();
			
			//scene create
			Scene scene = new Scene(root,800,800);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("My penguin academia");
			primaryStage.show();
			
			exit = new Button("EXIT");
			exit.setPrefWidth(200);
			exit.setOnAction(e -> {
				primaryStage.close();
				update.interrupted();
			});
			root.setConstraints(exit, 0, 3);
			root.getChildren().add(exit);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	public void updateUI() {
		main.update();
		dino.update();
	}
}
