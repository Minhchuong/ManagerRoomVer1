package model;

import dao.Dao_Room;

import java.util.Date;

public class Contract {
    private int id;
    private Date date_rent;
    private Date date_off;
    private Room room;
    private int prepay;
    private int portpaid;
    private String description;
    private Customer customer;

    public Contract(int id, Date date_rent, Date date_off, Room room, int prepay, int portpaid, String description, Customer customer) {
        this.id = id;
        this.date_rent = date_rent;
        this.date_off = date_off;
        this.room = room;
        this.prepay = prepay;
        this.portpaid = portpaid;
        this.description = description;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate_rent() {
        return date_rent;
    }

    public void setDate_rent(Date date_rent) {
        this.date_rent = date_rent;
    }

    public Date getDate_off() {
        return date_off;
    }

    public void setDate_off(Date date_off) {
        this.date_off = date_off;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getPrepay() {
        return prepay;
    }

    public void setPrepay(int prepay) {
        this.prepay = prepay;
    }

    public int getPortpaid() {
        return portpaid;
    }

    public void setPortpaid(int portpaid) {
        this.portpaid = portpaid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
