package com.example.springbootdemo.controller;


import com.example.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getUser")
    public String getUserById(@RequestParam int id) {
        return userService.getUser2(id);
    }
}
