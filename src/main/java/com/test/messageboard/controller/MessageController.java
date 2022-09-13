package com.test.messageboard.controller;

import com.test.messageboard.entity.Message;
import com.test.messageboard.service.MessageService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
public class MessageController {
    @Autowired
    MessageService messageService;

    @PostMapping("/add")
    public String AddMessage(@RequestParam String username, @RequestParam String title, @RequestParam String content) {
        Message message = new Message();
        message.setUsername(username);
        message.setContent(content);
        message.setTitle(title);
        message.setAddTime((int) (System.currentTimeMillis() / 1000));
        message.setChgTime((int) (System.currentTimeMillis() / 1000));
        int result = messageService.addMessage(message);
        JSONObject res = new JSONObject();
        if (result == 1) {
            res.put("message", "success");
        } else {
            res.put("message", "fail");
        }
        System.out.println(result);
        return res.toString();
    }

    @GetMapping("/get")
    public String GetMessage() {
        List<Message> messageList = messageService.getMessage();
        JSONObject res = new JSONObject();
        res.put("messageList", messageList);
        return res.toString();
    }

    @PostMapping("/update")
    public String UpdateMessage(@RequestParam int id, @RequestParam String content) {
        Message message = new Message();
        message.setId(id);
        message.setContent(content);
        message.setChgTime((int) (System.currentTimeMillis() / 1000));
        int result = messageService.updateMessage(message);
        JSONObject res = new JSONObject();
        if (result == 1) {
            res.put("message", "success");
        } else {
            res.put("message", "fail");
        }
        return res.toString();
    }

    @PostMapping("/reply")
    public String ReplyMessage(@RequestParam int id, @RequestParam String reply) {
        Message message = new Message();
        message.setId(id);
        message.setReply(reply);
        message.setChgTime((int) (System.currentTimeMillis() / 1000));
        int result = messageService.replyMessage(message);
        JSONObject res = new JSONObject();
        if (result == 1) {
            res.put("message", "success");
        } else {
            res.put("message", "fail");
        }
        return res.toString();
    }
}
