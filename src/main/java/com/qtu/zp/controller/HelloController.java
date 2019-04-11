package com.qtu.zp.controller;

        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;

/**
 * @Author amberXu
 * @Description //TODO
 * @Date 2019/3/11  9:23
 * @Param
 **/
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }

}