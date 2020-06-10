package com.bank.service.impl;

import com.bank.model.User;
import com.bank.repository.UserRepository;
import com.bank.service.UserService;

import javax.swing.*;

public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public int getID(String name) {

        return userRepository.giveMeID(name);
    }

    @Override
    public boolean checkRole(String role) {

        if(role.equals("admin")) {
            return true;
        }

        return false;
    }

    @Override
    public String findRoleByID(int id) {

        return userRepository.findRoleByID(id);
    }

    @Override
    public int getIDByName(String name) {

        return userRepository.findIdByName(name);
    }

    @Override
    public User login(String username, String password) {

        User user = userRepository.loadByUserName(username);

        if(user != null) {
            if(user.getPassword().equals(password)) {

                return user;
            } else {
                JOptionPane.showMessageDialog(null,"Wrong password.","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null,"User not found.","ERROR",JOptionPane.ERROR_MESSAGE);
        }

        return null;
    }
}
