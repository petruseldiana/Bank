package com.bank.repository;

import com.bank.model.User;

public interface UserRepository {


    int giveMeID(String name);

    String findRoleByID(int id);

    int findIdByName(String name);

    User loadByUserName(String username);
}
