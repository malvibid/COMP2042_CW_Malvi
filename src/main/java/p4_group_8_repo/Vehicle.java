package p4_group_8_repo;

import javafx.scene.image.Image;

import java.lang.reflect.Array;

/**
 * This class is responsible for instantiating all Vehicle objects.
 * It uses constructor overloading since there are different types of cars I implemented, like the original game.
 */
public class Vehicle extends Actor {

	//Dimensions of Vehicle sprites.
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

	/**
	 * This constructor gets different types of cars from a spritesheet.
	 * The types of cars in the sprite sheet are defined in the enumerator 'CarType'.
	 * @see p4_group_8_repo.Enums.CarType
	 * @param imageName image
	 * @param type type specified by enum
	 * @param xpos X position
	 * @param ypos Y position
	 * @param s speed
	 */
	public Vehicle(Image imageName, int type, int xpos, int ypos, int s){
		setX(xpos);
		setY(ypos);
		speed = s;
		Image[] imageArray = GetImageFromSpriteSheet.getImage(4, SPRITE_WIDTH, SPRITE_HEIGHT, imageName);
		setImage((Image)Array.get(imageArray, type));
	}

	/**
	 * This constructor gets 'Truck' from a single image.
	 * @param imageLink image
	 * @param xpos X position
	 * @param ypos Y position
	 * @param s speed
	 */
	public Vehicle(Image imageLink, int xpos, int ypos, int s) {
		setImage(imageLink);
		setX(xpos);
		setY(ypos);
		speed = s;
	}


}
