package com.kirito.springboot.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Copyright (c) 2021
 * @Project: SpringbootDemo
 * @Author: Finger
 * @FileName: TypeInfoDto.java
 * @LastModified: 2021/11/10 15:34:10
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TypeInfoDto implements Serializable {
    private Long typeId;
    private String name;
    private String movieCount;
}
