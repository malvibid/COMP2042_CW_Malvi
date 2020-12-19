package p4_group_8_repo;

import javafx.scene.image.Image;

/**
 * This class sets the background for the game play.
 * This is a fixed object which remains the same through out the game.
 */
public class BackgroundImage extends Actor{

	@Override
	public void act(long now) {


	}

	/**
	 * Game play background image is an actor and is set using this constructor.
	 * @param imageName image.
	 */
	public BackgroundImage(Image imageName) {
		setImage(imageName);

	}

}
