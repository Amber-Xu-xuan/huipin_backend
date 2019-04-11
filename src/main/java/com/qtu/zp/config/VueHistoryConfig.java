//package com.qtu.zp.config;
//
///**
// * @Author: AmberXu
// * @Date: 2019/4/10 22:03
// */
//
//import org.springframework.boot.web.server.ErrorPage;
//import org.springframework.boot.web.server.ErrorPageRegistrar;
//import org.springframework.boot.web.server.ErrorPageRegistry;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Component;
//
//@Component
//public class VueHistoryConfig implements ErrorPageRegistrar {
//
//    @Override
//    public void registerErrorPages(ErrorPageRegistry registry) {
//        ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/index.html");
//        registry.addErrorPages(error404Page);
//    }
//}