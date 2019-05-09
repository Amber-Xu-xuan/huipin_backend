package com.qtu.zp.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qtu.zp.Vo.PageModel;
import com.qtu.zp.domain.BusinessInformation;
import com.qtu.zp.service.BusinessInformationService;
import com.qtu.zp.utils.result.Result;
import com.qtu.zp.utils.result.ResultFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author: AmberXu
 * @Date: 2019/5/9 7:54
 */
@RestController
@RequestMapping("/zp")
public class BusinessInformationController {

    @Resource
    private BusinessInformationService businessInformationService;

//    @CrossOrigin
//    @RequestMapping(value = "getBusinessInformationListByFilter",method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
//    public Result getBusinessInformationListByFilter(@RequestParam("filterSalary") String filterSalary, @RequestParam("pageSize")Integer pageSize){
//        return ResultFactory.buildSuccessResult("测试");
//    }

//    @CrossOrigin
//    @PostMapping(value = "/enterprise/addBusinessInformation ", produces = "application/json;charset=UTF-8")
    @PostMapping(value = "enterprise/addBusinessInformation", produces = "application/json;charset=UTF-8")
    public Result addBusinessInformation (@RequestBody BusinessInformation  businessInformation, HttpServletRequest request, HttpServletResponse response) {
        if (businessInformation.geteName() == null || businessInformation.geteName() == "") {
            return ResultFactory.buildFailResult("请先完善您的工商信息，再重新添加");
        } else {
            BusinessInformation currentBusinessInformation  = businessInformationService.getBusinessInformationByEName(businessInformation.geteName());
            if (currentBusinessInformation != null) {
                return ResultFactory.buildFailResult("您已添加过相关的工商信息，请重新添加");
            } else {
                businessInformationService.addBusinessInformation (businessInformation);
                String message = String.format("成功添加。");
                return ResultFactory.buildSuccessResult(message);

            }
        }
    }
//
//    //        删除职位
//    @CrossOrigin
//    @DeleteMapping(value = "/enterprise/deleteBusinessInformation ", produces = "application/json;charset=UTF-8")
//    public Result deleteBusinessInformation (@RequestBody String jpId, HttpServletRequest request, HttpServletResponse response) {
//        System.out.println(jpId);
//
//        JSONObject idJSON = JSON.parseObject(jpId);
//        String id = idJSON.getString("jpId");
//        System.out.println(id);
//        businessInformationService.deleteBusinessInformation (id);
//        String message = String.format("成功删除。");
//        return ResultFactory.buildSuccessResult(message);
//    }
//
//    //更新职位信息
//    @CrossOrigin
//    @PostMapping(value = "/enterprise/updateBusinessInformation ", produces = "application/json;charset=UTF-8")
//    public Result updateBusinessInformation (@RequestBody BusinessInformation businessInformation, HttpServletRequest request, HttpServletResponse response) {
//        businessInformationService.updateBusinessInformation (businessInformation);
//        String message = String.format("成功修改。");
//        return ResultFactory.buildSuccessResult(message);
//    }

    //    企业用户中心：查询
    @CrossOrigin
    @GetMapping(value = "/enterprise/getBusinessInformationByEName", produces = "application/json; charset=UTF-8")
    public Result getBusinessInformationByEName(@RequestParam("eName") String eName, HttpServletRequest request, HttpServletResponse response) {
        if (eName == "" || eName == null) {
            return ResultFactory.buildFailResult("请先登录您的账号或完善您的企业信息");
        } else
        {
            BusinessInformation result = businessInformationService.getBusinessInformationByEName(eName);
            return ResultFactory.buildSuccessResult(result);
        }
    }
//        热门职位
}
