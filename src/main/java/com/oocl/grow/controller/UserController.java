package com.oocl.grow.controller;

import com.oocl.grow.model.User;
import com.oocl.grow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public User getTestUserInfo(){
        return userService.getTestUserInfo();
    }

}
