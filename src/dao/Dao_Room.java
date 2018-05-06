package dao;

import controller.Connector;
import controller.Controller;
import model.Customer;
import model.Room;

import java.sql.*;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Dao_Room {

    public ArrayList<Room> getListRoom() throws SQLException, ClassNotFoundException {
        ArrayList<Room> listOfRoom = new ArrayList <Room>();

        Connection coon = Connector.getConnection();
        Statement statement = coon.createStatement();
        String query = "Select * from Room";
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()){

            int id = resultSet.getInt(1);
            boolean status = resultSet.getBoolean(2);
            int price = resultSet.getInt(3);
            listOfRoom.add(new Room(id,status,price));
        }

        coon.close();
        return listOfRoom;

    }

    public boolean addRoom(boolean status, int price) throws SQLException, ClassNotFoundException {
        if(price<=0)return false;
        Connection conn = Connector.getConnection();
        Statement statement = conn.createStatement();
        String sql = "INSERT INTO Room VALUE (?,?,?)";

        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1,0);
        preparedStatement.setBoolean(2,status);
        preparedStatement.setInt(3,price);

        int rowCount = preparedStatement.executeUpdate();
        conn.close();
        return rowCount==1;
    }

    public boolean updateRoom(int id, boolean status, int price) throws SQLException, ClassNotFoundException{
        if(price<=0)return false;
        Connection conn = Connector.getConnection();
        Statement statement = conn.createStatement();
        String sql = "UPDATE Room SET STATUS = ?, PRICE = ? WHERE ID = ?";

        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setBoolean(1,status);
        preparedStatement.setInt(2,price);
        preparedStatement.setInt(3,id);

        int rowCount = preparedStatement.executeUpdate();
        conn.close();

        return (rowCount==1);
    }

    public Room getRoom(int id) throws SQLException, ClassNotFoundException {
        Connection conn = Connector.getConnection();
        Statement statement = conn.createStatement();
        String query = "Select * from Room Where ID = ?";

        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setInt(1,id);

        ResultSet rs = preparedStatement.executeQuery();
        rs.next();
        id = rs.getInt(1);
        boolean status = rs.getBoolean(2);
        int price = rs.getInt(3);

        return new Room(id,status,price);
    }

    public boolean deleteRoom(int id) throws SQLException, ClassNotFoundException {
        Connection conn = Connector.getConnection();
        Statement statement = conn.createStatement();
        String query = "DELETE from Room Where ID = ?";

        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setInt(1,id);
        int rowCount = preparedStatement.executeUpdate();
        return rowCount==1;
    }



    public static void main(String[] str) throws SQLException, ClassNotFoundException {
//        Customer customer = new Customer();
//        customer.setId(2);
    //    Dao_Contract dao_contract = new Dao_Contract();
    //    dao_contract.addContrac(new java.sql.Date(2017,12,1),new java.sql.Date(2017,12,3),new Room(1,true,10000),150000,200000,"not description",customer);

        Dao_Contract dao_contract = new Dao_Contract();
        System.out.println(dao_contract.getListConstract());
//        Dao_Account daoAccount = new Dao_Account();
//        System.out.println(daoAccount.checkPassWordByNameAccount("minhchuong", Controller.md5("1")));
    }
}
