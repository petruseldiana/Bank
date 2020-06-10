package com.bank.service.impl;

import com.bank.model.User;
import com.bank.repository.AdministratorRepository;
import com.bank.service.AdministratorService;

import java.util.List;

public class AdministratorServiceImpl implements AdministratorService {

    private final AdministratorRepository administratorRepository;

    public AdministratorServiceImpl(AdministratorRepository administratorRepository) {
        this.administratorRepository = administratorRepository;
    }

    @Override
    public boolean addEmployee(User user) {

        if( administratorRepository.addEmployee(user) == true){

            System.out.println("Employee added with success!");


            return true;
        }

        return false;
    }

    @Override
    public boolean deleteEmployee(int id) {

        if(administratorRepository.deleteEmployee(id) == true){
            System.out.println("Employee deleted with success!");
            return true;
        }

        return false;
    }

    @Override
    public boolean updateEmployee(User user) {

        if(administratorRepository.updateEmployee(user) == true){

            System.out.println("User update has been completed!");
            return true;
        }

        System.out.println("Something went wrong");
        return false;
    }

    @Override
    public User getEmployee(String name) {

        return administratorRepository.getEmployee(name);
    }
}
