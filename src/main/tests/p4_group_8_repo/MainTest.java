package p4_group_8_repo;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.testfx.framework.junit5.ApplicationTest;

import java.io.IOException;

/**
 * Created Application test to perform JavaFX GUI tests.
 */
public class MainTest extends ApplicationTest {
    private static Scene scene;

    public static void main(String[] args) {

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

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource( "Views/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }

}