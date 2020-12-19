package p4_group_8_repo.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import p4_group_8_repo.Highscore;
import p4_group_8_repo.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static p4_group_8_repo.Controllers.GamePlayController._highscore;

/**
 * This class controls the display of high score within the main menu.
 */
public class HighScoreBoardController implements Initializable {

    private Highscore highscore = new Highscore();
    @FXML
    Label highScoreLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        highScoreLabel.setText("Your highest score is: " + _highscore);
    }

    /**
     * If button pressed set scene to Main Menu.
     * @throws IOException
     */
    public void goToMainMenu() throws IOException {
        Main.setRoot("MainMenuView");
    }
}
