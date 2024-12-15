package lk.acpt.demo2.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static DBConnection dbConnection;               // private karala haduwe wena thanaka meke constructor eka call karanna bari wenna
                                                            // static kale nonstatic thibba nam yata method eke meka call karanna bari wenawa
    private final Connection connection;

    private DBConnection() throws SQLException, ClassNotFoundException {


        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/acpt", "root", "1234");

                                                                // db connection kiyala null variable ekak assign kala mulinma
    }
    public static DBConnection getDbConnection() throws SQLException, ClassNotFoundException {               // get dbconnection kiyala connection ekak haduwa call karaganna
        if(dbConnection == null){
            dbConnection = new DBConnection();
                                                                    // if condition ekak athule dala dbcon eka null nam ekata assgin karanna kiuwa new value ekak (default enne nll)
        }
        return dbConnection;                                    // null nam dbcon eka return karanna kiyanwa aea asgin una value eka
    }
    public  Connection getConnection(){
        return connection;
    }
}

//singltin design pattern