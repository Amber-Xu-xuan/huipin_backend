package com.qtu.zp;

import com.qtu.zp.controller.HelloController;
//导入静态包
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class ZpApplicationTests {
//
//    @Test
//    public void contextLoads() {
//    }
//
//}
/*
*可以在测试期间很方便的类似编码一样进行自动注入等容器的功能
*
 */
// 在@Before函数中创建并传递到MockMvcBuilders.standaloneSetup（）函数中
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MockServletContext.class)
@WebAppConfiguration
public class ZpApplicationTests {

    private MockMvc mvc;
    @Autowired
//    Person person;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
    }

    @Test
    public void getHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Hello World")));
    }


    //        获取记录器
    Logger logger = LoggerFactory.getLogger(getClass());
    @Test
    public void contextLoads() {
//        log:日志, logger:记录器
//        日志级别：由低到高，可以调整输出砈日志级别
        logger.trace("这是trace日志");
        logger.debug("this is debug log");
//        默认使用info级别
//        设置日志级别：在配置文件中编写logging.level.com.qtu.zp = trace，root级别
        logger.info("this is info");
        logger.warn("this is warning logger");
        logger.error(("this is error logger"));
    }

}