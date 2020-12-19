package p4_group_8_repo;

import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 * This class is responsible for the green turtles which can sink inside the water.
 * Like the red turtles, these are of two types.
 */
public class WetTurtle extends Actor{
	private Image imageName;
	SpriteAnimation animationOf3GreenTurtles;

	private static final int COLUMNS  =   3;
	private static final int COUNT    =  3;
	private static final int OFFSET_X =  0;
	private static final int OFFSET_Y =  0;
	private static final int WIDTH    = 120;
	private static final int HEIGHT   = 40;

	private int speed;
	boolean sunk = false;

	/**
	 * This constructor instantiates the turtles and configures it's animation.
	 * @param imageName Image
	 * @param xpos X position
	 * @param ypos Y position
	 * @param s speed
	 */
	public WetTurtle(Image imageName, int xpos, int ypos, int s) {
		this.imageName = imageName;

		setX(xpos);
		setY(ypos);
		speed = s;

		final ImageView imageView = this;
		this.setImage(imageName);
		imageView.setViewport(new Rectangle2D(OFFSET_X, OFFSET_Y, WIDTH, HEIGHT));

		animationOf3GreenTurtles = new SpriteAnimation(imageView, Duration.millis(2500), COUNT, COLUMNS, OFFSET_X, OFFSET_Y, WIDTH, HEIGHT);
		animationOf3GreenTurtles.setCycleCount(Animation.INDEFINITE); //play continuously.
		animationOf3GreenTurtles.play();
	}

	/**
	 * Apart from moving the sprites, the act method will also check for whether the turtle has sunk or not.
	 * @param now current time
	 */
	@Override
	public void act(long now) {

		//last frame is for sunken turtle, WIDTH*(COUNT-1) accesses the viewport when turtle is sunk and sets sunk to true, so frog can't stay on a sunk turtle.
		if(animationOf3GreenTurtles.getX() == (WIDTH*(COUNT-1)))
			sunk = true;
		else sunk = false;

		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -75 && speed<0)
			setX(600);
	}

	/**
	 * Checks whether turtle is above water or has sunk.
	 * @return true if turtle is under water.
	 */
	public boolean isSunk() {
		return sunk;
	}
}
