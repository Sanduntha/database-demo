module lk.acpt.demo2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;

    // Open packages for reflection by JavaFX
    opens lk.acpt.demo2 to javafx.fxml;
    opens lk.acpt.demo2.controller to javafx.fxml;

    // Export necessary packages for other modules
    exports lk.acpt.demo2;
    exports lk.acpt.demo2.controller;
    exports lk.acpt.demo2.model;
}
