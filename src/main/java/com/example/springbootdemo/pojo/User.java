package com.example.springbootdemo.pojo;

import lombok.Data;

import java.time.Instant;

@Data
public class User {
    long id;
    String username;
    String password;
    Instant createTime;
}
