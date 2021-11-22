package com.kirito.springboot.demo.service.impl;

import com.kirito.springboot.demo.dao.UserDao;
import com.kirito.springboot.demo.domain.UserInfo;
import com.kirito.springboot.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Copyright (c) 2021
 * @Project: SpringbootDemo
 * @Author: Finger
 * @FileName: UserServiceImpl.java
 * @LastModified: 2021/11/15 13:50:15
 */

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserDao userDao;
    @Override
    public UserInfo findUserInfo(String username) {
        return userDao.findUserInfo(username);
    }
}
