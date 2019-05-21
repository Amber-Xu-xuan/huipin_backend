package com.qtu.zp.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qtu.zp.Vo.PageModel;
import com.qtu.zp.Vo.QueryPagerConditionVo;
import com.qtu.zp.domain.WorkExperience;
import com.qtu.zp.service.WorkExperienceService;
import com.qtu.zp.utils.result.Result;
import com.qtu.zp.utils.result.ResultFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author: AmberXu
 * @Date: 2019/5/14 0:29
 */
@RestController
@RequestMapping("/zp")
public class WorkExperienceController {
    @Resource
    private WorkExperienceService workExperienceService;

    @CrossOrigin
    @PostMapping(value = "/candidate/addWorkExperience", produces = "application/json;charset=UTF-8")
    public Result addWorkExperience(@RequestBody WorkExperience workExperience, HttpServletRequest request, HttpServletResponse response) {
        if (workExperience.getPhone() == null || workExperience.getPhone() == "") {
            return ResultFactory.buildFailResult("请先登录您的账号，再重新添加");
        } else {
            workExperienceService.addWorkExperience(workExperience);
            String message = String.format("成功添加。");
            return ResultFactory.buildSuccessResult(message);
        }
    }

    //删除
    @CrossOrigin
    @DeleteMapping(value = "/candidate/deleteWorkExperience", produces = "application/json;charset=UTF-8")
    public Result deleteWorkExperience(@RequestBody String shId, HttpServletRequest request, HttpServletResponse response) {
        JSONObject idJSON = JSON.parseObject(shId);
        String id = idJSON.getString("weId");
        workExperienceService.deleteWorkExperience(id);
        String message = String.format("成功删除。");
        return ResultFactory.buildSuccessResult(message);
    }

    //更新
    @CrossOrigin
    @PostMapping(value = "/candidate/updateWorkExperience", produces = "application/json;charset=UTF-8")
    public Result updateWorkExperience(@RequestBody WorkExperience workExperience) {
        workExperienceService.updateWorkExperience(workExperience);
        String message = String.format("成功修改。");
        return ResultFactory.buildSuccessResult(message);
    }
    
    //    不分页查询
    @CrossOrigin
    @PostMapping(value = "/candidate/getWorkExperienceByPhone", produces = "application/json; charset=UTF-8")
    public Result getWorkExperienceByPhone(@RequestBody String phone) {
        if (phone == "" || phone == null) {
            return ResultFactory.buildFailResult("请先登录您的账号");
        }else
        {
            List<WorkExperience> result = workExperienceService.getWorkExperienceByPhone(phone);
            return ResultFactory.buildSuccessResult(result);
        }
    }

    //    分页查询
    @CrossOrigin
    @PostMapping(value = "/candidate/getWorkExperiencePagerByPhone", produces = "application/json; charset=UTF-8")
    public Result getWorkExperiencePageByPhone(@RequestBody QueryPagerConditionVo queryPagerConditionVo) {
        if (queryPagerConditionVo.getPhone() == "" || queryPagerConditionVo.getPhone() == null) {
            return ResultFactory.buildFailResult("请先登录您的账号");
        }else
        {
            PageModel result= workExperienceService.findWorkExperienceByPhone(queryPagerConditionVo.getPageCode(),queryPagerConditionVo.getPageSize(),queryPagerConditionVo.getPhone());
            return ResultFactory.buildSuccessResult(result);
        }
    }


    //    分页查询:通过登录求职者的电话和工作的公司名称查询
    @CrossOrigin
    @PostMapping(value = "/candidate/getWorkExperiencePagerByPhoneAndEName", produces = "application/json; charset=UTF-8")
    public Result getWorkExperiencePagerByPhoneAndEName(@RequestBody QueryPagerConditionVo queryPagerConditionVo) {
        if (queryPagerConditionVo.getPhone() == "" || queryPagerConditionVo.getPhone() == null) {
            return ResultFactory.buildFailResult("请先登录您的账号");
        }else
        {
            PageModel result= workExperienceService.findWorkExperienceByPhoneAndEName(queryPagerConditionVo.getPageCode(),queryPagerConditionVo.getPageSize(),queryPagerConditionVo.getPhone(),queryPagerConditionVo.getCompanyName());
            return ResultFactory.buildSuccessResult(result);
        }
    }

}
