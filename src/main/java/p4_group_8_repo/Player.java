package p4_group_8_repo;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import p4_group_8_repo.Enums.FrogType;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static p4_group_8_repo.Controllers.GamePlayController.calculateColumn;
import static p4_group_8_repo.Controllers.GamePlayController.calculateRow;
import static p4_group_8_repo.Enums.FrogType.*;
import static p4_group_8_repo.ImageLoader.*;

/**
 * This singleton class represents the player.
 */
public class Player extends Actor {

	//Dimensions of player sprite.
	public static final int SPRITE_WIDTH    = 40;
	public static final int SPRITE_HEIGHT   = 40;

	int points = 0;
	int end = 0;
	private boolean second = false;
	boolean noMove = false;
	int movement = 25;
	boolean carDeath = false;
	boolean waterDeath = false;
	boolean stop = false;
	boolean changeScore = false;
	int carD = 0;
	double w = 640;
	ArrayList<End> inter = new ArrayList<>();

	static Player frog = null;
	private final Image[] frogImagesArray;

	/**
	 * This constructor handles key events and animations to move the frod according to the key pressed/ released.
	 * The different positions are define in the enumerator 'FrogType'.
	 * @see FrogType;
	 * @param imageName
	 */
	private Player(Image imageName) {

		frogImagesArray = GetImageFromSpriteSheet.getImage(8, SPRITE_WIDTH, SPRITE_HEIGHT, imageName);

		setImage((Image) Array.get(frogImagesArray, UP_IDLE.ordinal()));
		respawn();

		setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event){
				if (noMove) {

				}
				else {
					if (second) {
						if (event.getCode() == KeyCode.W || event.getCode() == KeyCode.UP) {
							move(0, -movement);
							changeScore = false;
							setImage((Image) Array.get(frogImagesArray, UP_IDLE.ordinal()));
							second = false;
						}
						else if (event.getCode() == KeyCode.A || event.getCode() == KeyCode.LEFT) {
							move(-movement, 0);
							setImage((Image) Array.get(frogImagesArray, LEFT_IDLE.ordinal()));
							second = false;
						}
						else if (event.getCode() == KeyCode.S || event.getCode() == KeyCode.DOWN) {
							move(0, -movement);
							setImage((Image) Array.get(frogImagesArray, DOWN_IDLE.ordinal()));
							second = false;
						}
						else if (event.getCode() == KeyCode.D || event.getCode() == KeyCode.RIGHT) {
							move(movement, 0);
							setImage((Image) Array.get(frogImagesArray, RIGHT_IDLE.ordinal()));
							second = false;
						}
					}
					else if (event.getCode() == KeyCode.W || event.getCode() == KeyCode.UP) {
						move(0, -movement);
						setImage((Image) Array.get(frogImagesArray, UP_JUMP.ordinal()));
						second = true;
					}
					else if (event.getCode() == KeyCode.A || event.getCode() == KeyCode.LEFT) {
						move(-movement, 0);
						setImage((Image) Array.get(frogImagesArray, LEFT_JUMP.ordinal()));
						second = true;
					}
					else if (event.getCode() == KeyCode.S || event.getCode() == KeyCode.DOWN) {
						move(0, movement);
						setImage((Image) Array.get(frogImagesArray, DOWN_JUMP.ordinal()));
						second = true;
					}
					else if (event.getCode() == KeyCode.D || event.getCode() == KeyCode.RIGHT) {
						move(movement, 0);
						setImage((Image) Array.get(frogImagesArray, RIGHT_JUMP.ordinal()));
						second = true;
					}
				}
			}
		});
		setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				if (noMove) {}
				else {
					if (event.getCode() == KeyCode.W || event.getCode() == KeyCode.UP) {
						if (getY() < w) {
							changeScore = true;
							w = getY();
							points+=10;
						}
						move(0, -movement);
						setImage((Image) Array.get(frogImagesArray, UP_IDLE.ordinal()));
						second = false;
					}
					else if (event.getCode() == KeyCode.A || event.getCode() == KeyCode.LEFT) {
						move(-movement, 0);
						setImage((Image) Array.get(frogImagesArray, LEFT_IDLE.ordinal()));
						second = false;
					}
					else if (event.getCode() == KeyCode.S || event.getCode() == KeyCode.DOWN) {
						move(0, movement);
						setImage((Image) Array.get(frogImagesArray, DOWN_IDLE.ordinal()));
						second = false;
					}
					else if (event.getCode() == KeyCode.D || event.getCode() == KeyCode.RIGHT) {
						move(movement, 0);
						setImage((Image) Array.get(frogImagesArray, RIGHT_IDLE.ordinal()));
						second = false;
					}
				}
			}

		});
	}

	/**
	 * This method enforces the singleton design pattern.
	 * There is only one instance of frog created and it can be statically accessed.
	 * @return the same single instance of Player
	 */
	public static Player getInstance(){

		if(frog == null){
			frog = new Player(FROG_SPRITES);
		}

		return frog;
	}

	/**
	 * 	This method checks for collisions, deaths and win conditions for the player
	 */
	@Override
	public void act(long now) {
		if (getY()<0 || getY()>this.getScene().getHeight()) {
			respawn();
		}

		if (getX() < 0) {
			move(movement *2, 0);
		}

		if (getX() > 600) {
			move(-movement *2, 0);
		}


		if (carDeath) {
			noMove = true;
			isDeath(now, CAR_DEATH_SPRITES, "carDeath");

		}
		if (waterDeath) {
			noMove = true;
			isDeath(now, WATER_DEATH_SPRITES, "waterDeath");

		}

		if (getIntersectingObjects(Vehicle.class).size() >= 1) {
			carDeath = true;
		}
		//stop frog from jumping after home end is reached. getX() == 240 && getY() == 82
		if (getY() == calculateRow(2)) {
			stop = true;
		}
		if (getIntersectingObjects(Log.class).size() >= 1 && !noMove) {
			if(getIntersectingObjects(Log.class).get(0).getLeft())
				move(-2,0);
			else
				move (.75,0);
		}
		else if (getIntersectingObjects(Turtle.class).size() >= 1 && !noMove) {
			move(-1,0);
		}
		else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {
			if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
				waterDeath = true;
			} else {
				move(-1,0);
			}
		}
		else if (getIntersectingObjects(End.class).size() >= 1) {
			inter = (ArrayList<End>) getIntersectingObjects(End.class);
			if (getIntersectingObjects(End.class).get(0).isActivated()) {
				end--;
				points-=50;
			}
			points+=50;
			changeScore = true;
			w=800;
			getIntersectingObjects(End.class).get(0).setEnd();
			end++;
			respawn();
		}
		else if (getY()<320){
			waterDeath = true;
		}
	}


	/**
	 * This method is called when the player dies.
	 * It sets the death animation.
	 * And refreshes the game state.
	 * @param now
	 * @param DeathSprites
	 * @param DeathType
	 */
	private void isDeath(long now, Image DeathSprites, String DeathType) {
		Image[] DeathImages = GetImageFromSpriteSheet.getImage(4, SPRITE_WIDTH, SPRITE_HEIGHT, DeathSprites);

		if (now % 11 ==0) {
			carD++;
		}
		if (carD==1) {
			setImage(DeathImages[3]);
		}
		if (carD==2) {
			setImage(DeathImages[0]);
		}
		if (carD==3) {
			setImage(DeathImages[1]);
		}
		if (carD == 4) {
			setImage(DeathImages[2]);
		}
		if (carD == 5) {
			respawn();
			if(DeathType == "carDeath")
				carDeath = false;
			if(DeathType == "waterDeath")
				waterDeath = false;
			carD = 0;
			setImage((Image) Array.get(frogImagesArray, UP_IDLE.ordinal()));
			noMove = false;
			if (points>50) {
				points-=50;
				changeScore = true;
			}
		}
	}

	/**
	 * Respwans the player to the starting position.
	 */
	private void respawn() {
		setX(calculateColumn(6));
		setY(calculateRow(14) + 6);
//		setY(calculateRow(8) + 6);
	}

	/**
	 * If the player has reached to all the 5 empty homes, then level is over.
	 * This method checks whether or not the player has filled all the empty spots.
	 * @return if all empty spots have not been filled return false.
	 */
	public boolean getStop() {
		return end==5;
	}

	/**
	 * Gets the score of the player in the last game played.
	 * @return score of game.
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * Flag to determine whether the score can be changed or not.
	 * @return true if score changed.
	 */
	public boolean changeScore() {
		if (changeScore) {
			changeScore = false;
			return true;
		}
		return false;
	}


}
