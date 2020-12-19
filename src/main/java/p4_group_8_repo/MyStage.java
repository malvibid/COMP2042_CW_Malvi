package p4_group_8_repo;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

/**
 * This is a Concrete class of the game World. It is responsible for media player.
 */
public class MyStage extends World{
	MediaPlayer mediaPlayer;
	@Override
	public void act(long now) {
		
	}

	/**
	 * Default constructor
	 */
	public MyStage() {

	}

	/**
	 * This method plays music.
	 */
	public void playMusic() {
		String musicFile = "src/main/resources/p4_group_8_repo/assets/Frogger Main Song Theme (loop).mp3";
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	    mediaPlayer.play();
	}

	/**
	 * This method is used to stop the background music.
	 */
	public void stopMusic() {
		mediaPlayer.stop();
	}

}
