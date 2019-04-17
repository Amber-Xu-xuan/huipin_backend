package com.qtu.zp.service.impl;

import com.qtu.zp.dao.EnterpriseMapper;
import com.qtu.zp.dao.JobPositionMapper;
import com.qtu.zp.domain.JobPosition;
import com.qtu.zp.service.JobService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: AmberXu
 * @Date: 2019/4/15 18:28
 */
@Service
public class JobServiceImpl implements JobService{


    @Resource
    JobPositionMapper jobPostionMapper;

    @Override
    public List<JobPosition> getJobListByFilter(String salary, String experience, String education, String financing, String companyScale) {
        return jobPostionMapper.getJobListByFilter(salary,experience,education,financing,companyScale);
    }
}
