package com.test.messageboard.dao;

import com.test.messageboard.entity.User;

import java.util.List;
public interface UserDao {
    public List<User> getUser(User user);
    public int addUser(User user);
    public List<User> getUser2(User user);
}
