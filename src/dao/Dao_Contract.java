package dao;

import controller.Connector;
import model.Contract;
import model.Customer;
import model.Room;

import java.sql.*;
import java.util.ArrayList;

public class Dao_Contract {
    public Contract getContractByRoomID(){
        return null;
    }

    public boolean addContrac(Date dateRent, Date dateOff, Room room, int prepay, int portpaid, String description, Customer customer) throws SQLException, ClassNotFoundException {

        Connection conn = Connector.getConnection();
        Statement statement = conn.createStatement();
        String sql = "INSERT INTO CONTRACT VALUE (?,?,?,?,?,?,?,?)";

        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1,0);
        preparedStatement.setDate(2,dateRent);
        preparedStatement.setDate(3,dateOff);
        preparedStatement.setInt(4,room.getId());
        preparedStatement.setInt(5,customer.getId());
        preparedStatement.setInt(6,prepay);
        preparedStatement.setInt(7,portpaid);
        preparedStatement.setString(8,description);

        int rowCount = preparedStatement.executeUpdate();
        conn.close();
        return rowCount==1;
    }

    public Contract getContractByIDRoom(int id_room) throws SQLException, ClassNotFoundException {
        Connection conn = Connector.getConnection();
        String sql = "select * from CONTRACT join CUSTOMER on CONTRACT.ID_CUSTOMER = CUSTOMER.ID join ROOM on CONTRACT.ID_ROOM = ROOM.ID WHERE ID_ROOM = ?";

        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1,id_room);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        Room room = new Room();
        room.setId(resultSet.getInt("ID_ROOM"));
        room.setStatus(resultSet.getBoolean("STATUS"));
        room.setPrice(resultSet.getInt("PRICE"));

        Customer customer = new Customer();
        customer.setId(resultSet.getInt("ID_CUSTOMER"));
        customer.setName(resultSet.getString("NAME"));
        customer.setBirthDay(resultSet.getDate("BIRTHDAY"));
        customer.setIdentify(resultSet.getInt("IDENTIFY"));
        customer.setAddress(resultSet.getString("ADRESS"));
        customer.setJob(resultSet.getString("JOB"));
        customer.setNumberPhone(resultSet.getInt("PHONE"));

        Contract contract = new Contract();
        contract.setRoom(room);
        contract.setCustomer(customer);
        contract.setDate_rent(resultSet.getDate("DATE_RENT"));
        contract.setDate_off(resultSet.getDate("DATE_OFF"));
        contract.setPrepay(resultSet.getInt("PREPAY"));
        contract.setPortpaid(resultSet.getInt("PORTPAID"));
        contract.setDescription(resultSet.getString("DESCRIPTION"));
        conn.close();
        return contract;
    }

    public ArrayList<Contract> getListConstract() throws SQLException, ClassNotFoundException {
        ArrayList<Contract> contracts = new ArrayList <>();
        Connection conn = Connector.getConnection();
        String sql = "select * from CONTRACT join CUSTOMER on CONTRACT.ID_CUSTOMER = CUSTOMER.ID join ROOM on CONTRACT.ID_ROOM = ROOM.ID";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){

            Room room = new Room();
            room.setId(resultSet.getInt("ID_ROOM"));
            room.setStatus(resultSet.getBoolean("STATUS"));
            room.setPrice(resultSet.getInt("PRICE"));

            Customer customer = new Customer();
            customer.setId(resultSet.getInt("ID_CUSTOMER"));
            customer.setName(resultSet.getString("NAME"));
            customer.setBirthDay(resultSet.getDate("BIRTHDAY"));
            customer.setIdentify(resultSet.getInt("IDENTIFY"));
            customer.setAddress(resultSet.getString("ADRESS"));
            customer.setJob(resultSet.getString("JOB"));
            customer.setNumberPhone(resultSet.getInt("PHONE"));

            Contract contract = new Contract();
            contract.setRoom(room);
            contract.setCustomer(customer);
            contract.setId(resultSet.getInt("ID"));
            contract.setDate_rent(resultSet.getDate("DATE_RENT"));
            contract.setDate_off(resultSet.getDate("DATE_OFF"));
            contract.setPrepay(resultSet.getInt("PREPAY"));
            contract.setPortpaid(resultSet.getInt("PORTPAID"));
            contract.setDescription(resultSet.getString("DESCRIPTION"));

            contracts.add(contract);
        }

        return contracts;
    }

    public boolean deleteContractByID(String id) throws SQLException, ClassNotFoundException {
        int index = Integer.parseInt(id);
        Contract contract = getContractByID(index);
        Connection conn = Connector.getConnection();
        Statement statement = conn.createStatement();
        String query = "DELETE from CONTRACT Where ID = ?";

        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setInt(1,index);
        int rowCount = preparedStatement.executeUpdate();
        if(rowCount==1){
            Dao_Room dao_room = new Dao_Room();
            dao_room.updateRoom(contract.getRoom().getId(),false,contract.getRoom().getPrice());
        }
        return rowCount==1;
    }

    private Contract getContractByID(int id) throws SQLException, ClassNotFoundException {
        Connection conn = Connector.getConnection();
        String sql = "select * from CONTRACT join CUSTOMER on CONTRACT.ID_CUSTOMER = CUSTOMER.ID join ROOM on CONTRACT.ID_ROOM = ROOM.ID WHERE CONTRACT.ID = ?";

        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        Room room = new Room();
        room.setId(resultSet.getInt("ID_ROOM"));
        room.setStatus(resultSet.getBoolean("STATUS"));
        room.setPrice(resultSet.getInt("PRICE"));

        Customer customer = new Customer();
        customer.setId(resultSet.getInt("ID_CUSTOMER"));
        customer.setName(resultSet.getString("NAME"));
        customer.setBirthDay(resultSet.getDate("BIRTHDAY"));
        customer.setIdentify(resultSet.getInt("IDENTIFY"));
        customer.setAddress(resultSet.getString("ADRESS"));
        customer.setJob(resultSet.getString("JOB"));
        customer.setNumberPhone(resultSet.getInt("PHONE"));

        Contract contract = new Contract();
        contract.setRoom(room);
        contract.setCustomer(customer);
        contract.setDate_rent(resultSet.getDate("DATE_RENT"));
        contract.setDate_off(resultSet.getDate("DATE_OFF"));
        contract.setPrepay(resultSet.getInt("PREPAY"));
        contract.setPortpaid(resultSet.getInt("PORTPAID"));
        contract.setDescription(resultSet.getString("DESCRIPTION"));
        conn.close();
        return contract;
    }


}
