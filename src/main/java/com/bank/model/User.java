package com.bank.model;

public class User {
    private int id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String profession;
    private String username;
    private String password;
    private String role;

    public User(int id, String name, String address, String phone, String email, String profession, String username, String password, String role) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.profession = profession;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User(String name, String address, String phone, String email, String profession, String username, String password, String role) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.profession = profession;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User(int id, String name, String address, String phone, String email, String profession) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.profession = profession;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
