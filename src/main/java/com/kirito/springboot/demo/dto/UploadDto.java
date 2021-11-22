package com.kirito.springboot.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

/**
 * Copyright (c) 2021
 * @Project: SpringbootDemo
 * @Author: Finger
 * @FileName: UploadDto.java
 * @LastModified: 2021/11/10 15:34:10
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UploadDto implements Serializable {
    private String authorization;
    private MultipartFile imageFile;
}
