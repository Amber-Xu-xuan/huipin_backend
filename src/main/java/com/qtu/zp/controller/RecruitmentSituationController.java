package com.qtu.zp.controller;

import com.qtu.zp.Vo.*;
import com.qtu.zp.domain.JobPosition;
import com.qtu.zp.domain.RecruitmentSituation;
import com.qtu.zp.service.RecruitmentSituationService;
import com.qtu.zp.utils.result.Result;
import com.qtu.zp.utils.result.ResultFactory;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: AmberXu
 * @Date: 2019/5/11 18:13
 */
@Api(value = "招聘情况", tags = "招聘情况")
@RestController
@RequestMapping(value = "/zp")
public class RecruitmentSituationController {
    @Resource
    private RecruitmentSituationService recruitmentSituationService;

    //    投递简历
    @CrossOrigin
    @PostMapping(value = "/candidate/sendingResume", produces = "application/json; charset=UTF-8")
    public Result sendingResume(@RequestBody RecruitmentSituation recruitmentSituation, HttpServletRequest request, HttpServletResponse response) {
        String phone = recruitmentSituation.getPhone();
        if (phone == "" || phone == null) {
            return ResultFactory.buildFailResult("请先登录您的账号或完善您的信息");
        } else {
            recruitmentSituationService.addRecruitmentSituation(recruitmentSituation);
            String message = String.format("成功添加。");
            return ResultFactory.buildSuccessResult(message);
        }
    }

    // 通过公司名称和职位名称查询对应岗位的招聘情况表
    @CrossOrigin
    @PostMapping(value = "/enterprise/selectRecruitmentSituationByeNameAndjName", produces = "application/json; charset=UTF-8")
    public Result selectRecruitmentSituationByeNameAndjName(@RequestBody SelectRecruitmentSituationVo selectRecruitmentSituationVo, HttpServletRequest request, HttpServletResponse response) {
        String eName = selectRecruitmentSituationVo.geteName();
        String jName = selectRecruitmentSituationVo.getjName();
        if (jName == "" || jName == null || eName == "" || eName == null) {
            return ResultFactory.buildFailResult("请先登录您的账号或联系管理员");
        } else {
//            PageModel result = recruitmentSituationService.selectRecruitmentSituationByeNameAndjName(selectRecruitmentSituationVo);
            List<String> result = recruitmentSituationService.selectPhoneByeNameAndjName(selectRecruitmentSituationVo);
            List<RecruitmentSituationVo> candidateResume = new ArrayList<RecruitmentSituationVo>(); //=null只是在栈中有一个引用但并没有分配内存空间，会报空指针异常
//            List<AllMessageAboutCandidateVo> candidateResume  =new ArrayList<AllMessageAboutCandidateVo>(); //=null只是在栈中有一个引用但并没有分配内存空间，会报空指针异常
            for (String phone : result) {
                RecruitmentSituationVo allMessageAboutCandidateVo = recruitmentSituationService.selectRecruitmentSituationAboutCandidateByphone(phone);
                if (allMessageAboutCandidateVo == null) {
                    String info = "无法用户数据";
                    return ResultFactory.buildFailResult(info);
                } else {
                    candidateResume.add(allMessageAboutCandidateVo);

                }
            }
            return ResultFactory.buildSuccessResult(candidateResume);
//            return ResultFactory.buildSuccessResult(result);
        }
    }

    //    登录的求职者在投递箱获取投递简历历史candidate
    @CrossOrigin
    @PostMapping(value = "/candidate/getJobPositionByDiliveryResume", produces = "application/json; charset=UTF-8")
    public Result getJobPositionByDiliveryResume(@RequestBody QueryPagerConditionVo condition) {
        if (condition.getPhone() == "" || condition.getPhone() == null ) {
            return ResultFactory.buildFailResult("请先登录您的账号或联系管理员");
        } else {
            List<JobPosition> result = recruitmentSituationService.getJobPositionByDiliveryResumeAndPhone(condition.getPhone());
            return ResultFactory.buildSuccessResult(result);
        }
    }

}
