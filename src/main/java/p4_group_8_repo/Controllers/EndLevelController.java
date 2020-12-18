package p4_group_8_repo.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import p4_group_8_repo.Main;
import p4_group_8_repo.Player;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EndLevelController implements Initializable {

    Player frog = Player.getInstance();

    @FXML
    Label scoreLabel;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        scoreLabel.setText("Your High Score: "+ frog.getPoints());
    }

    public void playAgain() throws IOException {

        Main.setRoot("GamePlayView");

    }

    public void goToMainMenu() throws IOException {
        Main.setRoot("MainMenuView");
    }

//    public void end(){
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("You Have Won The Game!");
//        alert.setHeaderText("Your High Score: "+ frog.getPoints()+"!");
//        alert.setContentText("Highest Possible Score: 800");
//        alert.show();
//    }
}
