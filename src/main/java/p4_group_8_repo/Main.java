package p4_group_8_repo;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Main extends Application {
	AnimationTimer timer;
	MyStage background;
	Player frog;
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
	    background = new MyStage();
	    Scene scene  = new Scene(background,600,800);
	    
		//Vehicle obstacle = new Vehicle("file:src/p4_group_8_repo/truck1Right.png", 25, 25, 3);
		//Vehicle obstacle1 = new Vehicle("file:src/p4_group_8_repo/truck2Right.png", 100, 100,2 );
		//Vehicle obstacle2 = new Vehicle("file:src/p4_group_8_repo/truck1Right.png",0,  150, 1);

		BackgroundImage froggerback = new BackgroundImage(getLink("Background.png"));
	    
		background.add(froggerback);
		
		background.add(new Log(getLink("log3.png"), 150, 0, 166, 0.75));
		background.add(new Log(getLink("log3.png"), 150, 220, 166, 0.75));
		background.add(new Log(getLink("log3.png"), 150, 440, 166, 0.75));
		//background.add(new Log("file:src/p4_group_8_repo/log3.png", 150, 0, 166, 0.75));
		background.add(new Log(getLink("logs.png"), 300, 0, 276, -2));
		background.add(new Log(getLink("logs.png"), 300, 400, 276, -2));
		//background.add(new Log("file:src/p4_group_8_repo/logs.png", 300, 800, 276, -2));
		background.add(new Log(getLink("log3.png"), 150, 50, 329, 0.75));
		background.add(new Log(getLink("log3.png"), 150, 270, 329, 0.75));
		background.add(new Log(getLink("log3.png"), 150, 490, 329, 0.75));
		//background.add(new Log("file:src/p4_group_8_repo/log3.png", 150, 570, 329, 0.75));
		
		background.add(new Turtle(500, 376, -1, 130, 130));
		background.add(new Turtle(300, 376, -1, 130, 130));
		background.add(new WetTurtle(700, 376, -1, 130, 130));
		background.add(new WetTurtle(600, 217, -1, 130, 130));
		background.add(new WetTurtle(400, 217, -1, 130, 130));
		background.add(new WetTurtle(200, 217, -1, 130, 130));
		//background.add(new Log(getLink("log2.png"), 200, 100, 1));
		//background.add(new Log(getLink("log2.png"), 0, 100, 1));
		//background.add(new Log(getLink("log2.png"), 100, 120, -1));
		//background.add(new Log(getLink("log2.png"), 200, 120, -1));
		//background.add(new Log(getLink("log2.png"), 100, 140, 1));
		//background.add(new Log(getLink("log2.png"), 200, 140, 1));
		//background.add(new Log(getLink("log2.png"), 100, 160, -1));
		//background.add(new Log(getLink("log2.png"), 300, 160, -1));
		//background.add(new Log(getLink("log2.png"), 100, 180, 1));
		//background.add(new Log(getLink("log2.png"), 200, 180, 1));
		//background.add(new Log(getLink("log2.png"), 100, 200, -1));
		//background.add(new Log(getLink("log2.png"), 200, 200, -1));
		//background.add(new Log(getLink("log2.png"), 100, 220, 1));
		//background.add(new Log(getLink("log2.png"), 200, 220, 1));
		//background.add(new Log(getLink("log2.png"), 400, 220, 1));
		//End end2 = new End();
		//End end3 = new End();
		//End end4 = new End();
		//End end5 = new End();
		background.add(new End(13,96));
		background.add(new End(141,96));
		background.add(new End(141 + 141-13,96));
		background.add(new End(141 + 141-13+141-13+1,96));
		background.add(new End(141 + 141-13+141-13+141-13+3,96));
		frog = new Player(getLink("froggerUp.png"));
		background.add(frog);
		background.add(new Vehicle(getLink("truck1Right.png"), 0, 649, 1, 120, 120));
		background.add(new Vehicle(getLink("truck1Right.png"), 300, 649, 1, 120, 120));
		background.add(new Vehicle(getLink("truck1Right.png"), 600, 649, 1, 120, 120));
		//background.add(new Vehicle(getLink("truck1Right.png"), 720, 649, 1, 120, 120));
		background.add(new Vehicle(getLink("car1Left.png"), 100, 597, -1, 50, 50));
		background.add(new Vehicle(getLink("car1Left.png"), 250, 597, -1, 50, 50));
		background.add(new Vehicle(getLink("car1Left.png"), 400, 597, -1, 50, 50));
		background.add(new Vehicle(getLink("car1Left.png"), 550, 597, -1, 50, 50));
		background.add(new Vehicle(getLink("truck2Right.png"), 0, 540, 1, 200, 200));
		background.add(new Vehicle(getLink("truck2Right.png"), 500, 540, 1, 200, 200));
		background.add(new Vehicle(getLink("car1Left.png"), 500, 490, -5, 50, 50));
		background.add(new Digit(0, 30, 360, 25));
		//background.add(obstacle);
		//background.add(obstacle1);
		//background.add(obstacle2);
		background.start();
		primaryStage.setScene(scene);
		primaryStage.show();
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
            		System.out.print("STOPP:");
            		background.stopMusic();
            		stop();
            		background.stop();
            		Alert alert = new Alert(AlertType.INFORMATION);
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
