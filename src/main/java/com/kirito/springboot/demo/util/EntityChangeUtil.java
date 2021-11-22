package com.kirito.springboot.demo.util;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (c) 2021
 * @Project: SpringbootDemo
 * @Author: Finger
 * @FileName: EntityChangeUtil.java
 * @LastModified: 2021/11/16 20:36:16
 */

public class EntityChangeUtil {
    public static<DAO,DTO> DAO toDAO(Class<DAO> clazz,DTO dto) throws IllegalAccessException, InstantiationException {
        DAO dao = clazz.newInstance();
        BeanUtils.copyProperties(dto,dao);
        return dao;
    }

    public static<DAO,DTO> List<DAO> toDAO(Class<DAO> clazz,List<DTO> dtos) throws IllegalAccessException, InstantiationException {
        List<DAO> daos = new ArrayList<>();
        dtos.forEach(dto ->{
            try {
                daos.add(toDAO(clazz,dto));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        });
        return daos;
    }


    public static<DAO,DTO> DTO toDTO(Class<DTO> clazz,DAO dao) throws IllegalAccessException, InstantiationException {
        DTO dto = clazz.newInstance();
        BeanUtils.copyProperties(dao,dto);
        return dto;
    }

    public static<DTO,DAO> List<DTO> toDTO(Class<DTO> clazz,List<DAO>daos) {
        List<DTO> dtos = new ArrayList<>();
        daos.forEach(dao ->{
            try {
                dtos.add(toDTO(clazz,dao));
            } catch (IllegalAccessException | InstantiationException e) {
                e.printStackTrace();
            }
        });
        return dtos;
    }

}
