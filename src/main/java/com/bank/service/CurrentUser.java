package com.bank.service;

import com.bank.model.User;

public interface CurrentUser {

    void setCurrentUser(User user);

    User getCurrentUser();
}
