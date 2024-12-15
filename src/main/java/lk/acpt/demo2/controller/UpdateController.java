package lk.acpt.demo2.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import lk.acpt.demo2.db.DBConnection;
import lk.acpt.demo2.dto.VehicleDto;
import lk.acpt.demo2.model.VehicleModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateController {
    @FXML
    private TextField txtupdatebrand;

    @FXML
    private TextField txtupdateid;

    @FXML
    private TextField txtupdatemodel;

    @FXML
    private TextField txtupdateprice;

    @FXML
    private TextField txtupdateqty;

    @FXML
    void cancel(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void update(ActionEvent event) {
        int id = Integer.parseInt(txtupdateid.getText());
        String brand = txtupdatebrand.getText();
        int qty = Integer.parseInt(txtupdateqty.getText());
        String model = txtupdatemodel.getText();
        double price = Double.parseDouble(txtupdateprice.getText());

        VehicleModel.vehicleUpdate(new VehicleDto(id, brand, model, qty, price));


//
//        try {
//            Connection connection = DBConnection.getDbConnection().getConnection();
//
//
//            PreparedStatement preparedStatement=connection.prepareStatement("insert into vehicle values(?,?,?,?,?)");
//
//            preparedStatement.setObject(1,id);
//            preparedStatement.setObject(2,brand);
//            preparedStatement.setObject(3,model);
//            preparedStatement.setObject(4,qty);
//            preparedStatement.setObject(5,price);
//
//            int i = preparedStatement.executeUpdate();
//
//            if (i>0){
//                System.out.println("Data Added Successfully..!!");
//            }else {
//                System.out.println("Data Not Added Successfully..!!");
//            }
//
//        } catch (ClassNotFoundException | SQLException e) {
//
//            throw new RuntimeException(e);
//        }
    }

    @FXML
    void search(ActionEvent event) {
        int id = Integer.parseInt(txtupdateid.getText());

    }
}
