package com.kirito.springboot.demo.dao;

import com.kirito.springboot.demo.domain.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Copyright (c) 2021
 * @Project: SpringbootDemo
 * @Author: Finger
 * @FileName: UserDao.java
 * @LastModified: 2021/11/15 13:50:15
 */

@Mapper
public interface UserDao {

    @Select("SELECT * FROM user_info WHERE username = #{username}")
    UserInfo findUserInfo(String username);
}
