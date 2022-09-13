package com.test.messageboard.controller;

import com.test.messageboard.entity.User;
import com.test.messageboard.service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public String Login(@RequestParam String username, @RequestParam String password) {
        User admin = new User();
        admin.setUsername(username);
        admin.setPassword(password);
        System.out.println("username:" + username + " password:" + password );
        List<User> users = userService.get(admin);
        System.out.println("users size" + users.size());
        JSONObject res = new JSONObject();
        if (users.size() > 0) {
            res.put("isLogin", 1);
        } else {
            res.put("isLogin", 0);
        }
        res.put("user", users);
        return res.toString();
    }

    @PostMapping("/register")
    public String Register(@RequestParam String username, @RequestParam String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(1);
        List<User> users = userService.getUser2(user);
        JSONObject res = new JSONObject();
        if (users.size() > 0) {
            res.put("message", "fail");
            return res.toString();
        }

        int result = userService.addUser(user);

        if (result == 1) {
            res.put("message", "success");
        } else {
            res.put("message", "fail");
        }
        return res.toString();
    }
}
