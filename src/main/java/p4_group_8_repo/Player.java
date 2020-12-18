package p4_group_8_repo;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.lang.reflect.Array;
import java.util.ArrayList;
import static p4_group_8_repo.Enums.FrogType.*;
import static p4_group_8_repo.Controllers.GamePlayController.calculateColumn;
import static p4_group_8_repo.Controllers.GamePlayController.calculateRow;
import static p4_group_8_repo.ImageLoader.FROG_SPRITES;


public class Player extends Actor {

	public static final int SPRITE_WIDTH    = 40;
	public static final int SPRITE_HEIGHT   = 40;

	int points = 0;
	int end = 0;
	private boolean second = false;
	boolean noMove = false;
	int movement = 25;
	int imgSize = 40;
	boolean carDeath = false;
	boolean waterDeath = false;
	boolean stop = false;
	boolean changeScore = false;
	int carD = 0;
	double w = 640;
	ArrayList<End> inter = new ArrayList<End>();

	static Player frog = null;

	private Player(Image imageName) {


		Image[] imageArray = GetImageFromSpriteSheet.getImage(8, SPRITE_WIDTH, SPRITE_HEIGHT, imageName);

		setImage((Image) Array.get(imageArray, UP_IDLE.ordinal()));
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
							setImage((Image) Array.get(imageArray, UP_IDLE.ordinal()));
							second = false;
						}
						else if (event.getCode() == KeyCode.A || event.getCode() == KeyCode.LEFT) {
							move(-movement, 0);
							setImage((Image) Array.get(imageArray, LEFT_IDLE.ordinal()));
							second = false;
						}
						else if (event.getCode() == KeyCode.S || event.getCode() == KeyCode.DOWN) {
							move(0, -movement);
							setImage((Image) Array.get(imageArray, DOWN_IDLE.ordinal()));
							second = false;
						}
						else if (event.getCode() == KeyCode.D || event.getCode() == KeyCode.RIGHT) {
							move(movement, 0);
							setImage((Image) Array.get(imageArray, RIGHT_IDLE.ordinal()));
							second = false;
						}
					}
					else if (event.getCode() == KeyCode.W || event.getCode() == KeyCode.UP) {
						move(0, -movement);
						setImage((Image) Array.get(imageArray, UP_JUMP.ordinal()));
						second = true;
					}
					else if (event.getCode() == KeyCode.A || event.getCode() == KeyCode.LEFT) {
						move(-movement, 0);
						setImage((Image) Array.get(imageArray, LEFT_JUMP.ordinal()));
						second = true;
					}
					else if (event.getCode() == KeyCode.S || event.getCode() == KeyCode.DOWN) {
						move(0, movement);
						setImage((Image) Array.get(imageArray, DOWN_JUMP.ordinal()));
						second = true;
					}
					else if (event.getCode() == KeyCode.D || event.getCode() == KeyCode.RIGHT) {
						move(movement, 0);
						setImage((Image) Array.get(imageArray, RIGHT_JUMP.ordinal()));
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
						setImage((Image) Array.get(imageArray, UP_IDLE.ordinal()));
						second = false;
					}
					else if (event.getCode() == KeyCode.A || event.getCode() == KeyCode.LEFT) {
						move(-movement, 0);
						setImage((Image) Array.get(imageArray, LEFT_IDLE.ordinal()));
						second = false;
					}
					else if (event.getCode() == KeyCode.S || event.getCode() == KeyCode.DOWN) {
						move(0, movement);
						setImage((Image) Array.get(imageArray, DOWN_IDLE.ordinal()));
						second = false;
					}
					else if (event.getCode() == KeyCode.D || event.getCode() == KeyCode.RIGHT) {
						move(movement, 0);
						setImage((Image) Array.get(imageArray, RIGHT_IDLE.ordinal()));
						second = false;
					}
				}
			}

		});
	}

	public static Player getInstance(){

		if(frog == null){
			frog = new Player(FROG_SPRITES);
		}

		return frog;
	}

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
			if ((now)% 11 ==0) {
				carD++;
			}
			if (carD==1) {
				setImage(new Image("file:src/main/resources/p4_group_8_repo/assets/cardeath1.png", imgSize, imgSize, true, true));
			}
			if (carD==2) {
				setImage(new Image("file:src/main/resources/p4_group_8_repo/assets/cardeath2.png", imgSize, imgSize, true, true));
			}
			if (carD==3) {
				setImage(new Image("file:src/main/resources/p4_group_8_repo/assets/cardeath3.png", imgSize, imgSize, true, true));
			}
			if (carD == 4) {
				respawn();
				carDeath = false;
				carD = 0;
				setImage(new Image("file:src/main/resources/p4_group_8_repo/assets/froggerUp.png", imgSize, imgSize, true, true));
				noMove = false;
				if (points>50) {
					points-=50;
					changeScore = true;
				}
			}

		}
		if (waterDeath) {
			noMove = true;
			if ((now)% 11 ==0) {
				carD++;
			}
			if (carD==1) {
				setImage(new Image("file:src/main/resources/p4_group_8_repo/assets/waterdeath1.png", imgSize,imgSize , true, true));
			}
			if (carD==2) {
				setImage(new Image("file:src/main/resources/p4_group_8_repo/assets/waterdeath2.png", imgSize,imgSize , true, true));
			}
			if (carD==3) {
				setImage(new Image("file:src/main/resources/p4_group_8_repo/assets/waterdeath3.png", imgSize,imgSize , true, true));
			}
			if (carD == 4) {
				setImage(new Image("file:src/main/resources/p4_group_8_repo/assets/waterdeath4.png", imgSize,imgSize , true, true));
			}
			if (carD == 5) {
				respawn();
				waterDeath = false;
				carD = 0;
				setImage(new Image("file:src/main/resources/p4_group_8_repo/assets/froggerUp.png", imgSize, imgSize, true, true));
				noMove = false;
				if (points>50) {
					points-=50;
					changeScore = true;
				}
			}

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

	private void respawn() {
		setX(calculateColumn(6));
		setY(calculateRow(14) + 6);
//		setY(calculateRow(8) + 6);
	}

	public boolean getStop() {
		return end==5;
	}

	public int getPoints() {
		return points;
	}

	public boolean changeScore() {
		if (changeScore) {
			changeScore = false;
			return true;
		}
		return false;

	}

}
