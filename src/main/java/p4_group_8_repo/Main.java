package p4_group_8_repo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import p4_group_8_repo.Controllers.MainMenuController;


import java.io.IOException;

public class Main extends Application {

	private static Scene scene;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		scene  = new Scene(loadFXML("MainMenuView"),600,800);
		primaryStage.setScene(scene);
		primaryStage.show();

	}


	public static void setRoot(String fxml) throws IOException {
		scene.setRoot(loadFXML(fxml));
	}

	private static Parent loadFXML(String fxml) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource( "Views/" + fxml + ".fxml"));
		return fxmlLoader.load();
	}


}
