package dao;

import controller.Connector;
import model.Customer;

import java.sql.*;

public class Dao_Customer {
    public boolean addCustomer(String name, Date birthDay, int identify,String address,String job,int phoneNumber) throws SQLException, ClassNotFoundException {

        Connection conn = Connector.getConnection();
        Statement statement = conn.createStatement();
        String sql = "INSERT INTO CUSTOMER VALUE (?,?,?,?,?,?,?)";

        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1,0);
        preparedStatement.setString(2,name);
        preparedStatement.setDate(3,birthDay);
        preparedStatement.setInt(4,identify);
        preparedStatement.setString(5,address);
        preparedStatement.setString(6,job);
        preparedStatement.setInt(7,phoneNumber);

        int rowCount = preparedStatement.executeUpdate();
        conn.close();
        return rowCount==1;

    }

    public Customer getLastCustomer() throws SQLException, ClassNotFoundException {
        Connection coon = Connector.getConnection();
        Statement statement = coon.createStatement();
        String query = "Select * from CUSTOMER";
        ResultSet resultSet = statement.executeQuery(query);
        Customer customer = new Customer();
        while (resultSet.next()){
            if(resultSet.isLast()) {
                customer.setId(resultSet.getInt(1));
                customer.setName(resultSet.getString(2));
                customer.setBirthDay(resultSet.getDate(3));
                customer.setIdentify(resultSet.getInt(4));
                customer.setAddress(resultSet.getString(5));
                customer.setJob(resultSet.getString(6));
                customer.setNumberPhone(resultSet.getInt(7));
            }
        }

        coon.close();
        return customer;
    }
}
