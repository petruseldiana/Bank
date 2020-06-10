package com.bank.repository;

import com.bank.model.Client;
import com.bank.model.ClientAccount;

public interface EmployeeRepository {

    boolean addClient(Client client);

    boolean updateClient(Client client);

    int giveMeID(String firstName, String lastName);

    Client listClient(String firstName, String lastName);

    boolean addClientAccount(ClientAccount clientAccount);

    boolean deleteClientAccount(int id, String typee);

    boolean updateClientAccount(ClientAccount clientAccount);

    ClientAccount listClientAccount(int clientID, String typee);

    boolean updateAmountOfMoney(ClientAccount clientAccount);

    int getIdByCardID(long idCard, String type);
}
