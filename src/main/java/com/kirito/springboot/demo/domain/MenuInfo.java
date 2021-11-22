package com.kirito.springboot.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Copyright (c) 2021
 * @Project: SpringbootDemo
 * @Author: Finger
 * @FileName: MenuInfo.java
 * @LastModified: 2021/11/15 14:07:15
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuInfo implements Serializable {
    private Long id;
    String menuName;
    String href;
    int sort;
    String component;
    String hasRole;
}
