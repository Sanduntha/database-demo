package lk.acpt.demo2.model;

import lk.acpt.demo2.controller.OrderController;
import lk.acpt.demo2.db.DBConnection;
import lk.acpt.demo2.dto.OrderDetailDto;
import lk.acpt.demo2.dto.OrderDto;

import java.sql.*;

public class OrderModel {

    public  static boolean placeOrder(OrderDto order) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();

        //disable automatic commit

        PreparedStatement stm1 = connection.prepareStatement("insert into order (orderdate,amount) values(?,?)", Statement.RETURN_GENERATED_KEYS);
        stm1.setObject(1,order.getOrderDate());
        stm1.setObject(2,order.getSubTotal());
        int orderSave = stm1.executeUpdate();

        if (orderSave > 0) {
            //get oder id from genarated keys
            ResultSet generatedKeys = stm1.getGeneratedKeys();

            if (generatedKeys.next()) {
                int id = generatedKeys.getInt(1);

                //save order details

                for (OrderDetailDto dto : order.getOrderDetailsDtos()){

                    PreparedStatement stm2 = connection.prepareStatement("insert into order_detail (orderId,vehicleID,qty,price) values(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
                    stm2.setObject(1,id);
                    stm2.setObject(2,dto.getVehicleId());
                    stm2.setObject(3,dto.getQty());
                    stm2.setObject(4,dto.getPrice());

                    int orderDatailSave = stm2.executeUpdate();

                    if (orderDatailSave > 0) {
                        PreparedStatement stm3 = connection.prepareStatement("update order_detail set qty=?,vehicleId=? where id=?",Statement.RETURN_GENERATED_KEYS);
                        stm3.setObject(1,dto.getQty());
                        stm3.setObject(2,dto.getVehicleId());

                        int vehicleQtyUpdate = stm3.executeUpdate();

                        if (vehicleQtyUpdate > 0) {
                            connection.rollback();
                            connection.setAutoCommit(true);
                            return false;
                        }
                    }else {
                        connection.rollback();
                        connection.setAutoCommit(true);
                        return false;
                    }
                }
            }
            connection.commit();
            connection.setAutoCommit(true);
            return true;
        }else {
            //cashe remove
            connection.rollback();
            connection.setAutoCommit(true);
            return false;

        }

    }
}
