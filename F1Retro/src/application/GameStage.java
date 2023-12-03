package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class GameStage {
	public static final int WINDOW_HEIGHT = 1080;
	public static final int WINDOW_WIDTH = 1920;
	private Scene scene;
	private Stage stage;
	private Group root;
	private Canvas canvas;
	private GraphicsContext gc;
	private static GameTimer gametimer;


	//the class constructor
	public GameStage() {
		this.root = new Group();
		this.scene = new Scene(root, GameStage.WINDOW_WIDTH,GameStage.WINDOW_HEIGHT);
		this.canvas = new Canvas(GameStage.WINDOW_WIDTH,GameStage.WINDOW_HEIGHT);
		this.gc = canvas.getGraphicsContext2D();
		//instantiate an animation timer
		this.gametimer = new GameTimer(this.gc,this.scene);
	}

	//method to add the stage elements
	public void setStage(Stage stage) {
		this.stage = stage;

		//set stage elements here
		this.root.getChildren().add(canvas);

		this.stage.setTitle("F1Retro");
		this.stage.setScene(this.scene);

		MainMenu();

		this.stage.setMaximized(true);
		this.stage.setResizable(false);



		this.stage.show();
	}

	public void MainMenu()
	{
		Image menu = new Image("/resources/images/menu.png");
	    this.gc.drawImage(menu, 0, 0, menu.getWidth(), menu.getHeight());

	    //Creating Buttons
	    Button play = new Button();
	    Button how = new Button();

	    play.setGraphic(new ImageView(new Image("/resources/images/play.png")));
	    how.setGraphic(new ImageView(new Image("/resources/images/play.png")));


	    VBox buttons = new VBox(play, how);
	    buttons.setTranslateX(1100);
	    buttons.setTranslateY(300);

	    this.root.getChildren().add(buttons);

	    play.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				//invoke the start method of the animation timer
				GameStage.gametimer.start();
				buttons.setVisible(false);
			}
		});
	}



}