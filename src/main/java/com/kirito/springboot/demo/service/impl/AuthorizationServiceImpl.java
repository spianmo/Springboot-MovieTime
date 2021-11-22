package com.kirito.springboot.demo.service.impl;

import com.kirito.springboot.demo.service.AuthorizationService;
import org.springframework.stereotype.Service;

/**
 * Copyright (c) 2021
 * @Project: SpringbootDemo
 * @Author: Finger
 * @FileName: AuthorizationServiceImpl.java
 * @LastModified: 2021/11/10 15:34:10
 */

@Service
public class AuthorizationServiceImpl implements AuthorizationService {
    @Override
    public boolean authorizate(String authorization) {
        // TODO: 2021/11/10 鉴权
        return true;
    }
}
