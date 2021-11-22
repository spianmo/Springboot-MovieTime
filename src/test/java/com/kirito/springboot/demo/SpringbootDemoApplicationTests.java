package com.kirito.springboot.demo;

import com.kirito.springboot.demo.util.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.Serializable;

/**
 * Copyright (c) 2021
 * @Project: SpringbootDemo
 * @Author: Finger
 * @FileName: SpringbootDemoApplicationTests.java
 * @LastModified: 2021/11/10 15:33:10
 */

@SpringBootTest
public class SpringbootDemoApplicationTests {
    @Autowired
    private RedisUtil redis;
    @Test
    void contextLoads() {
    }

    @Test
    void test() {
        redis.set("user1", new User("唐钱进", 22));
        System.out.println(redis.get("user1").toString());
    }

    static class User implements Serializable {
        private String name;
        private int age;

        public User(){}
        public User(String name, int age){
            this.name = name;
            this.age = age;
        }
    }
}


