package com.qtu.zp.controller;

import com.qtu.zp.domain.Manager;
import com.qtu.zp.Vo.LoginModel;
import com.qtu.zp.service.ManagerService;
import com.qtu.zp.utils.result.Result;
import com.qtu.zp.utils.result.ResultFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author: AmberXu
 * @Date: 2019/4/18 15:04
 */
@RestController
@RequestMapping(value = "/zp")
public class ManagerController {

    @Resource
    private ManagerService managerService;


    @RequestMapping(value = "/manager/login", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public Result login(@RequestBody LoginModel user, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Manager manager = managerService.findManagerByPhone(user.getPhone());
        if (manager.getMpassword().equals(user.getPassword())) {
            session.setAttribute("manager", manager);
            System.out.println("登录session的id是====" + session.getId());
            return ResultFactory.buildSuccessResult("登陆成功。");
        } else if (bindingResult.hasErrors()) {
            String message = String.format("登陆失败，详细信息[%s]。", bindingResult.getFieldError().getDefaultMessage());
            return ResultFactory.buildFailResult(message);
        } else {
            String message = String.format("登陆失败，用户名、密码信息不正确。");
            return ResultFactory.buildFailResult(message);
        }
    }

    @RequestMapping(value = "/manager/logout", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public Result logout(BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.removeAttribute("manager");
        Manager manager = (Manager) session.getAttribute("manager");
        if (manager == null) {
            String message = String.format("注销退出失败。");
            return ResultFactory.buildFailResult(message);
        } else {
            String message = String.format("注销退出成功。");
            return ResultFactory.buildFailResult(message);
        }
    }
}