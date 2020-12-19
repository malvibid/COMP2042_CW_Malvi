package p4_group_8_repo;

import javafx.scene.image.Image;

/**
 * This method is responsible for the log objects.
 */
public class Log extends Actor {

	//Each log has the same height but different widths as specified here.
	public static final int LOG_1_WIDTH = 95;
	public static final int LOG_2_WIDTH = 196;
	public static final int LOG_3_WIDTH = 127;

	private double speed;

	/**
	 * Depending whether the logs are moving towards right or left side, the act method continuously updates the logs position..
	 * When the car goes off the screen, it's wrapped around, it re-enters from starting side.
	 * @param now current time
	 */
	@Override
	public void act(long now) {
		move(getSpeed(), 0);
		if (getX()>600 && getSpeed() >0)
			setX(-180);
		if (getX()<-300 && getSpeed() <0)
			setX(700);
	}

	/**
	 * This constructor takes in single log images and sets the logs position.
	 * @param imageLink image
	 * @param xpos X position
	 * @param ypos Y position
	 * @param s speed
	 */
	public Log(Image imageLink, int xpos, int ypos, double s) {
		setImage(imageLink);
		setX(xpos);
		setY(ypos);
		speed = s;
	}

	/**
	 * If the log is moving in the left direction then we want the player to move with the frog in the left direction.
	 * @return if log is moving left, return true.
	 */
	public boolean getLeft() {
		return getSpeed() < 0;
	}

	/**
	 * Gets the speed of the log.
	 * @return speed.
	 */
	public double getSpeed() {
		return speed;
	}
}
