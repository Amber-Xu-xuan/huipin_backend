package com.qtu.zp.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qtu.zp.Vo.PageModel;
import com.qtu.zp.Vo.QueryPagerConditionVo;
import com.qtu.zp.domain.ProjectExperience;
import com.qtu.zp.service.ProjectExperienceService;
import com.qtu.zp.utils.result.Result;
import com.qtu.zp.utils.result.ResultFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: AmberXu
 * @Date: 2019/5/14 0:57
 */
@RestController
@RequestMapping("/zp")
public class ProjectExperienceController {
    @Resource
    private ProjectExperienceService projectExperienceService;

    @CrossOrigin
    @PostMapping(value = "/candidate/addProjectExperience", produces = "application/json;charset=UTF-8")
    public Result addProjectExperience(@RequestBody ProjectExperience workExperience) {
        if (workExperience.getPhone() == null || workExperience.getPhone() == "") {
            return ResultFactory.buildFailResult("请先登录您的账号，再重新添加");
        } else {
            projectExperienceService.addProjectExperience(workExperience);
            String message = String.format("成功添加。");
            return ResultFactory.buildSuccessResult(message);
        }
    }

    //删除
    @CrossOrigin
    @DeleteMapping(value = "/candidate/deleteProjectExperience", produces = "application/json;charset=UTF-8")
    public Result deleteProjectExperience(@RequestBody String peId) {
        JSONObject idJSON = JSON.parseObject(peId);
        String id = idJSON.getString("peId");
        projectExperienceService.deleteProjectExperience(id);
        String message = String.format("成功删除。");
        return ResultFactory.buildSuccessResult(message);
    }

    //更新
    @CrossOrigin
    @PostMapping(value = "/candidate/updateProjectExperience", produces = "application/json;charset=UTF-8")
    public Result updateProjectExperience(@RequestBody ProjectExperience workExperience) {
        projectExperienceService.updateProjectExperience(workExperience);
        String message = String.format("成功修改。");
        return ResultFactory.buildSuccessResult(message);
    }

    //    不分页查询
    @CrossOrigin
    @PostMapping(value = "candidate/getProjectExperienceByPhone", produces = "application/json; charset=UTF-8")
    public Result getProjectExperienceByPhone(@RequestBody String phone) {
        if (phone == "" || phone == null) {
            return ResultFactory.buildFailResult("请先登录您的账号");
        }else
        {
            List<ProjectExperience> result = projectExperienceService.getProjectExperienceByPhone(phone);
            return ResultFactory.buildSuccessResult(result);
        }
    }

    //    分页查询
    @CrossOrigin
    @PostMapping(value = "candidate/getProjectExperienceListByPhone", produces = "application/json; charset=UTF-8")
    public Result getProjectExperienceListByPhone(@RequestBody QueryPagerConditionVo queryPagerConditionVo) {
        if (queryPagerConditionVo.getPhone() == "" || queryPagerConditionVo.getPhone() == null) {
            return ResultFactory.buildFailResult("请先登录您的账号");
        }else
        {
            PageModel result= projectExperienceService.findProjectExperienceByPhone(queryPagerConditionVo.getPageCode(),queryPagerConditionVo.getPageSize(),queryPagerConditionVo.getPhone());
            return ResultFactory.buildSuccessResult(result);
        }
    }

    //    分页条件查询
    @CrossOrigin
    @PostMapping(value = "candidate/getProjectExperienceListByProjectNameAndPhone", produces = "application/json; charset=UTF-8")
    public Result getProjectExperienceListByProjectNameAndPhone(@RequestBody QueryPagerConditionVo queryPagerConditionVo) {
        if (queryPagerConditionVo.getPhone() == "" || queryPagerConditionVo.getPhone() == null) {
            return ResultFactory.buildFailResult("请先登录您的账号");
        }else
        {
            PageModel result= projectExperienceService.findProjectExperienceByProjectNameAndPhone(queryPagerConditionVo.getPageCode(),queryPagerConditionVo.getPageSize(),queryPagerConditionVo.getPhone(),queryPagerConditionVo.getProjectName());
            return ResultFactory.buildSuccessResult(result);
        }
    }
}
