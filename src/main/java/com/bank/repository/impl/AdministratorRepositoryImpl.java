package com.bank.repository.impl;

import com.bank.configuration.JDBConnectionWrapper;
import com.bank.model.User;
import com.bank.repository.AdministratorRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdministratorRepositoryImpl implements AdministratorRepository {

    private final JDBConnectionWrapper jdbConnectionWrapper;

    public AdministratorRepositoryImpl(JDBConnectionWrapper jdbConnectionWrapper) {
        this.jdbConnectionWrapper = jdbConnectionWrapper;
    }

    @Override
    public boolean addEmployee(User user) {
        Connection connection = jdbConnectionWrapper.getConnection();

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO User(namee, address, phone, email, profession, username, password, role) " +
                            "VALUES (?,?,?,?,?,?,?,?);");

            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getAddress());
            preparedStatement.setString(3,user.getPhone());
            preparedStatement.setString(4,user.getEmail());
            preparedStatement.setString(5,user.getProfession());
            preparedStatement.setString(6,user.getUsername());
            preparedStatement.setString(7,user.getPassword());
            preparedStatement.setString(8,user.getRole());

            preparedStatement.execute();

            return true;

        }catch(SQLException e){
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean deleteEmployee(int id) {

        Connection connection = jdbConnectionWrapper.getConnection();

        try{

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM User WHERE id = ?"
            );

            preparedStatement.setInt(1,id);

            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();

            return false;
        }

        return true;
    }


    @Override
    public boolean updateEmployee(User user) {

        Connection connection = jdbConnectionWrapper.getConnection();

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE User SET " +
                            "namee = ?, " +
                            "address = ?, " +
                            "phone = ?, " +
                            "email = ?, " +
                            "profession = ? " +
                            "WHERE id = ?"
            );

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2,user.getAddress());
            preparedStatement.setString(3,user.getPhone());
            preparedStatement.setString(4,user.getEmail());
            preparedStatement.setString(5,user.getProfession());
            preparedStatement.setInt(6,user.getId());

            preparedStatement.executeUpdate();

            return true;

        }catch(SQLException e){
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public User getEmployee(String name) {

        Connection connection = jdbConnectionWrapper.getConnection();

        List<User> employees = new ArrayList<User>();

        try{

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT *FROM User WHERE namee = ?"
            );

            preparedStatement.setString(1,name);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {

                User user = new User();

                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("namee"));
                user.setAddress(resultSet.getString("address"));
                user.setPhone(resultSet.getString("phone"));
                user.setEmail(resultSet.getString("email"));
                user.setProfession(resultSet.getString("profession"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(resultSet.getString("role"));

                return user;
            }

        }catch(SQLException e){
            e.printStackTrace();
        }

        return null;
    }
}
