package lk.acpt.demo2.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private AnchorPane pane;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUsername;

    @FXML
    void login(ActionEvent event) throws IOException {
        String username = txtUsername.getText();
        String password = txtPassword.getText();

        if (username.equals("admin") && password.equals("1234")) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/lk/acpt/demo2/main-view.fxml"));
            Scene scene = new Scene(loader.load());


            Stage stage = (Stage) pane.getScene().getWindow();
            stage.setScene(scene);
            stage.show();

        } else {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Username or Password is incorrect");
        }

    }
}
