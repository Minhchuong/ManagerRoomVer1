package controller;

import com.mysql.jdbc.MySQLConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {

    public static Connection getConnection() throws SQLException, ClassCastException, ClassNotFoundException {

        String hostName = "localhost";
        String dbName = "QLPhongTro";
        String userName = "root";
        String password = "minhchuong";

        return getMySQLConnection(hostName, dbName, userName, password);
    }

    public static Connection getMySQLConnection(String hostName, String dbName, String userName, String password) throws SQLException, ClassCastException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;

        Connection conn = DriverManager.getConnection(connectionURL, userName,
                password);
        return conn;
    }

    public static void main(String[] str) throws SQLException, ClassNotFoundException {
        System.out.println(Integer.parseInt("012"));
        System.out.println(Controller.md5("1"));
    }
}
