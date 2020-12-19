package p4_group_8_repo.Controllers;

import p4_group_8_repo.Main;

import java.io.IOException;

public class InstructionsController {

    /**
     * If button pressed set scene to Main Menu.
     * @throws IOException -
     */
    public void goToMainMenu() throws IOException {
        Main.setRoot("MainMenuView");
    }

}
