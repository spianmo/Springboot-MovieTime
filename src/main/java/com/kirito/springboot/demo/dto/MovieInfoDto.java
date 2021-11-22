package com.kirito.springboot.demo.dto;

import com.kirito.springboot.demo.domain.CompanyInfo;
import com.kirito.springboot.demo.domain.DirectorInfo;
import com.kirito.springboot.demo.domain.WriterInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * Copyright (c) 2021
 * @Project: SpringbootDemo
 * @Author: Finger
 * @FileName: MovieInfoDto.java
 * @LastModified: 2021/11/16 20:27:16
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieInfoDto implements Serializable {
    private Long movieId;
    private String name;
    private String nameEn;
    private String img;
    private String bigImage;
    private String titleOthers;
    private String rating;
    private Long directorId;
    private Integer personCount;
    private String story;
    private Integer ratingCount;
    private Integer length;
    private String moviePublishDate;
    private Integer movieYear;
    private List<WriterInfo> writerInfos;
    private List<CompanyInfo> companyInfos;
    private List<TypeInfoDto> typeInfoList;
    private DirectorInfo directorInfo;
}
