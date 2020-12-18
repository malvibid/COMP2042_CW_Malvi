package p4_group_8_repo;

import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Turtle extends Actor{

	private static final int COLUMNS  =   3;
	private static final int COUNT    =  3;
	private static final int OFFSET_X =  0;
	private static final int OFFSET_Y =  0;
	private static final int WIDTH    = 120;
	private static final int HEIGHT   = 40;

	private int speed;
	private Image imageName;

	@Override
	public void act(long now) {

		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -75 && speed<0)
			setX(600);

	}

	public Turtle(Image imageName, int xpos, int ypos, int s) {
		this.imageName = imageName;

		setX(xpos);
		setY(ypos);
		speed = s;

		final ImageView imageView = this;
		this.setImage(imageName);
		imageView.setViewport(new Rectangle2D(OFFSET_X, OFFSET_Y, WIDTH, HEIGHT));

		final Animation animationOf3RedTurtles = new SpriteAnimation(imageView, Duration.millis(1000), COUNT, COLUMNS, OFFSET_X, OFFSET_Y, WIDTH, HEIGHT);
		animationOf3RedTurtles.setCycleCount(Animation.INDEFINITE); //play continuously.
		animationOf3RedTurtles.play();
	}

}
