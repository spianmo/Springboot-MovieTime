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
 * @FileName: MovieInfo.java
 * @LastModified: 2021/11/10 15:34:10
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieInfo implements Serializable {
    private Integer movieId;
    private String name;
    private String nameEn;
    private String img;
    private String bigImage;
    private String titleOthers;
    private float rating;
    private Long directorId;
    private int persionCount;
    private String story;
    private Long ratingCount;
    private int length;
    private String moviePublishDate;
    private int movieYear;
}
