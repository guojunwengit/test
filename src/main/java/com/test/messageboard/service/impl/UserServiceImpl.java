package com.test.messageboard.service.impl;

import com.test.messageboard.dao.UserDao;
import com.test.messageboard.entity.User;
import com.test.messageboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;


    public List<User> get(User user) {
        return userDao.getUser(user);
    }

    public List<User> getUser2(User user) {
        return userDao.getUser2(user);
    }

    public int addUser(User user) {
        return userDao.addUser(user);
    }
}
