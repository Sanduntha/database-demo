package lk.acpt.demo2.model;

import javafx.event.ActionEvent;
import lk.acpt.demo2.controller.DeleteController;
import lk.acpt.demo2.db.DBConnection;
import lk.acpt.demo2.dto.VehicleDto;
import lk.acpt.demo2.tm.VehicleTM;

import java.sql.*;
import java.util.ArrayList;
import java.awt.*;
import java.sql.*;

public class VehicleModel {
    public static ArrayList<VehicleTM> loadAll() {
        ArrayList<VehicleTM> vehicleTMS = new ArrayList<>();
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");


            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/acpt", "root", "1234");

            PreparedStatement preparedStatement = connection.prepareStatement("select * from vehicle");

            ResultSet i = preparedStatement.executeQuery();


            while (i.next()) {
                vehicleTMS.add(
                        new VehicleTM(i.getInt(1),
                                i.getString(2),
                                i.getString(3),
                                i.getInt(4),
                                i.getDouble(5))
                );
            }

            return vehicleTMS;

        } catch (ClassNotFoundException | SQLException e) {

            throw new RuntimeException(e);
        }
    }


    public static boolean delete(int id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/acpt", "root", "1234");

            PreparedStatement preparedStatement = connection.prepareStatement("delete from vehicle where id=?");

            preparedStatement.setObject(1, id);

            int i = preparedStatement.executeUpdate();

            return i > 0;
        } catch (ClassNotFoundException | SQLException e) {

            throw new RuntimeException(e);
        }
    }


    public static void vehicleSave(VehicleDto vehicleDto) {
        try {
            Connection connection = DBConnection.getDbConnection().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into vehicle values(?,?,?,?,?)");

            preparedStatement.setObject(1, vehicleDto.getId());
            preparedStatement.setObject(2, vehicleDto.getBrand());
            preparedStatement.setObject(3, vehicleDto.getModel());
            preparedStatement.setObject(4, vehicleDto.getQty());
            preparedStatement.setObject(5, vehicleDto.getPrice());

            int i = preparedStatement.executeUpdate();

            if (i > 0) {
                System.out.println("Data Added Successfully..!!");
            } else {
                System.out.println("Data Not Added Successfully..!!");
            }

        } catch (ClassNotFoundException | SQLException e) {

            throw new RuntimeException(e);
        }

    }
    public static VehicleDto searchId (int id) throws SQLException, ClassNotFoundException {

        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from vehicle where id = ?");
        preparedStatement.setInt(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
          return new VehicleDto(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4),resultSet.getDouble(5));
        }else {
            return null;
        }
    }

    public static void vehicleUpdate (VehicleDto vehicleDto)  {

        try {
            Connection connection = DBConnection.getDbConnection().getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("update vehicle set brand=?, model=?, qty=?, price=? where id = ?");

            preparedStatement.setObject(1, vehicleDto.getBrand());
            preparedStatement.setObject(2, vehicleDto.getModel());
            preparedStatement.setObject(3, vehicleDto.getQty());
            preparedStatement.setObject(4, vehicleDto.getPrice());
            preparedStatement.setObject(5, vehicleDto.getId());

            int i = preparedStatement.executeUpdate();

            if (i > 0) {
                System.out.println("Data Updated Successfully..!!");
            }else{
                System.out.println("Data Not Updated Successfully..!!");
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);

        }
    }

}



