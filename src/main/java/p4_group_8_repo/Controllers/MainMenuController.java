package p4_group_8_repo.Controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import p4_group_8_repo.Main;

import java.io.IOException;
import java.util.Optional;

public class MainMenuController {


    @FXML
    private AnchorPane anchorPane; //with the help of this Anchor Pane we can fetch the stage object inside the controller.

    //When play button is clicked on in the main menu, then change scene to play game, in startPlay method in Main class.
    public void playGame() throws IOException {
        Main.setRoot("GamePlayView");
    }

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
