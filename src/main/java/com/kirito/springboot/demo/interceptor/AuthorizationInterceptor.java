package com.kirito.springboot.demo.interceptor;


import com.kirito.springboot.demo.annotation.Authorization;
import com.kirito.springboot.demo.exception.AbnormalLoginException;
import com.kirito.springboot.demo.exception.MissAuthorizationException;
import com.kirito.springboot.demo.service.AuthorizationService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.lang.Nullable;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;

/**
 * Copyright (c) 2021
 * @Project: SpringbootDemo
 * @Author: Finger
 * @FileName: AuthorizationInterceptor.java
 * @LastModified: 2021/11/10 15:34:10
 */

@Slf4j
public class AuthorizationInterceptor implements HandlerInterceptor {

    @Resource
    private AuthorizationService mAuthorizationService;

    @Override
    public boolean preHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) {
        //判断如果不是请求control方法直接返回true
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod method = (HandlerMethod) handler;
        //判断访问的control是否添加LoginRequired注解
        Authorization loginRequired = method.getMethodAnnotation(Authorization.class);
        if (loginRequired != null) {
            String authorization = request.getHeader("Authorization");
            if (StringUtils.isEmpty(authorization)) {
                throw new MissAuthorizationException("鉴权失败，接口访问受限");
            }
            // TODO: 2021/11/10 鉴权Authorization
            if (mAuthorizationService.authorizate(authorization)) {
                return true;
            } else {
                throw new AbnormalLoginException("鉴权异常，接口访问受限");
            }
        } else {
            return true;
        }
    }

    @Override
    public void postHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler, @Nullable ModelAndView modelAndView) {
    }

    @Override
    public void afterCompletion(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler, @Nullable Exception ex) {
    }

}
