//package com.qtu.zp.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import javax.annotation.Resource;
//
///**
// * @Author: AmberXu
// * @Date: 2019/4/10 18:23
// */
//@Configuration
//public class WebMvcConfig implements WebMvcConfigurer {
////    @Resource
//////    private BaseInterceptor baseInterceptor;
////    @Override
////    public void addInterceptors(InterceptorRegistry registry) {
//////        registry.addInterceptor(baseInterceptor)
////                //需要配置2：----------- 告知拦截器：/static/admin/** 与 /static/user/** 不需要拦截 （配置的是 路径）
//////                .excludePathPatterns("/static/admin/**", "/static/user/**");
////    }
////
////    /**
////     * 添加静态资源文件，外部可以直接访问地址
////     * @param registry
////     */
////    @Override
////    public void addResourceHandlers(ResourceHandlerRegistry registry) {
////        //其他静态资源，与本文关系不大
//////        registry.addResourceHandler("/upload/**").addResourceLocations("file:"+ TaleUtils.getUplodFilePath()+"upload/");
////
////        //需要配置1：----------- 需要告知系统，这是要被当成静态文件的！
////        //第一个方法设置访问路径前缀，第二个方法设置资源路径
////        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
////    }
//
//    /**
//     * 添加静态资源文件，外部可以直接访问地址
//     *
//     * @param registry
//     */
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//        registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/");
//    }
//
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/error/404").setViewName("/admin/page_error/error_404.html");
//    }
//}
