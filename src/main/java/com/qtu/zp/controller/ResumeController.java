package com.qtu.zp.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qtu.zp.Vo.PageModel;
import com.qtu.zp.Vo.RecruitmentSituationVo;
import com.qtu.zp.Vo.SelectResumeConditionVo;
import com.qtu.zp.domain.Resume;
import com.qtu.zp.service.ResumeService;
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
public class ResumeController {
    @Resource
    private ResumeService resumeService;

    @CrossOrigin
    @PostMapping(value = "/enterprise/addResume", produces = "application/json;charset=UTF-8")
    public Result addResume(@RequestBody Resume resume, HttpServletRequest request, HttpServletResponse response) {
        if (resume.getPhone() == null || resume.getPhone() == "") {
            return ResultFactory.buildFailResult("请先完善您的个人信息，再重新添加");
        } else {
//            resume.getPhone(), resume.getEducationBackground(),resume.getMajor()
            List<Resume> currentResume = resumeService.getResumeByCondition(resume);
            if (currentResume == null) {
                resumeService.addResume(resume);
                String message = String.format("成功添加。");
                return ResultFactory.buildSuccessResult(message);
            } else {
                return ResultFactory.buildFailResult("您已添加过相关的岗位信息，请重新添加");
            }
        }
    }

    @CrossOrigin
    @DeleteMapping(value = "/enterprise/deleteResume", produces = "application/json;charset=UTF-8")
    public Result deleteResume(@RequestBody String rId, HttpServletRequest request, HttpServletResponse response) {
        System.out.println(rId);

        JSONObject idJSON = JSON.parseObject(rId);
        String id = idJSON.getString("rId");
        System.out.println(id);
        resumeService.deleteResume(id);
        String message = String.format("成功删除。");
        return ResultFactory.buildSuccessResult(message);
    }

    @CrossOrigin
    @PostMapping(value = "/enterprise/updateResume", produces = "application/json;charset=UTF-8")
    public Result updateResume(@RequestBody Resume resume, HttpServletRequest request, HttpServletResponse response) {
        resumeService.updateResume(resume);
        String message = String.format("成功修改。");
        return ResultFactory.buildSuccessResult(message);
    }

    @CrossOrigin
    @PostMapping(value = "/enterprise/getResumeListByCondition", produces = "application/json; charset=UTF-8")
    public Result getResumeListByCondition(@RequestBody SelectResumeConditionVo selectResumeConditionVo, HttpServletRequest request, HttpServletResponse response) {
        String phone = selectResumeConditionVo.getPhone();
        if (phone == "" || phone == null) {
            return ResultFactory.buildFailResult("请先登录您的账号或完善您的信息");
        } else {
            PageModel result = resumeService.getResumePageByCondition(selectResumeConditionVo);
            return ResultFactory.buildSuccessResult(result);
        }
    }

    //    投递简历
    @CrossOrigin
    @PostMapping(value = "/candidate/sendingResume", produces = "application/json; charset=UTF-8")
    public Result sendingResume(@RequestBody RecruitmentSituationVo recruitmentSituationVo, HttpServletRequest request, HttpServletResponse response) {
        String phone = recruitmentSituationVo.getPhone();
        if (phone == "" || phone == null) {
            return ResultFactory.buildFailResult("请先登录您的账号或完善您的信息");
        } else {
            resumeService.addRecruitmentSituation(recruitmentSituationVo);
            String message = String.format("成功添加。");
            return ResultFactory.buildSuccessResult(message);
        }
    }


}
