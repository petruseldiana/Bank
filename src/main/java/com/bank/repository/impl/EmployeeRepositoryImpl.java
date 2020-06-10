package com.bank.repository.impl;

import com.bank.configuration.JDBConnectionWrapper;
import com.bank.model.Client;
import com.bank.model.ClientAccount;
import com.bank.repository.EmployeeRepository;

import java.sql.*;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final JDBConnectionWrapper jdbConnectionWrapper;

    public EmployeeRepositoryImpl(JDBConnectionWrapper jdbConnectionWrapper) {
        this.jdbConnectionWrapper = jdbConnectionWrapper;
    }

    @Override
    public boolean addClient(Client client) {
        Connection connection = jdbConnectionWrapper.getConnection();

        try{

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO Client (firstName, lastName, idCard, pnc, address, email, phone)" +
                            " VALUES (?,?,?,?,?,?,?);"
            );

            preparedStatement.setString(1,client.getFirstName());
            preparedStatement.setString(2,client.getLastName());
            preparedStatement.setInt(3,client.getIdCard());
            preparedStatement.setString(4,client.getPnc());
            preparedStatement.setString(5,client.getAddress());
            preparedStatement.setString(6,client.getEmail());
            preparedStatement.setString(7,client.getPhone());

            preparedStatement.execute();

            return true;

        }catch(SQLException e){
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean updateClient(Client client) {

        Connection connection = jdbConnectionWrapper.getConnection();

        try{

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE Client SET " +
                            "firstName = ?, " +
                            "lastName = ?, " +
                            "idCard = ?, " +
                            "pnc = ?, " +
                            "address = ?, " +
                            "email = ?, " +
                            "phone = ? " +
                            "WHERE id = ?;"
            );

            preparedStatement.setString(1,client.getFirstName());
            preparedStatement.setString(2,client.getLastName());
            preparedStatement.setInt(3,client.getIdCard());
            preparedStatement.setString(4,client.getPnc());
            preparedStatement.setString(5,client.getAddress());
            preparedStatement.setString(6,client.getEmail());
            preparedStatement.setString(7,client.getPhone());
            preparedStatement.setInt(8,client.getId());

            preparedStatement.executeUpdate();

            return true;

        }catch(SQLException e){
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public int giveMeID(String firstName, String lastName) {

        Connection connection = jdbConnectionWrapper.getConnection();

        try{

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT id FROM client WHERE firstname=? and lastname=?;"
            );

            preparedStatement.setString(1,firstName);
            preparedStatement.setString(2,lastName);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){

                Client client = new Client();

                client.setId(resultSet.getInt("id"));

                return client.getId();
            }

        }catch(SQLException e){

            e.printStackTrace();
            return -1;
        }

        return -1;
    }


    @Override
    public Client listClient(String firstName, String lastName) {

        Connection connection = jdbConnectionWrapper.getConnection();

        try{

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT *FROM Client WHERE firstName = ? and lastName = ?;"
            );

            preparedStatement.setString(1,firstName);
            preparedStatement.setString(2,lastName);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){

                Client client = new Client();

                client.setFirstName(resultSet.getString("firstName"));
                client.setLastName(resultSet.getString("lastName"));
                client.setIdCard(resultSet.getInt("idCard"));
                client.setPnc(resultSet.getString("pnc"));
                client.setAddress(resultSet.getString("address"));
                client.setEmail(resultSet.getString("email"));
                client.setPhone(resultSet.getString("phone"));

                return client;
            }


        }catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean addClientAccount(ClientAccount clientAccount) {

        Connection connection = jdbConnectionWrapper.getConnection();

        try{

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO client_account(type, amountOfMoney, creationDate, idClient) VALUES (?,?,?,?);"
            );

            preparedStatement.setString(1,clientAccount.getType());
            preparedStatement.setDouble(2,clientAccount.getAmountOfMoney());
            preparedStatement.setString(3, clientAccount.getCreationDate());
            preparedStatement.setInt(4,clientAccount.getIdClient());

            preparedStatement.executeUpdate();

            return true;

        }catch(SQLException e){
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean deleteClientAccount(int id, String typee) {

        Connection connection = jdbConnectionWrapper.getConnection();

        try{

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM client_account WHERE idClient= ? and type=?;"
            );

            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,typee);

            preparedStatement.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean updateClientAccount(ClientAccount clientAccount) {

        Connection connection = jdbConnectionWrapper.getConnection();

        try{

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE client_account SET " +
                            "amountOfMoney = ?, " +
                            "creationDate = ? " +
                            "WHERE idClient = ? and type =?;"
            );

            preparedStatement.setDouble(1,clientAccount.getAmountOfMoney());
            preparedStatement.setString(2, clientAccount.getCreationDate());
            preparedStatement.setInt(3,clientAccount.getIdClient());
            preparedStatement.setString(4,clientAccount.getType());

            preparedStatement.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public ClientAccount listClientAccount(int clientID, String typee) {

        Connection connection = jdbConnectionWrapper.getConnection();

        try{

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT *FROM client_account WHERE idClient = ? and type=?;"
            );

            preparedStatement.setInt(1,clientID);
            preparedStatement.setString(2,typee);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){

                ClientAccount clientAccount = new ClientAccount();

                clientAccount.setType(resultSet.getString("type"));
                clientAccount.setAmountOfMoney(resultSet.getDouble("amountOfMoney"));
                clientAccount.setCreationDate(resultSet.getString("creationDate"));

                return clientAccount;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateAmountOfMoney(ClientAccount clientAccount) {
        Connection connection = jdbConnectionWrapper.getConnection();

        try{

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE client_account SET " +
                            "amountOfMoney = ? " +
                            "WHERE idClient = ? and type =?;"
            );

            preparedStatement.setDouble(1,clientAccount.getAmountOfMoney());
            preparedStatement.setInt(2,clientAccount.getIdClient());
            preparedStatement.setString(3,clientAccount.getType());

            preparedStatement.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public int getIdByCardID(long idCard, String typee) {
        Connection connection = jdbConnectionWrapper.getConnection();

        try{

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT client.id FROM client " +
                            "JOIN client_account ON client.idCard = ? and client_account.type = ?;"
            );

            preparedStatement.setLong(1,idCard);
            preparedStatement.setString(2,typee);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){

                Client client = new Client();

                client.setId(resultSet.getInt("id"));

                return client.getId();
            }

        }catch(SQLException e){

            e.printStackTrace();
            return -1;
        }

        return -1;
    }


}
