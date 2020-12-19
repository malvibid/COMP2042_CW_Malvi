package p4_group_8_repo.Controllers;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.loadui.testfx.GuiTest;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;

import java.io.IOException;

import static p4_group_8_repo.MainTest.loadFXML;

class MainMenuControllerTest {

    Button mainMenu;
    private Scene scene;

    @Before
    public void setUp(){
        mainMenu = (Button) GuiTest.find("mainMenu");
    }

    @Test
    void instructions(FxRobot robot) throws IOException {
        robot.clickOn( mainMenu);
        scene = new Scene(loadFXML("MainMenuView"),600,800);
//        verifyThat(scene, equals(MainTest.setRoot("MainMenuView")));
    }

    @Test
    void exitGame() {
    }

    @After
    public void tearDown () throws Exception{
        FxToolkit.hideStage();
    }
}