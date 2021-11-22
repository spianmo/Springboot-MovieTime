package com.kirito.springboot.demo.dao;

import com.kirito.springboot.demo.domain.*;
import com.kirito.springboot.demo.dto.MovieInfoDto;
import com.kirito.springboot.demo.dto.TypeInfoDto;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Copyright (c) 2021
 * @Project: SpringbootDemo
 * @Author: Finger
 * @FileName: MovieDao.java
 * @LastModified: 2021/11/16 20:27:16
 */

@Mapper
public interface MovieDao {

    @Select("SELECT b.*, COUNT(a.movie_id) FROM movie_types a,type_info b" +
            " WHERE a.type_id = b.type_id GROUP BY b.type_id ORDER BY COUNT(a.movie_id) ASC")
    List<MovieTypeInfo> getAllMovieTypeInfo();

    @Select("SELECT DISTINCT(movie_info.movie_year)" +
            " FROM movie_info ORDER BY movie_year ASC")
    List<Integer> getMovieInfoYears();

    @Select("        SELECT *" +
            "        FROM movie_info" +
            "        WHERE movie_info.movie_id IN (SELECT movie_id" +
            "                                      FROM movie_types a" +
            "                                      WHERE a.type_id = #{id})")
    List<MovieInfo> getAllMoviesbyId(@Param("id") Long typeId);

/*    @Select("SELECT * FROM movie_info WHERE (movie_info.movie_id IN " +
            "(SELECT movie_id FROM movie_types a WHERE a.type_id = #{id})) AND " +
            "movie_info.name LIKE CONCAT('%',#{name},'%') AND movie_info.movie_year=#{movieYear}")*/
    @Select({"<script>",
            "SELECT *",
            "        from movie_info",
            "        <where>",
            "            <if test='id != 0'>",
            "                (movie_info.movie_id IN (SELECT movie_id FROM movie_types a WHERE a.type_id = #{id}))",
            "            </if>",
            "            <if test='name != \"\"'>",
            "                and movie_info.name like concat('%',#{name},'%')",
            "            </if>",
            "            <if test='movieYear != 0'>",
            "                and movie_info.movie_year=#{movieYear}",
            "            </if>",
            "        </where>",
            "</script>"})
    List<MovieInfo> getAllMovieByCondition(@Param("id") Long id, @Param("name") String name, @Param("movieYear") int movieYear);

    @Select("SELECT * FROM movie_info WHERE movie_id = #{id}")
    MovieInfo getMovieInfoById(@Param("id") Long movieId);

    @Select("        SELECT b.*" +
            "        FROM movie_info a," +
            "             actor_info b," +
            "             movie_actors c" +
            "        WHERE a.movie_id = c.movie_id" +
            "          AND b.actor_id = c.actor_id" +
            "          AND a.movie_id = #{id};")
    List<ActorInfo> getActorsByMovieId(Long movieId);

    @Select("        SELECT *" +
            "        FROM movie_ratings" +
            "        WHERE movie_id = #{id};")
    List<MovieRating> getRatingByMovieId(Long movieId);

    @Select("SELECT t1.type_id,t1.name,COUNT(t1.type_id) AS movie_count FROM type_info t1, movie_types t2 WHERE t2.type_id = t1.type_id GROUP BY t1.type_id;")
    List<TypeInfoDto> getCategories();

    @Select("SELECT * FROM director_info WHERE name LIKE CONCAT('%',#{keyword},'%')")
    List<DirectorInfo> getDirectors(String keyword);

    MovieInfoDto createMovie(MovieInfoDto movieCreate);

    MovieInfoDto updateMovie(MovieInfoDto movieCreate);

    @Delete("DELETE FROM movie_info WHERE movie_id = #{movieId}")
    Boolean deleteMovie(Integer movieId);
}
