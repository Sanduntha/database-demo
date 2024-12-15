package lk.acpt.demo2.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.acpt.demo2.HelloApplication;

import java.io.IOException;

public class ListController {
    @FXML
    private AnchorPane pane;

    @FXML
    void cancel(ActionEvent event) throws IOException {
        Stage stage = (Stage) pane.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/lk/acpt/demo2/main-view.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void delete(ActionEvent event) throws IOException {
        Stage stage = (Stage) pane.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/lk/acpt/demo2/delete-view.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void save(ActionEvent event) throws IOException {
        Stage stage = (Stage) pane.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/lk/acpt/demo2/save-view.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void update(ActionEvent event) throws IOException {
        Stage stage = (Stage) pane.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/lk/acpt/demo2/update-view.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void viewAll(ActionEvent event) throws IOException {
        Stage stage = (Stage) pane.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/lk/acpt/demo2/view-view.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void order(ActionEvent event) throws IOException {
        Stage stage = (Stage) pane.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/lk/acpt/demo2/order-view.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.show();
    }

}
