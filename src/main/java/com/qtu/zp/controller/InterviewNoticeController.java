package com.qtu.zp.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qtu.zp.Vo.PageModel;
import com.qtu.zp.domain.InterviewNotice;
import com.qtu.zp.service.InterviewNoticeService;
import com.qtu.zp.utils.result.Result;
import com.qtu.zp.utils.result.ResultFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: AmberXu
 * @Date: 2019/5/30 12:43
 */
@RestController
@RequestMapping("/zp")
public class InterviewNoticeController {
    @Resource
    private InterviewNoticeService interviewNoticeService;

    @CrossOrigin
    @PostMapping(value = "/enterprise/addInterviewNotice", produces = "application/json;charset=UTF-8")
    public Result addInterviewNotice(@RequestBody InterviewNotice interviewNotice ) {
        List<InterviewNotice> currentInterviewNotices = interviewNoticeService.getInterviewNoticeByCPhoneAndENameAndInjob(interviewNotice.getCphone(),interviewNotice.geteName(),interviewNotice.getInjob());
        if (interviewNotice.getEphone() == null || interviewNotice.getEphone() == "") {
            return ResultFactory.buildFailResult("请先登录您的账号，再重新添加");
        }else if(currentInterviewNotices.size() != 0) {
           return ResultFactory.buildFailResult("已给该用户发送面试邀请");
        }  else {
            interviewNoticeService.addInterviewNotice(interviewNotice);
            String message = String.format("成功添加。");
            return ResultFactory.buildSuccessResult(message);
        }
    }

    //删除
    @CrossOrigin
    @DeleteMapping(value = "/enterprise/deleteInterviewNotice", produces = "application/json;charset=UTF-8")
    public Result deleteInterviewNotice(@RequestBody String shId ) {
        JSONObject idJSON = JSON.parseObject(shId);
        String id = idJSON.getString("weId");
        interviewNoticeService.deleteInterviewNotice(id);
        String message = String.format("成功删除。");
        return ResultFactory.buildSuccessResult(message);
    }

    //更新
    @CrossOrigin
    @PostMapping(value = "/enterprise/updateInterviewNotice", produces = "application/json;charset=UTF-8")
    public Result updateInterviewNotice(@RequestBody InterviewNotice interviewNotice) {
        interviewNoticeService.updateInterviewNotice(interviewNotice);
        String message = String.format("成功修改。");
        return ResultFactory.buildSuccessResult(message);
    }

    //    不分页查询
    @CrossOrigin
    @PostMapping(value = "/candidate/getInterviewNoticeByPhone", produces = "application/json; charset=UTF-8")
    public Result getInterviewNoticeByPhone(@RequestBody InterviewNotice interviewNotice) {
        if (interviewNotice.getCphone() == "" || interviewNotice.getCphone() == null) {
            return ResultFactory.buildFailResult("请先登录您的账号");
        }else
        {
            List<InterviewNotice> result = interviewNoticeService.getInterviewNoticeByPhone(interviewNotice.getCphone());
            return ResultFactory.buildSuccessResult(result);
        }
    }

    //    分页查询
//    @CrossOrigin
//    @PostMapping(value = "/enterprise/getInterviewNoticePagerByPhone", produces = "application/json; charset=UTF-8")
//    public Result getInterviewNoticePageByPhone(@RequestBody QueryPagerConditionVo queryPagerConditionVo) {
//        if (queryPagerConditionVo.getEphone() == "" || queryPagerConditionVo.getEphone() == null) {
//            return ResultFactory.buildFailResult("请先登录您的账号");
//        }else
//        {
//            PageModel result= interviewNoticeService.findInterviewNoticeByPhone(queryPagerConditionVo.getPageCode(),queryPagerConditionVo.getPageSize(),queryPagerConditionVo.getEphone());
//            return ResultFactory.buildSuccessResult(result);
//        }
//    }


//    //    分页查询
//    @CrossOrigin
//    @PostMapping(value = "/enterprise/getInterviewNoticePagerByPhoneAndEName", produces = "application/json; charset=UTF-8")
//    public Result getInterviewNoticePagerByPhoneAndEName(@RequestBody QueryPagerConditionVo queryPagerConditionVo) {
//        if (queryPagerConditionVo.getEphone() == "" || queryPagerConditionVo.getEphone() == null) {
//            return ResultFactory.buildFailResult("请先登录您的账号");
//        }else
//        {
//            PageModel result= interviewNoticeService.findInterviewNoticeByPhoneAndEName(queryPagerConditionVo.getPageCode(),queryPagerConditionVo.getPageSize(),queryPagerConditionVo.getEphone(),queryPagerConditionVo.getCompanyName());
//            return ResultFactory.buildSuccessResult(result);
//        }
//    }

}
