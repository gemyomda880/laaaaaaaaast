package com.gluonapplication;
	
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		calculator cal=new calculator();
		cal.draw();
		
		new Thread(() -> { // lambda expression
			try{
			while(true) {
		
			  Platform.runLater(() ->cal.runS_cal()); // lambda exp
			Thread.sleep(200);
			}
			}
			catch(InterruptedException ex) {
			}
			}).start();
		
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(cal.c.calUI,300,300);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
