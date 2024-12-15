package lk.acpt.demo2.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {


    @FXML
    private AnchorPane pane;

    @FXML
    void cancel(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void service(ActionEvent event) {

    }

    @FXML
    void vehicle(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/lk/acpt/demo2/list-view.fxml"));
        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) pane.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

}
