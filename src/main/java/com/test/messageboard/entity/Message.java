package com.test.messageboard.entity;

import lombok.Data;

@Data
public class Message {
    int id;
    String username;
    String title;
    int addTime;
    int chgTime;
    String content;
    String reply;
}
