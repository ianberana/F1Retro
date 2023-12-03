package application;
import resources.*;

import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MyCar extends Sprite{
	private String name;
	private int strength;
	private boolean alive;

	public final static Image SHIP_IMAGE = new Image("/resources/images/mycar.png",MyCar.SHIP_WIDTH,0,false,false);
	private final static int SHIP_WIDTH = 200;

	public MyCar(String name, int x, int y){
		super(x,y);
		this.name = name;
		Random r = new Random();
		this.strength = r.nextInt(151)+100;
		this.alive = true;

		this.loadImage(MyCar.SHIP_IMAGE);
	}
	//getters

	public boolean isAlive(){
		if(this.alive) return true;
		return false;
	}
	public String getName(){
		return this.name;
	}

	public void die(){
    	this.alive = false;
    }

	public void move() {
    	this.x += this.dx;
    	this.y += this.dy;
	}

}
