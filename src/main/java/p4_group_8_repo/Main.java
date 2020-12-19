/**
 * @author - Malvi Suresh Bid (20187945)
 */
package p4_group_8_repo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import p4_group_8_repo.Controllers.MainMenuController;


import java.io.IOException;

/**
 * Main class has the single responsibility of changing scenes.
 */
public class Main extends Application {

	private static Scene scene;

	/**
	 * Launches this Javafx application.
	 * @param args -
	 */
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * Start method is responsible managing change of scene.
	 * @param primaryStage - the only stage which hosts multiple scenes.
	 * @throws Exception -
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {

		scene  = new Scene(loadFXML("MainMenuView"),600,800);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	/**
	 *	This method sets the root node of the scene.
	 * @param fxml - name of the specific fxml view file.
	 * @throws IOException -
	 */
	public static void setRoot(String fxml) throws IOException {
		scene.setRoot(loadFXML(fxml));
	}

	/**
	 * This method gets the fxml files which are stored in resources directory inside Views directory.
	 * @param fxml
	 * @return the view that needs to be loaded to the scene.
	 * @throws IOException -
	 */
	private static Parent loadFXML(String fxml) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource( "Views/" + fxml + ".fxml"));
		return fxmlLoader.load();
	}


}
