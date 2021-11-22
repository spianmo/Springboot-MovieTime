package com.kirito.springboot.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kirito.springboot.demo.dao.MovieDao;
import com.kirito.springboot.demo.domain.*;
import com.kirito.springboot.demo.dto.MovieInfoDto;
import com.kirito.springboot.demo.dto.TypeInfoDto;
import com.kirito.springboot.demo.service.MovieService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Copyright (c) 2021
 * @Project: SpringbootDemo
 * @Author: Finger
 * @FileName: MovieServiceImpl.java
 * @LastModified: 2021/11/16 20:43:16
 */

@Service
public class MovieServiceImpl implements MovieService {

    @Resource
    MovieDao movieDao;

    @Override
    public List<MovieTypeInfo> getAllMovieTypeInfo() {
        return movieDao.getAllMovieTypeInfo();
    }

    @Override
    public List<Integer> getAllMovieYears() {
        return movieDao.getMovieInfoYears();
    }

    @Override
    public List<MovieInfo> getAllMoviesbyTypeId(Long typeId) {
        return movieDao.getAllMoviesbyId(typeId);
    }

    @Override
    public PageInfo<MovieInfo> getMovieByCondition(Long typeId, int movieYear, String name, int pageNum, int pageSize) {
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(
                () -> movieDao.getAllMovieByCondition(typeId,name,movieYear)
        );
    }

    @Override
    public MovieInfo getMovieInfoById(Long movieId) {
        return movieDao.getMovieInfoById(movieId);
    }

    @Override
    public List<ActorInfo> getActorsByMovieId(Long movieId) {
        return movieDao.getActorsByMovieId(movieId);
    }

    @Override
    public List<MovieRating> getRatingByMovieId(Long movieId) {
        return movieDao.getRatingByMovieId(movieId);
    }

    @Override
    public List<TypeInfoDto> getCategories() {
        return movieDao.getCategories();
    }

    @Override
    public List<DirectorInfo> getDirectors(String keyword) {
        return movieDao.getDirectors(keyword);
    }

    @Override
    public MovieInfoDto createMovie(MovieInfoDto movieCreate) {
        return movieDao.createMovie(movieCreate);
    }

    @Override
    public MovieInfoDto updateMovie(MovieInfoDto movieCreate) {
        return movieDao.updateMovie(movieCreate);
    }

    @Override
    public Boolean deleteMovie(Integer movieId) {
        return movieDao.deleteMovie(movieId);
    }

}
