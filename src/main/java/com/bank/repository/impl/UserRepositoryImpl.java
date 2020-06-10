package com.bank.repository.impl;

import com.bank.configuration.JDBConnectionWrapper;
import com.bank.model.User;
import com.bank.repository.UserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepositoryImpl implements UserRepository {

    private final JDBConnectionWrapper jdbConnectionWrapper;

    public UserRepositoryImpl(JDBConnectionWrapper jdbConnectionWrapper) {
        this.jdbConnectionWrapper = jdbConnectionWrapper;
    }

    @Override
    public int giveMeID(String name) {

        Connection connection = jdbConnectionWrapper.getConnection();

        try{

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT id FROM user WHERE namee=?;"
            );

            preparedStatement.setString(1,name);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){

                User user = new User();

                user.setId(resultSet.getInt("id"));

                return user.getId();
            }

        }catch(SQLException e){

            e.printStackTrace();
            return -1;
        }

        return -1;
    }

    @Override
    public String findRoleByID(int id) {

        Connection connection = jdbConnectionWrapper.getConnection();

        try{

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT role FROM User WHERE id = ?;"
            );

            preparedStatement.setInt(1,id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){

                User user = new User();

                user.setRole(resultSet.getString("role"));

                return user.getRole();
            }

        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }

        return null;
    }

    @Override
    public int findIdByName(String name) {
        Connection connection = jdbConnectionWrapper.getConnection();

        try{

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT id FROM User WHERE namee=?;"
            );

            preparedStatement.setString(1, name);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){

                User user = new User();

                user.setId(resultSet.getInt("id"));

                return user.getId();
            }

        }catch(SQLException e){

            e.printStackTrace();
            return -1;
        }

        return -1;
    }

    @Override
    public User loadByUserName(String username) {
        Connection connection = jdbConnectionWrapper.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE username=?");

            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
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
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
