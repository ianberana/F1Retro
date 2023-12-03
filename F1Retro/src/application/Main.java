package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage stage){
		GameStage theGameStage = new GameStage();
		theGameStage.setStage(stage);
	}
}
