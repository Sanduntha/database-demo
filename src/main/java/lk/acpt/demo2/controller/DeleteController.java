package lk.acpt.demo2.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lk.acpt.demo2.dto.VehicleDto;
import lk.acpt.demo2.model.VehicleModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteController {

    @FXML
    private TextField txtdeleteid;

    @FXML
    void cancel(ActionEvent event) {

        System.exit(0);
    }

    @FXML
    public void delete() {
        int id = Integer.parseInt(txtdeleteid.getText());
        boolean delete = VehicleModel.delete(id);

        if(delete){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.show();
        }


    }
}