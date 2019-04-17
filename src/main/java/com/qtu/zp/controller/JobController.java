package com.qtu.zp.controller;

import com.qtu.zp.service.JobService;
import com.qtu.zp.utils.result.Result;
import com.qtu.zp.utils.result.ResultFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author: AmberXu
 * @Date: 2019/4/15 18:25
 */
@RestController
@RequestMapping("/api")
public class JobController {

    @Resource
    private JobService jobService;

    @CrossOrigin
    @RequestMapping(value = "getJobListByFilter",method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public Result getJobListByFilter(@RequestParam("filterSalary") String filterSalary, @RequestParam("pageSize")Integer pageSize){
        return ResultFactory.buildSuccessResult("测试");
    }
}
