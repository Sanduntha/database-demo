package lk.acpt.demo2.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.acpt.demo2.dto.OrderDetailDto;
import lk.acpt.demo2.dto.OrderDto;
import lk.acpt.demo2.model.OrderModel;
import lk.acpt.demo2.tm.ItemTM;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderController {

//@FXML
//    public TextField txtid;
//    public TextField txtrand;
//    public TextField txtmodel;
//    public TextField txtqty;
//    public TextField txtprice;
//    public Label lblSub;
//    public TableView tblTable;
//    public TextField txtorder;
//    public Label lblTotal;
//
//    public void btnAdd(ActionEvent actionEvent) {
//    }
//
//    public void btnPlace(ActionEvent actionEvent) {
//    }

    @FXML
    private Label lblSub;

    @FXML
    private Label lblTotal;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<?> tblTable;

    @FXML
    private TextField txtid;

    @FXML
    private TextField txtmodel;

    @FXML
    private TextField txtorder;

    @FXML
    private TextField txtprice;

    @FXML
    private TextField txtqty;

    @FXML
    private TextField txtrand;
    private List<ItemTM> itemTM;
    ArrayList<OrderDetailDto> OrderDetailDto;

    private double subtotal= 0.0;


    @FXML
    void btnAdd(ActionEvent event) {
        int qty = Integer.parseInt(txtid.getText());
        String brand = txtrand.getText();
        String model = txtmodel.getText();
        double price = Double.parseDouble(txtprice.getText());
        double subtotal = qty * price;


        lblTotal.setText(String.valueOf(subtotal));

        itemTM.add(new ItemTM(brand,model,qty,price,subtotal));

        int id = Integer.parseInt(txtid.getText());
        OrderDetailDto.add(new OrderDetailDto(id,qty,price));

//        tblTable.setItems(FXCollections.observableArrayList(itemTM));


    }

    @FXML
    void btnPlace(ActionEvent event) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String format = dateFormat.format(date);

        boolean status = false;
        try {
            status = OrderModel.placeOrder(new OrderDto(format,subtotal,OrderDetailDto));

            if (status) {
                System.out.println("Order Placed Successfully..!!");
            }else {
                System.out.println("Order Placed Failed..!!");
            }

        } catch (SQLException | ClassNotFoundException e ) {
            throw new RuntimeException(e);
        }



    }

    @FXML
    public void initialize() {
        tblTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Id"));
        tblTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Brand"));
        tblTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("Model"));
        tblTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("Qty"));
        tblTable.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("Price"));

        itemTM = new ArrayList();


    }


    @FXML
    void search(ActionEvent event) {
//        Integer id = Integer.valueOf(txtid.getText());
//        OrderModel.search(id);



    }
}
