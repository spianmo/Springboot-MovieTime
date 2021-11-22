package com.kirito.springboot.demo.controller;

import com.github.pagehelper.PageInfo;
import com.kirito.springboot.demo.domain.*;
import com.kirito.springboot.demo.dto.TypeInfoDto;
import com.kirito.springboot.demo.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Copyright (c) 2021
 * @Project: SpringbootDemo
 * @Author: Finger
 * @FileName: MovieController.java
 * @LastModified: 2021/11/16 20:43:16
 */


@RestController
@Slf4j
@RequestMapping("/api/movies")
public class MovieController {

    @Resource
    MovieService movieService;

    @GetMapping("types")
    public List<MovieTypeInfo> getAllMovieTypeInfo() {
        return movieService.getAllMovieTypeInfo();
    }

    @GetMapping("years")
    public List<Integer> getMovieInfoYears() {
        return movieService.getAllMovieYears();
    }

    @GetMapping("type/{typeId}")
    public List<MovieInfo> getAllMoviesbyId(@PathVariable Long typeId) {
        return movieService.getAllMoviesbyTypeId(typeId);
    }

    @GetMapping("movie-list")
    PageInfo<MovieInfo> getMovieByCondition(@RequestParam(required = false,name = "categories", defaultValue = "0") Long typeId, @RequestParam(required = false, defaultValue = "0", name = "movie_year") int movieYear, @RequestParam(required = false, defaultValue = "",name = "keyword") String queryString, @RequestParam(defaultValue = "0") int pageNum, @RequestParam(defaultValue = "10") int pageSize) {
        return movieService.getMovieByCondition(typeId, movieYear, queryString, pageNum, pageSize);
    }

    @GetMapping("detail/{movieId}")
    MovieInfo getMovieInfoById(@PathVariable Long movieId) {
        return movieService.getMovieInfoById(movieId);
    }

    @GetMapping("actors/{movieId}")
    List<ActorInfo> getActorsByMovieId(@PathVariable Long movieId) {
        return movieService.getActorsByMovieId(movieId);
    }

    @GetMapping("rating/{movieId}")
    List<MovieRating> getRatingByMovieId(@PathVariable Long movieId) {
        return movieService.getRatingByMovieId(movieId);
    }

    @GetMapping("categories")
    List<TypeInfoDto> getCategories() {
        return movieService.getCategories();
    }

    @GetMapping("directors")
    List<DirectorInfo> getDirectors(@RequestParam String keyword) {
        return movieService.getDirectors(keyword);
    }

}
