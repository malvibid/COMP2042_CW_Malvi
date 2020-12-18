package p4_group_8_repo;

import javafx.scene.image.Image;

public class Log extends Actor {

	public static final int LOG_1_WIDTH = 95;
	public static final int LOG_2_WIDTH = 196;
	public static final int LOG_3_WIDTH = 127;

	private double speed;
	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX()>600 && speed>0)
			setX(-180);
		if (getX()<-300 && speed<0)
			setX(700);
	}

	public Log(Image imageLink, int xpos, int ypos, double s) {
		setImage(imageLink);
		setX(xpos);
		setY(ypos);
		speed = s;
	}

	public boolean getLeft() {
		return speed < 0;
	}
}
