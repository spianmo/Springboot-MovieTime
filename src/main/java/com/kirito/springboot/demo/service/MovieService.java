package com.kirito.springboot.demo.service;


import com.github.pagehelper.PageInfo;
import com.kirito.springboot.demo.domain.*;
import com.kirito.springboot.demo.dto.MovieInfoDto;
import com.kirito.springboot.demo.dto.TypeInfoDto;

import java.util.List;

/**
 * Copyright (c) 2021
 * @Project: SpringbootDemo
 * @Author: Finger
 * @FileName: MovieService.java
 * @LastModified: 2021/11/16 20:43:16
 */

public interface MovieService {
    List<MovieTypeInfo> getAllMovieTypeInfo();

    List<Integer> getAllMovieYears();

    List<MovieInfo> getAllMoviesbyTypeId(Long typeId);

    PageInfo<MovieInfo> getMovieByCondition(Long id, int movieYear, String name, int pageNum, int pageSize);

    MovieInfo getMovieInfoById(Long movieId);

    List<ActorInfo> getActorsByMovieId(Long movieId);

    List<MovieRating> getRatingByMovieId(Long movieId);

    List<TypeInfoDto> getCategories();

    List<DirectorInfo> getDirectors(String keyword);

    MovieInfoDto createMovie(MovieInfoDto movieCreate);

    MovieInfoDto updateMovie(MovieInfoDto movieCreate);

    Boolean deleteMovie(Integer movieId);
}
