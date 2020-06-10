package com.bank.service.impl;

import com.bank.model.Client;
import com.bank.model.ClientAccount;
import com.bank.repository.EmployeeRepository;
import com.bank.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public boolean addClient(Client client) {
        System.out.println("Client added with success!");
        return employeeRepository.addClient(client);
    }

    @Override
    public boolean updateClient(Client client) {

        if(employeeRepository.updateClient(client) == true){
            System.out.println("Update executed with success!");
            return true;
        }

        return false;
    }

    @Override
    public Client listClient(String firstName, String lastName) {

        return employeeRepository.listClient(firstName,lastName);
    }

    @Override
    public boolean addClientAccount(ClientAccount clientAccount) {

        return employeeRepository.addClientAccount(clientAccount);
    }

    @Override
    public boolean deleteClientAccount(int clientID, String typee) {

        return employeeRepository.deleteClientAccount(clientID, typee);
    }

    @Override
    public boolean updateClientAccount(ClientAccount clientAccount) {

        return employeeRepository.updateClientAccount(clientAccount);
    }

    @Override
    public ClientAccount listClientAccount(int clientID, String typee) {

        return employeeRepository.listClientAccount(clientID, typee);
    }

    @Override
    public boolean updateAmountOfMoney(ClientAccount clientAccount) {

        return employeeRepository.updateAmountOfMoney(clientAccount);
    }


}
