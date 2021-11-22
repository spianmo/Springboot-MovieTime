package com.kirito.springboot.demo.base;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Copyright (c) 2021
 * @Project: SpringbootDemo
 * @Author: Finger
 * @FileName: BaseResponse.java
 * @LastModified: 2021/11/10 15:34:10
 */


@Data
@AllArgsConstructor
public class BaseResponse<T> {
    private T data;
    private String message;
    private int code;

    public BaseResponse(HttpStatusCode httpStatusCode) {
        this.code = httpStatusCode.getStatus();
        this.message = httpStatusCode.getMessage();
    }

    public BaseResponse(HttpStatusCode httpStatusCode, T data) {
        this.code = httpStatusCode.getStatus();
        this.message = httpStatusCode.getMessage();
        this.data = data;
    }


    public BaseResponse(int code, String message) {
        this.message = message;
        this.code = code;
    }

    public BaseResponse(int code, T data) {
        this.data = data;
        this.code = code;
    }

    public BaseResponse(int code, String message, T data) {
        this.data = data;
        this.message = message;
        this.code = code;
    }
}
