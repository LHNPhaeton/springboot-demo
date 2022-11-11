package com.example.springbootdemo.service;

import com.example.springbootdemo.mapper.UserMapper;
import com.example.springbootdemo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    public String getUser(int id) {
        User user = userMapper.getUserById(id);
        System.out.println(user);
        // 添加数据到redis
        redisTemplate.opsForValue().set(user.getUsername(), user.toString());
        return user.toString();
    }

    @Cacheable(value = "lhnCache", key="#id")
    public String getUser2(int id) {
        User user = userMapper.getUserById(id);
        System.out.println(user);
        return user.toString();
    }
}
