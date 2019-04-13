package com.qtu.zp.controller;

import com.qtu.zp.domain.Enterprise;
import com.qtu.zp.domain.JobPosition;
import com.qtu.zp.model.LoginModel;
import com.qtu.zp.service.EnterpriseService;
import com.qtu.zp.utils.result.Result;
import com.qtu.zp.utils.result.ResultFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author: AmberXu
 * @Date: 2019/4/11 21:46
 */
@RestController
@RequestMapping(value = "/api")
public class EnterpriseController {

    @Resource
    private EnterpriseService enterpriseService;


    @RequestMapping("/getAllEnterprise")
    public List<Enterprise> getAllEnterprise(){

        List<Enterprise> enterprises = enterpriseService.getAllEnterprise();
        return enterprises;
    }

    /**
     *
     * @param user
     * @param bindingResult
     * @param request
     * @param response
     * @return
     * 登录操作
     */

    @CrossOrigin
    @RequestMapping(value = "/enterprise/login", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public Result login(@RequestBody LoginModel user , BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response) {
        Enterprise enterprise = enterpriseService.findEnterpriseByPhone(user.getPhone());
        if(enterprise.getEpassword().equals(user.getPassword())){
            request.getSession().setAttribute("enterpriseInfo",enterprise);
            return ResultFactory.buildSuccessResult("登陆成功。");
        }else if(bindingResult.hasErrors()) {
            String message = String.format("登陆失败，详细信息[%s]。", bindingResult.getFieldError().getDefaultMessage());
            return ResultFactory.buildFailResult(message);
        }else {
            String message = String.format("登陆失败，用户名、密码信息不正确。");
            return ResultFactory.buildFailResult(message);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/enterprise/logout", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public Result logout(BindingResult bindingResult,HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.removeAttribute("enterpriseInfo");
        Object enterprise = session.getAttribute("enterpriseInfo");
        if (enterprise == null)
        {
            String message = String.format("注销退出失败。");
            return ResultFactory.buildFailResult(message);
        }else {
            String message = String.format("注销退出成功。");
            return ResultFactory.buildFailResult(message);
        }
    }

    /**
     *
     * @param bindingResult
     * @param request
     * @param response
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/enterprise/getJobListByEName", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public Result  getJobListByEName(BindingResult bindingResult,HttpServletRequest request, HttpServletResponse response) {
        HttpSession  session = request.getSession();
        Enterprise enterprise = (Enterprise)session.getAttribute("enterpriseInfo");
//        获取公司名称
        if (enterprise == null){
            return ResultFactory.buildFailResult("请先登录您的企业账号");
        }else {
            String eName = enterprise.geteName();
            if (eName == null){
                return ResultFactory.buildFailResult("请先完善您的企业信息");
            }else{
                List<JobPosition> jobPositions = enterpriseService.findJobListByEName(eName);
                return ResultFactory.buildSuccessResult(jobPositions);
            }

        }
    }



}