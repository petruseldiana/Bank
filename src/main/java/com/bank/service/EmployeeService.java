package com.bank.service;

import com.bank.model.Client;
import com.bank.model.ClientAccount;

public interface EmployeeService {

    boolean addClient(Client client);

    boolean updateClient(Client client);

    Client listClient(String firstName, String lastName);

    boolean addClientAccount(ClientAccount clientAccount);

    boolean deleteClientAccount(int clientID, String typee);

    boolean updateClientAccount(ClientAccount clientAccount);

    ClientAccount listClientAccount(int clientID, String typee);

    boolean updateAmountOfMoney(ClientAccount clientAccount);
}
