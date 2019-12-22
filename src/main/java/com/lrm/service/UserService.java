package com.lrm.service;

import com.lrm.po.User;

public interface UserService {

    User checkUser(String username, String password);
    User getUser(Long id);
}
