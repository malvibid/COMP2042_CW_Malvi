package p4_group_8_repo.Controllers;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import p4_group_8_repo.*;

import java.net.URL;
import java.util.ResourceBundle;

public class GamePlayController implements Initializable {

    AnimationTimer timer;
    Player frog = Player.getInstance();

    @FXML
    private MyStage background;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        BackgroundImage gamePlayBackgroundImage = new BackgroundImage(getLink("Background.png"));

        background.add(gamePlayBackgroundImage);

        background.add(new Log(getLink("log3.png"), 150, 0, 166, 0.75));
        background.add(new Log(getLink("log3.png"), 150, 220, 166, 0.75));
        background.add(new Log(getLink("log3.png"), 150, 440, 166, 0.75));

        background.add(new Log(getLink("logs.png"), 300, 0, 276, -2));
        background.add(new Log(getLink("logs.png"), 300, 400, 276, -2));

        background.add(new Log(getLink("log3.png"), 150, 50, 329, 0.75));
        background.add(new Log(getLink("log3.png"), 150, 270, 329, 0.75));
        background.add(new Log(getLink("log3.png"), 150, 490, 329, 0.75));

        background.add(new Turtle(500, 376, -1, 130, 130));
        background.add(new Turtle(300, 376, -1, 130, 130));
        background.add(new WetTurtle(700, 376, -1, 130, 130));
        background.add(new WetTurtle(600, 217, -1, 130, 130));
        background.add(new WetTurtle(400, 217, -1, 130, 130));
        background.add(new WetTurtle(200, 217, -1, 130, 130));

        background.add(new End(13,96));
        background.add(new End(141,96));
        background.add(new End(141 + 141-13,96));
        background.add(new End(141 + 141-13+141-13+1,96));
        background.add(new End(141 + 141-13+141-13+141-13+3,96));

        background.add(frog);
        background.add(new Vehicle(getLink("truck1Right.png"), 0, 649, 1, 120, 120));
        background.add(new Vehicle(getLink("truck1Right.png"), 300, 649, 1, 120, 120));
        background.add(new Vehicle(getLink("truck1Right.png"), 600, 649, 1, 120, 120));

        background.add(new Vehicle(getLink("car1Left.png"), 100, 597, -1, 50, 50));
        background.add(new Vehicle(getLink("car1Left.png"), 250, 597, -1, 50, 50));
        background.add(new Vehicle(getLink("car1Left.png"), 400, 597, -1, 50, 50));
        background.add(new Vehicle(getLink("car1Left.png"), 550, 597, -1, 50, 50));
        background.add(new Vehicle(getLink("truck2Right.png"), 0, 540, 1, 200, 200));
        background.add(new Vehicle(getLink("truck2Right.png"), 500, 540, 1, 200, 200));
        background.add(new Vehicle(getLink("car1Left.png"), 500, 490, -5, 50, 50));
        background.add(new Digit(0, 30, 360, 25));

        background.start();
        start();
    }

    public String getLink(String ImageName) {
        return "file:src/main/resources/p4_group_8_repo/assets/" + ImageName;
    }

    public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (frog.changeScore()) {
                    setNumber(frog.getPoints());
                }
                if (frog.getStop()) {
                    System.out.print("STOP:");
                    background.stopMusic();
                    stop();
                    background.stop();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("You Have Won The Game!");
                    alert.setHeaderText("Your High Score: "+ frog.getPoints()+"!");
                    alert.setContentText("Highest Possible Score: 800");
                    alert.show();
                }
            }
        };
    }
    public void start() {
        background.playMusic();
        createTimer();
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    public void setNumber(int n) {
        int shift = 0;
        while (n > 0) {
            int d = n / 10;
            int k = n - d * 10;
            n = d;
            background.add(new Digit(k, 30, 360 - shift, 25));
            shift+=30;
        }
    }

}
