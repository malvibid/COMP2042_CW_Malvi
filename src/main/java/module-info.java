/**
 * This file specifies the path to open my fxml files. It establishes the connection between the controller files and fxml files.
 */

module com.malvi {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    opens p4_group_8_repo.Controllers to javafx.fxml;
    exports p4_group_8_repo;

}