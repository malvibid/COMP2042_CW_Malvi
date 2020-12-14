module com.malvi {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    opens p4_group_8_repo.Controllers to javafx.fxml;
    exports p4_group_8_repo;

    opens sample to javafx.fxml;
    exports sample;
}