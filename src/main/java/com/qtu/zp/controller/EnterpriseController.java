package com.qtu.zp.controller;

import com.qtu.zp.domain.BusinessInformation;
import com.qtu.zp.domain.Enterprise;
import com.qtu.zp.Vo.EnterpriseRegisterModel;
import com.qtu.zp.Vo.LoginModel;
import com.qtu.zp.Vo.PageModel;
import com.qtu.zp.domain.EnterpriseMessage;
import com.qtu.zp.domain.JobPositionAndEnterpriseMessage;
import com.qtu.zp.service.EnterpriseService;
import com.qtu.zp.service.JobService;
import com.qtu.zp.utils.result.Result;
import com.qtu.zp.utils.result.ResultFactory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "企业管理", tags = "企业管理")
@RestController
@RequestMapping(value = "/zp")
public class EnterpriseController {

    @Resource
    private EnterpriseService enterpriseService;

    @Resource
    private JobService jobPositionService;


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

    @ApiOperation("企业管理登陆")
    @CrossOrigin
    @RequestMapping(value = "/enterprise/login", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public Result login(@RequestBody LoginModel user, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Enterprise enterprise = enterpriseService.findEnterpriseByPhone(user.getPhone());
        if (enterprise.getEpassword().equals(user.getPassword())) {
            session.setAttribute("enterprise", enterprise);
//            System.out.println("登录session的id是====" + session.getId());

            return ResultFactory.buildSuccessResult(enterprise);
        } else if (bindingResult.hasErrors()) {
            String message = String.format("登陆失败，详细信息[%s]。", bindingResult.getFieldError().getDefaultMessage());
            return ResultFactory.buildFailResult(message);
        } else {
            String message = String.format("登陆失败，用户名、密码信息不正确。");
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
    public Result getJobListByEName(@RequestParam("pageCode") Integer pageCode, @RequestParam("pageSize") Integer pageSize, @RequestParam("phone") String phone, HttpServletRequest request, HttpServletResponse response) {

//        获取公司名称
        if (phone == null) {
            return ResultFactory.buildFailResult("请先登录您的企业账号");
        } else {
            Enterprise enterprise = enterpriseService.findEnterpriseByPhone(phone);
            String eName = enterprise.geteName();
            if (eName == null) {
                return ResultFactory.buildFailResult("请先完善您的企业信息");
            } else {
                PageModel result = jobPositionService.findJobListByEName(pageCode, pageSize, eName);
                return ResultFactory.buildSuccessResult(result);
            }

        }
    }

    //    修改密码
    @CrossOrigin
    @PostMapping(value = "/enterprise/updatePassword", produces = "application/json; charset=UTF-8")
    public Result updatePassword(@RequestBody Enterprise enterprise) {
        enterpriseService.updatePassword(enterprise.getEphone(), enterprise.getEpassword());
        return ResultFactory.buildSuccessResult("密码修改成功");
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
    public Result getEnterpriseByEName(@RequestParam("eName") String eName, HttpServletRequest request, HttpServletResponse response) {

        List<EnterpriseMessage> enterpriseMessages = enterpriseService.getEnterpriseByEName(eName);
        if (enterpriseMessages == null) {
            return ResultFactory.buildFailResult("无法获取该公司的相关信息。");
        } else {
            return ResultFactory.buildSuccessResult(enterpriseMessages);
        }
    }

    //更新职位信息
    @CrossOrigin
    @PostMapping(value = "/enterprise/editEnterprise", produces = "application/json;charset=UTF-8")
    public Result updateEnterprise(@RequestBody EnterpriseRegisterModel enterpriseRegisterModel, HttpServletRequest request, HttpServletResponse response) {
        enterpriseService.updateEnterprise(enterpriseRegisterModel.getEnterprise());
        enterpriseService.updateEnterpriseMessage(enterpriseRegisterModel.getEnterpriseMessage());
        String message = String.format("成功修改。");
        return ResultFactory.buildSuccessResult(message);
    }

    //    游客模式：获取公司的工商信息
//    todo：时间转换
    @CrossOrigin
//    @RequestMapping(value = "/getBusinessInformation", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    @GetMapping(value = "/getBusinessInformation", produces = "application/json; charset=UTF-8")
    public Result getBusinessInformation(@RequestParam("eName") String eName, HttpServletRequest request, HttpServletResponse response) {
        BusinessInformation businessInformation = enterpriseService.getBusinessInformation(eName);
        if (businessInformation == null) {
            return ResultFactory.buildFailResult("由于该企业未进行认证，无法获取该公司的工商信息");
        } else if (businessInformation.getIsVerification().equals("否")) {
//            当该公司的工商信息没有获得验证时，不能显示改公司的工商信息
            return ResultFactory.buildFailResult("由于该企业未进行认证，无法显示该公司的工商信息");
        } else {
            return ResultFactory.buildSuccessResult(businessInformation);
        }

    }


}
