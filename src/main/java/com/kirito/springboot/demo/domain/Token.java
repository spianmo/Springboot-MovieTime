package com.kirito.springboot.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Copyright (c) 2021
 * @Project: SpringbootDemo
 * @Author: Finger
 * @FileName: Token.java
 * @LastModified: 2021/11/15 13:50:15
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Token implements Serializable {
    private String idToken;
}
