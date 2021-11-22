package com.kirito.springboot.demo.exception;

/**
 * Copyright (c) 2021
 * @Project: SpringbootDemo
 * @Author: Finger
 * @FileName: AbnormalLoginException.java
 * @LastModified: 2021/11/10 15:34:10
 */

public class AbnormalLoginException extends RuntimeException {
    public AbnormalLoginException(String error) {
        super(error);
    }
}
