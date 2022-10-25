package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection conectar(){
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mjv_school", "root", "admin123");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        ConnectionFactory.conectar();
    }
}
