package com.qtu.zp.controller;

import com.qtu.zp.Vo.PageModel;
import com.qtu.zp.Vo.QueryPagerConditionVo;
import com.qtu.zp.domain.Manager;
import com.qtu.zp.Vo.LoginModel;
import com.qtu.zp.domain.StatisticResult;
import com.qtu.zp.service.BusinessInformationService;
import com.qtu.zp.service.ManagerService;
import com.qtu.zp.utils.result.Result;
import com.qtu.zp.utils.result.ResultFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: AmberXu
 * @Date: 2019/4/18 15:04
 */
@RestController
@RequestMapping(value = "/zp")
public class ManagerController {

    @Resource
    private ManagerService managerService;

    @Resource
    private BusinessInformationService businessInformationService;


    @RequestMapping(value = "/manager/login", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public Result login(@RequestBody LoginModel user, BindingResult bindingResult) {
        Manager manager = managerService.findManagerByPhone(user.getPhone());
        if (manager.getMpassword().equals(user.getPassword())) {
            return ResultFactory.buildSuccessResult(manager);
        } else if (bindingResult.hasErrors()) {
            String message = String.format("登陆失败，详细信息[%s]。", bindingResult.getFieldError().getDefaultMessage());
            return ResultFactory.buildFailResult(message);
        } else {
            String message = String.format("登陆失败，用户名、密码信息不正确。");
            return ResultFactory.buildFailResult(message);
        }
    }

    @PostMapping(value = "manager/getBusinessInfoByIsVerification")
    public Result getBusinessInfoByIsVerification(@RequestBody QueryPagerConditionVo conditionVo){
        if (conditionVo.getPhone() == "" || conditionVo.getPhone() == null){
            return ResultFactory.buildFailResult("请登录管理员账号，目前您无该权限");
        }else {
            PageModel result = businessInformationService.getBusinessInfoByIsVerification(conditionVo.getPageCode(),conditionVo.getPageSize(),conditionVo.getPhone());
            return ResultFactory.buildSuccessResult(result);
        }
    }
    @PutMapping(value = "manager/passBusinessInfo")
    public Result passBusinessInfo(@RequestBody QueryPagerConditionVo conditionVo){
        if (conditionVo.getPhone() == "" || conditionVo.getPhone() == null){
            return ResultFactory.buildFailResult("请登录管理员账号，目前您无该权限");
        }else {
            businessInformationService.editBusinessInfoIsVerificationByBId(conditionVo.getId());
            return ResultFactory.buildSuccessResult("修改成功");
        }
    }

    @PutMapping(value = "manager/notifyEnterpriseBusinessInfoIsWrong")
    public Result notifyEnterpriseBusinessInfoIsWrong(@RequestBody QueryPagerConditionVo conditionVo){
        if (conditionVo.getPhone() == "" || conditionVo.getPhone() == null){
            return ResultFactory.buildFailResult("请登录管理员账号，目前您无该权限");
        }else {
//            notifyInfo存在IsVerification字段中，再通知用户
            businessInformationService.editBusinessInfoNotifyInfoByBId(conditionVo.getId(),conditionVo.getInfo());
            return ResultFactory.buildSuccessResult("提交成功");
        }
    }

    @GetMapping(value = "/manager/StatisticCandidate")
    public Result StatisticCandidate(String phone){
        if (phone == null || phone==""){
            return ResultFactory.buildFailResult("请登录管理员账号，您目前并无该权限");
        }else {
           List<StatisticResult> result =  managerService.StatisticCandidateNumByMonth();

           StatisticResult s = new StatisticResult();
           List<String> date = new ArrayList<String>();
           List<Integer> sum = new ArrayList<Integer>();
           for (StatisticResult x: result){
               date.add(x.getDate());
               sum.add(x.getSum());
           }
           s.setDateList(date);
           s.setSumList(sum);
            return ResultFactory.buildSuccessResult(s);
        }
    }

    @GetMapping(value = "/manager/StatisticEnterprise")
    public Result StatisticEnterprise(String phone){
        if (phone == null || phone==""){
            return ResultFactory.buildFailResult("请登录管理员账号，您目前并无该权限");
        }else {
            List<StatisticResult> result =  managerService.StatisticEnterpriseNumByMonth();

            StatisticResult s = new StatisticResult();
            List<String> date = new ArrayList<String>();
            List<Integer> sum = new ArrayList<Integer>();
            for (StatisticResult x: result){
                date.add(x.getDate());
                sum.add(x.getSum());
            }
            s.setDateList(date);
            s.setSumList(sum);
            return ResultFactory.buildSuccessResult(s);
        }
    }

    @GetMapping(value = "/manager/StatisticResume")
    public Result StatisticResume(String phone){
        if (phone == null || phone==""){
            return ResultFactory.buildFailResult("请登录管理员账号，您目前并无该权限");
        }else {
            List<StatisticResult> result =  managerService.StatisticResumeNumByMonth();

            StatisticResult s = new StatisticResult();
            List<String> date = new ArrayList<String>();
            List<Integer> sum = new ArrayList<Integer>();
            for (StatisticResult x: result){
                date.add(x.getDate());
                sum.add(x.getSum());
            }
            s.setDateList(date);
            s.setSumList(sum);
            return ResultFactory.buildSuccessResult(s);
        }
    }

    @CrossOrigin
    @PostMapping(value = "/manager/updatePassword",produces = "application/json; charset=UTF-8")
    public Result updatePassword(@RequestBody Manager manager){
        if (manager.getMphone() == null){
            ResultFactory.buildFailResult("请登录管理员账号后，");
        }
        managerService.updatePassword(manager.getMphone(),manager.getMpassword());
        return ResultFactory.buildSuccessResult("密码修改成功");
    }

}