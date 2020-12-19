package p4_group_8_repo.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import p4_group_8_repo.Highscore;
import p4_group_8_repo.Main;
import p4_group_8_repo.Player;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import static p4_group_8_repo.Controllers.GamePlayController._highscore;

/**
 * This class controls the scene shown after a level is completed.
 */
public class EndLevelController implements Initializable {

    Player frog = Player.getInstance();


    @FXML
    Label scoreLabel;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        scoreLabel.setText("Your current score was: " + frog.getPoints());

    }

    /**
     * If button pressed set scene to Main Menu.
     * @throws IOException -
     */
    public void goToMainMenu() throws IOException {
        Main.setRoot("MainMenuView");
    }

}
