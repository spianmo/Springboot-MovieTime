package com.kirito.springboot.demo.service;

import com.kirito.springboot.demo.domain.GroupInfo;

import java.util.List;

/**
 * Copyright (c) 2021
 * @Project: SpringbootDemo
 * @Author: Finger
 * @FileName: MenuService.java
 * @LastModified: 2021/11/15 14:28:15
 */

public interface MenuService {
    List<GroupInfo> getAllGroupMenu();
}
