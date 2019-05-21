package com.qtu.zp.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qtu.zp.Vo.PageModel;
import com.qtu.zp.Vo.SelectRecruitmentSituationVo;
import com.qtu.zp.Vo.SelectResumeConditionVo;
import com.qtu.zp.domain.EducationExperience;
import com.qtu.zp.domain.RecruitmentSituation;
import com.qtu.zp.service.EducationExperienceService;
import com.qtu.zp.utils.result.Result;
import com.qtu.zp.utils.result.ResultFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author: AmberXu
 * @Date: 2019/5/8 11:39
 */
@RestController
@RequestMapping("/zp")
public class EducationExperienceController {
    @Resource
    private EducationExperienceService educationExperienceService;

    @CrossOrigin
    @PostMapping(value = "/candidate/addEducationExperience", produces = "application/json;charset=UTF-8")
    public Result addEducationExperience(@RequestBody EducationExperience educationExperience, HttpServletRequest request, HttpServletResponse response) {
        if (educationExperience.getPhone() == null || educationExperience.getPhone() == "") {
            return ResultFactory.buildFailResult("请先完善您的个人信息，再重新添加");
        } else {
//            educationExperience.getPhone(), educationExperience.getEducationBackground(),educationExperience.getMajor()
            List<EducationExperience> currentEducationExperience = educationExperienceService.getEducationExperienceByCondition(educationExperience);
            if (currentEducationExperience.size() == 0) {
                educationExperienceService.addEducationExperience(educationExperience);
                String message = String.format("成功添加。");
                return ResultFactory.buildSuccessResult(message);
            } else {
                return ResultFactory.buildFailResult("您已添加过相关的岗位信息，请重新添加");
            }
        }
    }

    @CrossOrigin
    @DeleteMapping(value = "/candidate/deleteEducationExperience", produces = "application/json;charset=UTF-8")
    public Result deleteEducationExperience(@RequestBody String eId, HttpServletRequest request, HttpServletResponse response) {
        JSONObject idJSON = JSON.parseObject(eId);
        String id = idJSON.getString("eId");
        educationExperienceService.deleteEducationExperience(id);
        String message = String.format("成功删除。");
        return ResultFactory.buildSuccessResult(message);
    }

    @CrossOrigin
    @PostMapping(value = "/candidate/updateEducationExperience", produces = "application/json;charset=UTF-8")
    public Result updateEducationExperience(@RequestBody EducationExperience educationExperience, HttpServletRequest request, HttpServletResponse response) {
        educationExperienceService.updateEducationExperience(educationExperience);
        String message = String.format("成功修改。");
        return ResultFactory.buildSuccessResult(message);
    }

    @CrossOrigin
    @PostMapping(value = "/candidate/getEducationExperienceByPhone", produces = "application/json; charset=UTF-8")
    public Result getEducationExperienceByPhone(@RequestBody SelectResumeConditionVo selectResumeConditionVo, HttpServletRequest request, HttpServletResponse response) {
        String phone = selectResumeConditionVo.getPhone();
        if (phone == "" || phone == null) {
            return ResultFactory.buildFailResult("请先登录您的账号");
        } else {
            PageModel result = educationExperienceService.getEducationExperienceByPhone(selectResumeConditionVo);
            return ResultFactory.buildSuccessResult(result);
        }
    }




}
