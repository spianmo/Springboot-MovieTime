package com.kirito.springboot.demo.exception;

/**
 * Copyright (c) 2021
 * @Project: SpringbootDemo
 * @Author: Finger
 * @FileName: ParamRangeException.java
 * @LastModified: 2021/11/10 15:34:10
 */

public class ParamRangeException extends Exception {
    public ParamRangeException(String message) {
        super(message);
    }
}
