package com.qtu.zp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: AmberXu
 * @Date: 2019/4/11 9:40
 */
@Controller
public class ErrorPageAction {
    @RequestMapping(value = "/error400Page")
    public String error400Page() {
        return "404";
    }
    @RequestMapping(value = "/error401Page")
    public String error401Page() {
        return "401";
    }
    @RequestMapping(value = "/error404Page")
    public String error404Page(Model model) {
        model.addAttribute("code","404");
        model.addAttribute("msg","This is not the web page you are looking for......");
        return "404";
    }
    @RequestMapping(value = "/error500Page")
    public String error500Page(Model model) {
        return "500";
    }
}
