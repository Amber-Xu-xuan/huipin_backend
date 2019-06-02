package com.qtu.zp.controller;

import com.qtu.zp.Vo.FilterConditionVo;
import com.qtu.zp.domain.JobPosition;
import com.qtu.zp.domain.JobPositionAndEnterpriseMessage;
import com.qtu.zp.service.TouristService;
import com.qtu.zp.utils.result.Result;
import com.qtu.zp.utils.result.ResultFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: AmberXu
 * @Date: 2019/5/22 16:58
 */
@RestController
@RequestMapping(value = "/zp")
public class TouristController {

    @Resource
    TouristService touristService;
    @CrossOrigin
//    首页通过筛选条件，返回工作列表
    @GetMapping(value = "tourist/getJobListByEName")
    public Result getJobListByEName(String eName){
//        不分页
        List<JobPosition> jobPositions = touristService.getJobListByEName(eName);
        if (jobPositions.size()==0) {
            return ResultFactory.buildFailResult("没有获取到职位信息！");
        } else {
            return ResultFactory.buildSuccessResult(jobPositions);
        }
    }
}
