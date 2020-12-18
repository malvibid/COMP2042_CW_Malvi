package p4_group_8_repo;

import javafx.scene.image.Image;
import p4_group_8_repo.Enums.HomeBaseType;

import java.lang.reflect.Array;

import static p4_group_8_repo.ImageLoader.HOMEBASE_SPRITES;

public class End extends Actor{

	public static final int SPRITE_WIDTH    = 40;
	public static final int SPRITE_HEIGHT   = 40;

	boolean activated = false;
	private final Image[] imageArray;

	@Override
	public void act(long now) {
		// TODO Auto-generated method st
	}

	public End(int x, int y) {
		setX(x);
		setY(y);
		imageArray = GetImageFromSpriteSheet.getImage(4, SPRITE_WIDTH, SPRITE_HEIGHT, HOMEBASE_SPRITES);
		setImage((Image) Array.get(imageArray, HomeBaseType.EMPTY_END.ordinal()));
	}

	public void setEnd() {
		setImage((Image) Array.get(imageArray, HomeBaseType.SAVED_FROG.ordinal()));
		activated = true;
	}

	public boolean isActivated() {
		return activated;
	}

}
