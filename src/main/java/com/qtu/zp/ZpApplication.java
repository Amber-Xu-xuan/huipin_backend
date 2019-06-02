package com.qtu.zp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//扫描dao包下的dao接口
//@MapperScan("com.qtu.zp.dao")
//扫描config包下的CORSConfig类，用来解决axios的跨域请求问题
//@Configuration

//@MapperScan("com.qtu.zp.dao")
@EnableScheduling
@EnableCaching
public class ZpApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZpApplication.class, args);
    }


}
