package com.lrm.service;

import com.lrm.po.User;

public interface RegisterService {
    User saveUser(String username, String password,String nickname);
}
