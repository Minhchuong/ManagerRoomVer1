package dao;

import controller.Connector;
import model.Account;
import model.Room;

import java.sql.*;
import java.util.ArrayList;

public class Dao_Account {
    public Account checkPassWordByNameAccount(String name, String password) throws SQLException, ClassNotFoundException {

        Connection coon = Connector.getConnection();
        Statement statement = coon.createStatement();
        String query = "Select * from ACCOUNT WHERE accounts = ?";
        PreparedStatement preparedStatement = coon.prepareStatement(query);
        preparedStatement.setString(1,name);

        ResultSet resultSet = preparedStatement.executeQuery();
        if(!resultSet.next())return null;
        int id = resultSet.getInt("id");
        String accountName = resultSet.getString("accounts");
        String pass = resultSet.getString("password");
        String nameAdmin = resultSet.getString("name");
        String address = resultSet.getString("address" );
        Date date = resultSet.getDate("birthday");
        int identify = resultSet.getInt("identify");
        if(password.equals(pass)){
            return new Account(id,accountName,pass,nameAdmin,address,date,identify);
        }
        return null;
    }


}
