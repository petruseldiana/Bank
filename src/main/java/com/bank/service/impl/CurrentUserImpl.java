package com.bank.service.impl;

import com.bank.model.User;
import com.bank.service.CurrentUser;

public class CurrentUserImpl implements CurrentUser {

    private User currentUser;

    @Override
    public void setCurrentUser(User user) {
        currentUser = user;
    }

    @Override
    public User getCurrentUser() {
        return currentUser;
    }
}
