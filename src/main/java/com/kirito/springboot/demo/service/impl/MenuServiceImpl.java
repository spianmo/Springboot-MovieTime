package com.kirito.springboot.demo.service.impl;

import com.kirito.springboot.demo.dao.MenuDao;
import com.kirito.springboot.demo.domain.GroupInfo;
import com.kirito.springboot.demo.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Copyright (c) 2021
 * @Project: SpringbootDemo
 * @Author: Finger
 * @FileName: MenuServiceImpl.java
 * @LastModified: 2021/11/15 14:28:15
 */

@Service
public class MenuServiceImpl implements MenuService {
    @Resource
    MenuDao menuDao;
    @Override
    public List<GroupInfo> getAllGroupMenu() {
        List<GroupInfo> groupInfoList = menuDao.selectAllGroup();
        for (GroupInfo groupInfo: groupInfoList){
            groupInfo.setItems(menuDao.selectGroupMenu(groupInfo.getId()));
        }
        return groupInfoList;
    }
}
