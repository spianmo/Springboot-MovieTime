package com.kirito.springboot.demo.controller;

import cn.hutool.core.util.ArrayUtil;
import com.kirito.springboot.demo.annotation.Authorization;
import com.kirito.springboot.demo.base.BaseResponse;
import com.kirito.springboot.demo.base.HttpStatusCode;
import com.kirito.springboot.demo.domain.GroupInfo;
import com.kirito.springboot.demo.domain.Token;
import com.kirito.springboot.demo.domain.UserInfo;
import com.kirito.springboot.demo.dto.MovieInfoDto;
import com.kirito.springboot.demo.service.MenuService;
import com.kirito.springboot.demo.service.MovieService;
import com.kirito.springboot.demo.service.OssService;
import com.kirito.springboot.demo.service.UserService;
import com.kirito.springboot.demo.util.FileTypeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * Copyright (c) 2021
 * @Project: SpringbootDemo
 * @Author: Finger
 * @FileName: AdminController.java
 * @LastModified: 2021/11/16 20:27:16
 */

@RestController
@Slf4j
@RequestMapping("/api/admin")
public class AdminController {
    @Resource
    UserService userService;
    @Resource
    MenuService menuService;
    @Resource
    MovieService movieService;
    @Resource
    private OssService ossService;
    @Value("${upload.image}")
    private String[] allowImageType;

    @PostMapping("login")
    public BaseResponse<Object> login(@RequestParam String username,@RequestParam String password) {
        UserInfo user = userService.findUserInfo(username);
        if (user.getPassword().equals(password)){
            return new BaseResponse<>(HttpStatusCode.SUCCESS, new Token(user.getUserToken()));
        }
        return new BaseResponse<>(HttpStatusCode.LOGIN_FAILD, "用户名密码错误");
    }

    @GetMapping("menus")
    public List<GroupInfo> getMenus() {
        return menuService.getAllGroupMenu();
    }

    @Authorization
    @PostMapping("admin/upload")
    BaseResponse<String> uploadImage(@RequestParam("uploadFile") MultipartFile uploadFile) throws IOException {
        if (uploadFile.getSize() == 0) {
            return new BaseResponse<>(HttpStatusCode.FAILD.getStatus(), "上传文件为空");
        }
        String exif = FileTypeUtils.getFileTypeByMagicNumber(uploadFile.getInputStream());
        if (!ArrayUtil.contains(allowImageType, exif)) {
            return new BaseResponse<>(HttpStatusCode.FAILD.getStatus(), "请上传图片");
        }
        if (uploadFile.getSize() > 2 * 1024 * 1024) {
            return new BaseResponse<>(HttpStatusCode.FAILD.getStatus(), "请上传2M以内的图片");
        }
        String url = ossService.uploadFile(uploadFile);
        return new BaseResponse<>(HttpStatusCode.SUCCESS, url);
    }

    @Authorization
    @PostMapping(value = "create", produces = MediaType.APPLICATION_JSON_VALUE)
    MovieInfoDto createMovie(@RequestBody MovieInfoDto movieCreate) {
        return movieService.createMovie(movieCreate);
    }

    @Authorization
    @PutMapping(value = "update", produces = MediaType.APPLICATION_JSON_VALUE)
    MovieInfoDto updateMovie(@RequestBody MovieInfoDto movieCreate) {
        return movieService.updateMovie(movieCreate);
    }

    @Authorization
    @DeleteMapping("delete/{movieId}")
    Boolean deleteMovie(@PathVariable Integer movieId) {
        return movieService.deleteMovie(movieId);
    }
}
