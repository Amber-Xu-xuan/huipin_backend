package com.qtu.zp.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qtu.zp.domain.BusinessInformation;
import com.qtu.zp.domain.JobPosition;
import com.qtu.zp.service.JobService;
import com.qtu.zp.utils.result.Result;
import com.qtu.zp.utils.result.ResultFactory;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSON;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author: AmberXu
 * @Date: 2019/4/15 18:25
 */
@RestController
@RequestMapping("/zp")
public class JobController {

    @Resource
    private JobService jobService;

//    @CrossOrigin
//    @RequestMapping(value = "getJobListByFilter",method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
//    public Result getJobListByFilter(@RequestParam("filterSalary") String filterSalary, @RequestParam("pageSize")Integer pageSize){
//        return ResultFactory.buildSuccessResult("测试");
//    }

    @CrossOrigin
    //    添加职位信息
    @PostMapping(value = "/enterprise/addJobPosition", produces = "application/json;charset=UTF-8")
    public Result addJobPosition(@RequestBody JobPosition jobPositon, HttpServletRequest request, HttpServletResponse response) {
        if (jobPositon.geteName() == null || jobPositon.geteName() == "") {
            return ResultFactory.buildFailResult("请先完善您的企业信息，再重新添加");
        } else {
            List<JobPosition> currentJobPosition = jobService.getJobListByENameAndJName(jobPositon.geteName(), jobPositon.getjName());
            if (currentJobPosition == null) {
                jobService.addJobPosition(jobPositon);
                String message = String.format("成功添加。");
                return ResultFactory.buildSuccessResult(message);
            } else {
                return ResultFactory.buildFailResult("您已添加过相关的职位信息，请重新添加");
            }
        }
    }

    //        删除职位
    @CrossOrigin
    @DeleteMapping(value = "/enterprise/deleteJobPosition", produces = "application/json;charset=UTF-8")
    public Result deleteJobPosition (@RequestBody String jpId, HttpServletRequest request, HttpServletResponse response) {
        System.out.println(jpId);

        JSONObject idJSON = JSON.parseObject(jpId);
        String id = idJSON.getString("jpId");
        System.out.println(id);
                jobService.deleteJobPosition(id);
                String message = String.format("成功删除。");
                return ResultFactory.buildSuccessResult(message);
    }

    @CrossOrigin
    @PostMapping(value = "/enterprise/updateJobPosition", produces = "application/json;charset=UTF-8")
    public Result updateJobPosition (@RequestBody JobPosition jobPosition, HttpServletRequest request, HttpServletResponse response) {
        jobService.updateJobPosition(jobPosition);
        String message = String.format("成功修改。");
        return ResultFactory.buildSuccessResult(message);
    }

        //        热门职位
}
