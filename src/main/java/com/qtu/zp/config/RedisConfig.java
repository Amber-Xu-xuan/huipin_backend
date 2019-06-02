//package com.qtu.zp.config;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cache.CacheManager;
//import org.springframework.cache.annotation.CachingConfigurerSupport;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.cglib.core.internal.CustomizerRegistry;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.cache.RedisCacheConfiguration;
//import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.cache.RedisCacheWriter;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.serializer.*;
//
//import com.fasterxml.jackson.annotation.JsonAutoDetect;
//import com.fasterxml.jackson.annotation.PropertyAccessor;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import java.time.Duration;
//
///**
// * @Author: AmberXu
// * @Date: 2019/5/25 12:19
// * Redis缓存配置类
// */
//@Configuration
//@EnableCaching
//public class RedisConfig {
//    @Value("${spring.redis.host}")
//    private String host;
//    @Value("${spring.redis.port}")
//    private int port;
//    @Value("${spring.redis.timeout}")
//    private int timeout;
//
//    //自定义缓存key生成策略
////    @Bean
////    public KeyGenerator keyGenerator() {
////        return new KeyGenerator(){
////            @Override
////            public Object generate(Object target, java.lang.reflect.Method method, Object... params) {
////                StringBuffer sb = new StringBuffer();
////                sb.append(target.getClass().getName());
////                sb.append(method.getName());
////                for(Object obj:params){
////                    sb.append(obj.toString());
////                }
////                return sb.toString();
////            }
////        };
////    }
//    //缓存管理器
//
//    /**
//     * RedisTemplate:Redis
//     * 模块模块核心类，基于Java的序列化程序，2.0之后提供对Redis的set、setnx、get等命令的访问权限，可有多个缓存实现共享、负责读写来自Redis的二进制数据
//     * @param @SuppressWarnings("rawtypes") RedisTemplate redisTemplate1.0
//     * @return
//     */
//    @Bean
//    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
//        //初始化一个RedisCacheWriter
//        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory);
//        //设置CacheManager的值序列化方式为json序列化
//        RedisSerializer<Object> jsonSerializer = new GenericJackson2JsonRedisSerializer();
//        RedisSerializationContext.SerializationPair<Object> pair = RedisSerializationContext.SerializationPair
//                .fromSerializer(jsonSerializer);
//        RedisCacheConfiguration defaultCacheConfig=RedisCacheConfiguration.defaultCacheConfig()
//                .serializeValuesWith(pair);
//        //设置默认超过期时间是30秒
//        defaultCacheConfig.entryTtl(Duration.ofSeconds(30));
//        //1.0初始化RedisCacheManager
////        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
//        //1.0设置缓存过期时间
////        cacheManager.setDefaultExpiration(10000);
//        //初始化RedisCacheManager
//        return new RedisCacheManager(redisCacheWriter, defaultCacheConfig);
//    }
//    @Bean
//    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory){
////        StringRedisTemplate template = new StringRedisTemplate(factory);
////        setSerializer(template);//设置序列化工具
////        template.afterPropertiesSet();
//        RedisTemplate<String, Object> template = new RedisTemplate<>();
//
//        RedisSerializer<String> redisSerializer = new StringRedisSerializer();
//
//        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//        ObjectMapper om = new ObjectMapper();
//        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        jackson2JsonRedisSerializer.setObjectMapper(om);
//
//        template.setConnectionFactory(factory);
//        //key序列化方式
//        template.setKeySerializer(redisSerializer);
//        //value序列化
//        template.setValueSerializer(jackson2JsonRedisSerializer);
//        //value hashmap序列化
//        template.setHashValueSerializer(jackson2JsonRedisSerializer);
//        return template;
//    }
//    private void setSerializer(StringRedisTemplate template){
//        @SuppressWarnings({ "rawtypes", "unchecked" })
//        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//        ObjectMapper om = new ObjectMapper();
//        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        jackson2JsonRedisSerializer.setObjectMapper(om);
//        template.setValueSerializer(jackson2JsonRedisSerializer);
//    }
//}
