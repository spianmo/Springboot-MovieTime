package com.kirito.springboot.demo.service;

import com.kirito.springboot.demo.domain.UserInfo;

/**
 * Copyright (c) 2021
 * @Project: SpringbootDemo
 * @Author: Finger
 * @FileName: UserService.java
 * @LastModified: 2021/11/15 13:50:15
 */

public interface UserService {

    UserInfo findUserInfo(String username);

}
