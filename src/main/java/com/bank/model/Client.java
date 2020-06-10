package com.bank.model;

public class Client {

    private int id;
    private String firstName;
    private String lastName;
    private int idCard;
    private String pnc;
    private String address;
    private String email;
    private String phone;

    public Client(String firstName, String lastName, int idCard, String pnc, String address, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idCard = idCard;
        this.pnc = pnc;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    public Client(int id, String firstName, String lastName, int idCard, String pnc, String address, String email, String phone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.idCard = idCard;
        this.pnc = pnc;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    public Client() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getIdCard() {
        return idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }

    public String getPnc() {
        return pnc;
    }

    public void setPnc(String pnc) {
        this.pnc = pnc;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", idCard=" + idCard +
                ", pnc='" + pnc + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
