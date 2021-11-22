package com.kirito.springboot.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Copyright (c) 2021
 * @Project: SpringbootDemo
 * @Author: Finger
 * @FileName: CompanyInfo.java
 * @LastModified: 2021/11/10 15:34:10
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyInfo implements Serializable {
    private Long id;
    private String name;
    private String nameEn;
}
