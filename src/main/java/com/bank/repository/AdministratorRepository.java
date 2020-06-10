package com.bank.repository;

import com.bank.model.User;

import java.util.List;

public interface AdministratorRepository {

    boolean addEmployee(User user);

    boolean deleteEmployee(int id);

    boolean updateEmployee(User user);

    User getEmployee(String name);
}
