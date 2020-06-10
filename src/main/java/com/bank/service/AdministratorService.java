package com.bank.service;

import com.bank.model.User;

import java.util.List;

public interface AdministratorService {

    boolean addEmployee(User user);

    boolean deleteEmployee(int id);

    boolean updateEmployee(User user);

    User getEmployee(String name);
}
