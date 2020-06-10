package com.bank.service;

import com.bank.model.User;

public interface UserService {

    int getID(String name);

    boolean checkRole(String role);

    String findRoleByID(int id);

    int getIDByName(String name);

    User login(String userName, String password);
}
