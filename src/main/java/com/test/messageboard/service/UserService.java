package com.test.messageboard.service;

import com.test.messageboard.entity.User;

import java.util.List;

public interface UserService {
    public List<User> get(User user);
    public List<User> getUser2(User user);
    public int addUser(User user);
}
