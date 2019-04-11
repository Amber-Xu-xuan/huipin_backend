//package com.qtu.zp.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//
///**
// * @Author: AmberXu
// * @Date: 2019/3/22 16:18
// */
//// 解决axios的跨域请求问题
//@Configuration
//public class CORSConfig implements WebMvcConfigurer{
//
//
////    @Bean
////    public HandlerInterceptor getLoginInterceptor(){
////        return new LoginInterceptor();
////    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry){
////        registry.addInterceptor(getLoginInterceptor())
////                .addPathPatterns("/**")
////                .excludePathPatterns("/error")
////                .excludePathPatterns("/static/*");
//    }
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry){
//        registry.addResourceHandler("/static/**")
//                .addResourceLocations("classpath:/static/");
//    }
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")//设置允许跨域的路径
//                .allowedOrigins("*")//设置允许跨域请求的域名
//                .allowCredentials(true)//是否允许证书 不再默认开启
//                .allowedMethods("GET", "POST", "PUT", "DELETE")//设置允许的方法
//                .maxAge(3600);//跨域允许时间
//    }
//}