package model;

import sun.security.provider.MD5;

import java.sql.Date;

public class Account {
    private int id;
    private String account;
    private String password;
    private String name;
    private String address;
    private Date birthDay;
    private int identify;

    public Account(int id, String account, String password, String name, String address, Date birthDay, int identify) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.name = name;
        this.address = address;
        this.birthDay = birthDay;
        this.identify = identify;
    }

    public Account() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public int getIdentify() {
        return identify;
    }

    public void setIdentify(int identify) {
        this.identify = identify;
    }
}
