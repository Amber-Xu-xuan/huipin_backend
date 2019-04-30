package com.qtu.zp.controller;

import com.qtu.zp.domain.BusinessInformation;
import com.qtu.zp.domain.Enterprise;
import com.qtu.zp.Vo.EnterpriseRegisterModel;
import com.qtu.zp.Vo.LoginModel;
import com.qtu.zp.Vo.PageModel;
import com.qtu.zp.domain.EnterpriseMessage;
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
@RequestMapping(value = "/zp")
public class EnterpriseController {

    @Resource
    private EnterpriseService enterpriseService;


    @RequestMapping("/getAllEnterprise")
    public List<Enterprise> getAllEnterprise() {

        List<Enterprise> enterprises = enterpriseService.getAllEnterprise();
        return enterprises;
    }

    /**
     * @param user
     * @param bindingResult
     * @param request
     * @param response
     * @return 登录操作
     */

    @CrossOrigin
    @RequestMapping(value = "/enterprise/login", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public Result login(@RequestBody LoginModel user, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Enterprise enterprise = enterpriseService.findEnterpriseByPhone(user.getPhone());
        if (enterprise.getEpassword().equals(user.getPassword())) {
            session.setAttribute("enterprise", enterprise);
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

    @CrossOrigin
    @RequestMapping(value = "/enterprise/logout", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public Result logout(BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.removeAttribute("enterpriseInfo");
        Enterprise enterprise = (Enterprise) session.getAttribute("enterpriseInfo");
        if (enterprise == null) {
            String message = String.format("注销退出失败。");
            return ResultFactory.buildFailResult(message);
        } else {
            String message = String.format("注销退出成功。");
            return ResultFactory.buildFailResult(message);
        }
    }

    /**
     * @param
     * @param request
     * @param
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/enterprise/getJobListByEName", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public Result getJobListByEName(@RequestParam("pageCode") Integer pageCode, @RequestParam("pageSize") Integer pageSize, HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));

        HttpSession session = request.getSession();
        System.out.println("获取session的id是====" + session.getId());
        Enterprise enterprise = (Enterprise) session.getAttribute("enterprise");
        LoginModel user = (LoginModel) session.getAttribute("user");
        System.out.println("从获取到的session储存信息" + enterprise.toString());

//        获取公司名称
        if (enterprise == null) {
            return ResultFactory.buildFailResult("请先登录您的企业账号");
        } else {
            String eName = enterprise.geteName();
            if (eName == null) {
                return ResultFactory.buildFailResult("请先完善您的企业信息");
            } else {
                PageModel result = enterpriseService.findJobListByEName(pageCode, pageSize, eName);
                return ResultFactory.buildSuccessResult(result);
            }

        }
    }

    @RequestMapping(value = "/registerEnterprise", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public Result registerEnterprise(@RequestBody EnterpriseRegisterModel enterpriseRegister, HttpServletRequest request, HttpServletResponse response) {
        if (enterpriseRegister == null) {
            return ResultFactory.buildFailResult("请重新注册");
        } else {
            enterpriseService.registerEnterprise(enterpriseRegister.getEnterprise(), enterpriseRegister.getEnterpriseMessage());
            String message = String.format("成功注册。");
            return ResultFactory.buildSuccessResult(message);
        }

    }

    //    游客模式：通过点击职位card上公司名称跳转到相应的公司信息页面 getEnterpriseByEName
    @CrossOrigin
    @RequestMapping(value = "/getEnterpriseByEName", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public Result getEnterpriseByEName(@RequestParam("eName") String eName ,HttpServletRequest request, HttpServletResponse response) {

         List<EnterpriseMessage> enterpriseMessages = enterpriseService.getEnterpriseByEName(eName);
         if(enterpriseMessages == null){
             return ResultFactory.buildFailResult("无法获取该公司的相关信息。");
         }else{
             return ResultFactory.buildSuccessResult(enterpriseMessages);
        }
    }

//    游客模式：获取公司的工商信息
    @CrossOrigin
//    @RequestMapping(value = "/getBusinessInformation", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    @GetMapping(value = "/getBusinessInformation",produces = "application/json; charset=UTF-8")
    public Result getBusinessInformation(@RequestParam("eName") String eName,HttpServletRequest request, HttpServletResponse response){
        BusinessInformation businessInformation = enterpriseService.getBusinessInformation(eName);
        if(businessInformation == null){
            return ResultFactory.buildFailResult("无法获取该公司的工商信息");
        }else if( businessInformation.getIsVerification().equals("否")){
//            当该公司的工商信息没有获得验证时，不能显示改公司的工商信息
            return ResultFactory.buildFailResult("由于改企业未进行认证，无法显示该公司的工商信息");
        }else {
            return ResultFactory.buildSuccessResult(businessInformation);
        }
    }

}
