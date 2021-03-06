package com.qtu.zp.config;

import com.qtu.zp.component.LoginHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.*;

import javax.annotation.Resource;
import javax.servlet.MultipartConfigElement;

/**
 * @Author: AmberXu
 * @Date: 2019/4/10 18:23
 */
//WebMvcConfigurerAdapter
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 在配置文件中配置的文件保存路径
     */
    @Value("${cbs.imagesPath}")
    private String mImagesPath;

    /**
     * 添加静态资源文件，外部可以直接访问地址
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/");

        registry.addResourceHandler("/uploadImage/**").addResourceLocations("file:C:/Program Files/Apache Software Foundation/Tomcat 8.0/webapps/");
    }

    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory = new MultipartConfigFactory();
//        //文件最大KB,MB
//        factory.setMaxFileSize("1024MB");
//        //设置总上传数据总大小
//        factory.setMaxRequestSize("1024MB");
        return factory.createMultipartConfig();
    }




    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")//设置允许跨域的路径
                .allowedOrigins("*")//设置允许跨域请求的域名
                .allowCredentials(true)//是否允许证书 不再默认开启
                .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS")//设置允许的方法
                .allowCredentials(true)
                .maxAge(3600);//跨域允许时间
    }

//    //    添加登录拦截器
//    @Bean
//    public HandlerInterceptor getMyInterceptor() {
//        return new LoginHandlerInterceptor();
//    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginHandlerInterceptor())
//                .addPathPatterns("/zp/enterpriseCenter");
//        .addPathPatterns("/zp/candidate/**","/zp/enterprise/**","/zp/manager")
//                .excludePathPatterns("/zp/candidate/login","/zp/enterprise/login","/zp/manager/login");
    }


//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/error/404").setViewName("/admin/page_error/error_404.html");
//    }
}
