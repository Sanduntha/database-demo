package lk.acpt.demo2.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import lk.acpt.demo2.dto.VehicleDto;
import lk.acpt.demo2.model.VehicleModel;

public class SaveController {
    @FXML
    private TextField txtbrand;

    @FXML
    private TextField txtid;

    @FXML
    private TextField txtmodel;

    @FXML
    private TextField txtprice;

    @FXML
    private TextField txtqty;

    @FXML
    void cancel(ActionEvent event) {

        System.exit(0);
    }

    @FXML
    void save(ActionEvent event) {

        int id = Integer.parseInt(txtid.getText());
        String brand = txtbrand.getText();
        int qty = Integer.parseInt(txtqty.getText());
        String model = txtmodel.getText();
        double price = Double.parseDouble(txtprice.getText());

     VehicleModel.vehicleSave(new VehicleDto(id,brand,model,qty,price));

    }

}
