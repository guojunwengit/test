package com.test.messageboard.dao;

import com.test.messageboard.entity.Message;

import java.util.List;


public interface MessageDao {
    public int addMessage(Message message);
    public List<Message> getMessage();
    public int updateMessage(Message message);
    public int replyMessage(Message message);
}
