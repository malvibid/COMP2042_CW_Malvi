package p4_group_8_repo;

import javafx.scene.image.Image;
import p4_group_8_repo.Enums.HomeBaseType;

import java.lang.reflect.Array;

import static p4_group_8_repo.ImageLoader.HOMEBASE_SPRITES;

/**
 * This class represents the players home, which is at the top of the screen.
 * There are 5 places where the Player must jump into in order to move to the next level.
 * These home bases have 4 kinds of animation states: a fly for a bonus, an alligator to kill the player, a frog that has been saved, and an empty slot.
 * These states are defined in the enumerator 'HomeBaseType'
 * @see HomeBaseType
 */
public class End extends Actor{

	//The dimensions of one sprite.
	public static final int SPRITE_WIDTH    = 40;
	public static final int SPRITE_HEIGHT   = 40;

	boolean activated = false;
	private final Image[] imageArray;

	@Override
	public void act(long now) {
		// TODO Auto-generated method st
	}

	/**
	 * Constructor to instantiate End sprites.
	 * @param x X position
	 * @param y Y position
	 */
	public End(int x, int y) {
		setX(x);
		setY(y);
		imageArray = GetImageFromSpriteSheet.getImage(4, SPRITE_WIDTH, SPRITE_HEIGHT, HOMEBASE_SPRITES);
		setImage((Image) Array.get(imageArray, HomeBaseType.EMPTY_END.ordinal()));
	}

	/**
	 * If a frog has reached one the home bases save a frog in that position.
	 */
	public void setEnd() {
		setImage((Image) Array.get(imageArray, HomeBaseType.SAVED_FROG.ordinal()));
		activated = true;
	}

	/**
	 * Checks if a homebase is taken or not.
	 * @return true if frog has been saved in one of the homebase else false.
	 */
	public boolean isActivated() {
		return activated;
	}

}
