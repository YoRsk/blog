package com.lrm.service.impl;

import com.lrm.dao.UserRepository;
import com.lrm.po.User;
import com.lrm.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(String username, String password,String nickname) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setNickname(nickname);
        return userRepository.save(user);
    }
}
