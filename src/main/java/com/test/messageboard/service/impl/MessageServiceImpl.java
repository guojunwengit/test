package com.test.messageboard.service.impl;

import com.test.messageboard.dao.MessageDao;
import com.test.messageboard.entity.Message;
import com.test.messageboard.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageDao messageDao;

    public int addMessage(Message message) {
        return messageDao.addMessage(message);
    }

    public List<Message> getMessage() {
        return messageDao.getMessage();
    }

    public int updateMessage(Message message) {
        return messageDao.updateMessage(message);
    }

    public int replyMessage(Message message) {
        return messageDao.replyMessage(message);
    }

}
