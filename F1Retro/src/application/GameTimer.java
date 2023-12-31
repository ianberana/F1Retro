package application;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class GameTimer extends AnimationTimer{

	private GraphicsContext gc;
	private Scene theScene;
	private MyCar myCar;


	GameTimer(GraphicsContext gc, Scene theScene){
		this.gc = gc;
		this.theScene = theScene;
		this.myCar = new MyCar("Going merry",100,100);
		//call method to handle mouse click event
		this.handleKeyPressEvent();
	}

	@Override
	public void handle(long currentNanoTime) {
		this.gc.clearRect(0, 0, GameStage.WINDOW_WIDTH,GameStage.WINDOW_HEIGHT);

		//call the methods to move the ship
		this.myCar.move();

		//render the ship
		this.myCar.render(this.gc);

	}


	//method that will listen and handle the key press events
	private void handleKeyPressEvent() {
		theScene.setOnKeyPressed(new EventHandler<KeyEvent>(){
			public void handle(KeyEvent e){
            	KeyCode code = e.getCode();
                moveMyShip(code);
			}

		});

		theScene.setOnKeyReleased(new EventHandler<KeyEvent>(){
		            public void handle(KeyEvent e){
		            	KeyCode code = e.getCode();
		                stopMyShip(code);
		            }
		        });
    }

	//method that will move the ship depending on the key pressed
	private void moveMyShip(KeyCode ke) {
		if(ke==KeyCode.UP) this.myCar.setDY(-3);

		if(ke==KeyCode.LEFT) this.myCar.setDX(-3);

		if(ke==KeyCode.DOWN) this.myCar.setDY(3);

		if(ke==KeyCode.RIGHT) this.myCar.setDX(3);

		System.out.println(ke+" key pressed.");
   	}

	//method that will stop the ship's movement; set the ship's DX and DY to 0
	private void stopMyShip(KeyCode ke){
		this.myCar.setDX(0);
		this.myCar.setDY(0);
	}


}
