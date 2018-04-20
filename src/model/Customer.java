package model;

import java.util.Date;

public class Customer {
    private int id;
    private String name;
    private Date birthDay;
    private int identify;
    private String address;
    private String job;
    private int numberPhone;

    public Customer() {
    }

    public Customer(int id, String name, Date birthDay, int identify, String address, String job, int numberPhone) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
        this.identify = identify;
        this.address = address;
        this.job = job;
        this.numberPhone = numberPhone;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public int getIdentify() {
        return identify;
    }

    public String getAddress() {
        return address;
    }

    public String getJob() {
        return job;
    }

    public int getNumberPhone() {
        return numberPhone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public void setIdentify(int identify) {
        this.identify = identify;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setNumberPhone(int numberPhone) {
        this.numberPhone = numberPhone;
    }
}
