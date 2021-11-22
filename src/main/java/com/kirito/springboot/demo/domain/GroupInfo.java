package com.kirito.springboot.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * Copyright (c) 2021
 * @Project: SpringbootDemo
 * @Author: Finger
 * @FileName: GroupInfo.java
 * @LastModified: 2021/11/15 14:07:15
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupInfo implements Serializable {
    private Long id;
    private String groupName;
    private String groupCode;
    private int sort;
    List<MenuInfo> items;
}
