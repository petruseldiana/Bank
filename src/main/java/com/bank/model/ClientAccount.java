package com.bank.model;


import java.sql.Date;

public class ClientAccount {
    private int id;
    private String type;
    private double amountOfMoney;
    private String creationDate;
    private int idClient;

    public ClientAccount(String type, double amountOfMoney, String creationDate) {
        this.type = type;
        this.amountOfMoney = amountOfMoney;
        this.creationDate = creationDate;
    }

    public ClientAccount() {
    }

    public ClientAccount(String type, double amountOfMoney, int idClient) {
        this.type = type;
        this.amountOfMoney = amountOfMoney;
        this.idClient = idClient;
    }

    public ClientAccount(String type, double amountOfMoney, String creationDate, int idClient) {
        this.type = type;
        this.amountOfMoney = amountOfMoney;
        this.creationDate = creationDate;
        this.idClient = idClient;
    }

    public ClientAccount(int id, String type, double amountOfMoney, String creationDate, int idClient) {
        this.id = id;
        this.type = type;
        this.amountOfMoney = amountOfMoney;
        this.creationDate = creationDate;
        this.idClient = idClient;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(double amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    @Override
    public String toString() {
        return "ClientAccount{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", amountOfMoney=" + amountOfMoney +
                ", creationDate=" + creationDate +
                ", idClient=" + idClient +
                '}';
    }

}
