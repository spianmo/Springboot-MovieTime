package com.kirito.springboot.demo.dao;

import com.kirito.springboot.demo.domain.GroupInfo;
import com.kirito.springboot.demo.domain.MenuInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Copyright (c) 2021
 * @Project: SpringbootDemo
 * @Author: Finger
 * @FileName: MenuDao.java
 * @LastModified: 2021/11/15 14:34:15
 */

@Mapper
public interface MenuDao {

    @Select("SELECT * FROM group_info ORDER BY sort")
    List<GroupInfo> selectAllGroup();

    @Select("SELECT t2.* FROM group_menu t1, menu_info t2 WHERE t1.group_id = #{groupId} and t1.menu_id = t2.id ORDER BY t2.sort")
    List<MenuInfo> selectGroupMenu(Long groupId);
}
