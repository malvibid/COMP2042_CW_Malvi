package p4_group_8_repo;

import javafx.scene.image.Image;

import java.lang.reflect.Array;

public class Vehicle extends Actor {

	public static final int SPRITE_WIDTH    = 40;
	public static final int SPRITE_HEIGHT   = 40;

	private int speed;
	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -50 && speed<0)
			setX(600);
	}

	//Constructor overloading. Getting different types of cars from a spritesheet.
	public Vehicle(Image imageName, int type, int xpos, int ypos, int s){
		setX(xpos);
		setY(ypos);
		speed = s;
		Image[] imageArray = GetImageFromSpriteSheet.getImage(4, SPRITE_WIDTH, SPRITE_HEIGHT, imageName);
		setImage((Image)Array.get(imageArray, type));
	}

	//Constructor overloading. Getting 'Truck' from a single image.
	public Vehicle(Image imageLink, int xpos, int ypos, int s) {
		setImage(imageLink);
		setX(xpos);
		setY(ypos);
		speed = s;
	}


}
