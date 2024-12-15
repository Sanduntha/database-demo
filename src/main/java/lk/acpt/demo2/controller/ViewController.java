package lk.acpt.demo2.controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import lk.acpt.demo2.model.VehicleModel;
import lk.acpt.demo2.tm.VehicleTM;

import java.util.ArrayList;

public class ViewController {

    @FXML
    private AnchorPane pane;

    @FXML
    private Pane root;

    public class View{

    public TableView<VehicleTM> tblView;

    public void initialize() {
        ArrayList<VehicleTM> VehicleTM = VehicleModel.loadAll();
        tblView.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblView.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("brand"));
        tblView.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("model"));
        tblView.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("qty"));
        tblView.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("price"));

        tblView.setItems(FXCollections.observableList(VehicleTM));



    }

    }
}
