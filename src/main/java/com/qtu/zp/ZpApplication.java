package com.qtu.zp;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@SpringBootApplication
//扫描dao包下的dao接口
//@MapperScan("com.qtu.zp.dao")
//扫描config包下的CORSConfig类，用来解决axios的跨域请求问题
@Configuration

//@MapperScan("com.qtu.zp.dao")
public class ZpApplication {


    public static void main(String[] args) {
        SpringApplication.run(ZpApplication.class, args);
    }

}
