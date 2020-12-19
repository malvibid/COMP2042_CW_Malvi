package p4_group_8_repo.Controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import p4_group_8_repo.ImageLoader;
import p4_group_8_repo.Main;

import java.io.IOException;
import java.util.Optional;

/**
 * This class tells the Main class which scene to load depending on the button pressed in the main menu.
 * Image Loader object is instantiated from here to load all the images in the game.
 */
public class MainMenuController {

    ImageLoader imageLoader = new ImageLoader();

    @FXML
    private AnchorPane anchorPane; //with the help of this Anchor Pane we can fetch the stage object inside the controller.


    /**
     * If Play Game button pressed set scene to Game Play.
     * @throws IOException -
     */
    public void playGame() throws IOException {
        Main.setRoot("GamePlayView");
    }

    /**
     * If Highscore button pressed set scene to High Score Board.
     * @throws IOException -
     */
    public void highScore() throws IOException {
        Main.setRoot("HighScoreBoardView");
    }

    /**
     * If Instructions button pressed set scene to Instructions Board.
     * @throws IOException -
     */
    public void instructions() throws IOException {
        Main.setRoot("InstructionsView");
    }


    /**
     * If Exit button pressed, confirm exit; if 'Ok' selected then exit, if 'Cancel' selected then close dialog box and stay in Main Menu.
     * @throws IOException -
     */
    public void exitGame(){

        Stage stage = (Stage) anchorPane.getScene().getWindow();

        Alert.AlertType type = Alert.AlertType.CONFIRMATION;
        Alert alert = new Alert(type, "");

        //Setting modality such that user can only interact with the main stage controls after responding to the confirmation box.
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.initOwner(stage);

        alert.getDialogPane().setContentText("Are you sure you want to exit?");
        alert.getDialogPane().setHeaderText("Confirm Exit");

        //Getting the user input.
        Optional<ButtonType> result = alert.showAndWait();
        if(result.get() == ButtonType.OK){
            Platform.exit();
        }


    }

}
