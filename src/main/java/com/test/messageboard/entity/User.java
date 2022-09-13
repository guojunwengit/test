package com.test.messageboard.entity;

import lombok.Data;

@Data
public class User {
    String username;
    String password;
    int role;
}
