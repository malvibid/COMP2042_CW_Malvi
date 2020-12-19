package p4_group_8_repo;

import javafx.scene.image.Image;

/**
 * This class holds objects of the numbers displayed for the score.
 */
public class Digit extends Actor{
	int dim;
	Image im1;
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Gets the score digits.
	 * @param n specifies which digit it is.
	 * @param dim dimensions (width and height) of the image This is a square.
	 * @param x X position.
	 * @param y Y position.
	 */
	public Digit(int n, int dim, int x, int y) {
		im1 = new Image("file:src/main/resources/p4_group_8_repo/assets/"+n+".png", dim, dim, true, true);
		setImage(im1);
		setX(x);
		setY(y);
	}
	
}
