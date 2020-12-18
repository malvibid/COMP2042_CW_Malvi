package p4_group_8_repo.Controllers;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import p4_group_8_repo.*;

import java.net.URL;
import java.util.ResourceBundle;

import static p4_group_8_repo.Enums.CarType.*;
import static p4_group_8_repo.ImageLoader.*;

public class GamePlayController implements Initializable {

    AnimationTimer timer;
    Player frog = Player.getInstance();

    public static final int TILE_SIZE = 50;

    @FXML
    private MyStage background;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

//      BackgroundImage gamePlayBackgroundImage = new BackgroundImage(getLink("menu_background.png"));

        background.add(new BackgroundImage(GAME_BACKGROUND));

        background.add(new Log(LOG_3, 0, calculateRow(3), 0.75));
        background.add(new Log(LOG_3, (Log.LOG_3_WIDTH + 77), calculateRow(3), 0.75));
        background.add(new Log(LOG_3, (Log.LOG_3_WIDTH + 77) * 2, calculateRow(3), 0.75));
        background.add(new Log(LOG_3, (Log.LOG_3_WIDTH + 77) * 3, calculateRow(3), 0.75));

        background.add(new Log(LOG_2, 0, calculateRow(5), -2));
        background.add(new Log(LOG_2, (Log.LOG_2_WIDTH + 120), calculateRow(5), -2));

        background.add(new Log(LOG_1, 0, calculateRow(6), 0.75));
        background.add(new Log(LOG_1, (Log.LOG_1_WIDTH + 77), calculateRow(6), 0.75));
        background.add(new Log(LOG_1, (Log.LOG_1_WIDTH + 77) * 2, calculateRow(6), 0.75));
        background.add(new Log(LOG_1, (Log.LOG_1_WIDTH + 77) * 3, calculateRow(6), 0.75));

        background.add(new Turtle(TURTLE_3RED_SPRITES, 500, calculateRow(7), -1));
        background.add(new Turtle(TURTLE_3RED_SPRITES, 300, calculateRow(7), -1));
        background.add(new WetTurtle(TURTLE_3GREEN_SPRITES, 700, calculateRow(7), -1));

        background.add(new WetTurtle(TURTLE_3GREEN_SPRITES, 600, calculateRow(4), -1));
        background.add(new WetTurtle(TURTLE_3GREEN_SPRITES, 400, calculateRow(4), -1));
        background.add(new WetTurtle(TURTLE_3GREEN_SPRITES, 200, calculateRow(4), -1));

        background.add(new End(calculateColumn(0) + 25, calculateRow(2)));
        background.add(new End(calculateColumn(3) + 2, calculateRow(2)));
        background.add(new End(calculateColumn(5) + 30, calculateRow(2)));
        background.add(new End(calculateColumn(8) + 7, calculateRow(2)));
        background.add(new End(calculateColumn(11) - 15, calculateRow(2)));


//        background.add(new End(13,96));
//        background.add(new End(141,96));
//        background.add(new End(141 + 141-13,96));
//        background.add(new End(141 + 141-13+141-13+1,96));
//        background.add(new End(141 + 141-13+141-13+141-13+3,96));

        background.add(frog);
        background.add(new Vehicle(CARS_SPRITES, TYPE_A.ordinal(), 0, calculateRow(13), -1 ));
        background.add(new Vehicle(CARS_SPRITES, TYPE_A.ordinal(), (Vehicle.SPRITE_WIDTH + 138), calculateRow(13), -1 ));
        background.add(new Vehicle(CARS_SPRITES, TYPE_A.ordinal(), (Vehicle.SPRITE_WIDTH + 138) * 2, calculateRow(13), -1 ));

        background.add(new Vehicle(SINGLE_CAR, 0, calculateRow(12), 1));

//        background.add(new Vehicle(CARS_SPRITES, TYPE_B.ordinal(), 0, calculateRow(12), 1));
//        background.add(new Vehicle(CARS_SPRITES, TYPE_B.ordinal(), (Vehicle.SPRITE_WIDTH + 138), calculateRow(12), 1));
//        background.add(new Vehicle(CARS_SPRITES, TYPE_B.ordinal(), (Vehicle.SPRITE_WIDTH + 138) * 2, calculateRow(12), 1));

//        background.add(new Vehicle(CARS_SPRITES, TYPE_D.ordinal(), 100, calculateRow(11), -1));
//        background.add(new Vehicle(CARS_SPRITES, TYPE_D.ordinal(), 250, calculateRow(11), -1));
//        background.add(new Vehicle(CARS_SPRITES, TYPE_D.ordinal(), 400, calculateRow(11), -1));
//        background.add(new Vehicle(CARS_SPRITES, TYPE_D.ordinal(), 550, calculateRow(11), -1));

        background.add(new Vehicle(CARS_SPRITES, TYPE_C.ordinal(), 0, calculateRow(10), 1));
        background.add(new Vehicle(CARS_SPRITES, TYPE_C.ordinal(), 500, calculateRow(10), 1));
//      background.add(new Vehicle(TRUCK, 500, calculateRow(9), -5));

        background.add(new Digit(0, 30, 360, 25));

        background.start();
        start();
    }


    //    /**
//     * Helper function to find the X position of a column on the game's grid
//     * @param value column number
//     * @return returns number based on the value * TILE_SIZE
//     */
    public static int calculateColumn(int value)
    {
        return value * TILE_SIZE;
    }

    //    /**
//     * Helper function to find the Y position of a row on the game's grid
//     * @param value row number
//     * @return returns number based on the value * TILE_SIZE
//     */
    public static int calculateRow(int value)
    {
        return calculateColumn(value);
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
                    //background.stopMusic();
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
        //background.playMusic();
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
