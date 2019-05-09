package com.qtu.zp.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qtu.zp.Vo.FilterConditionVo;
import com.qtu.zp.Vo.PageModel;
import com.qtu.zp.dao.EnterpriseMapper;
import com.qtu.zp.dao.JobPositionMapper;
import com.qtu.zp.domain.JobPosition;
import com.qtu.zp.domain.JobPositionAndEnterpriseMessage;
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
    JobPositionMapper jobPositionMapper;

    @Override
    public List<JobPosition> getJobListByFilter(String salary, String experience, String education, String financing, String companyScale) {
        return jobPositionMapper.getJobListByFilter(salary,experience,education,financing,companyScale);
    }

//    同一公司下是否发布了同一个职位
    @Override
    public List<JobPosition> getJobListByENameAndJName(String eName, String jName) {
        return jobPositionMapper.getJobListByENameAndJName(eName,jName);
    }

    @Override
    public PageModel findJobListByEName(Integer pageCode, Integer pageSize, String eName) {
        //使用Mybatis分页插件
        PageHelper.startPage(pageCode,pageSize);

        //调用分页查询方法，其实就是查询所有数据，mybatis自动帮我们进行分页计算
        Page<JobPosition> page = jobPositionMapper.findJobListByEName(eName);
        return new PageModel(page.getTotal(),page.getResult());
    }

    @Override
    public void addJobPosition(JobPosition jobPosition) {
        jobPositionMapper.addJobPosition(jobPosition);
    }

    @Override
    public List<JobPositionAndEnterpriseMessage> getAllJobList() {
        return jobPositionMapper.getAllJobList();
    }

    @Override
    public List<JobPositionAndEnterpriseMessage> getJobListByFilterCondition(FilterConditionVo selectCondition) {
        return jobPositionMapper.getJobListByFilterCondition(selectCondition);
    }

    @Override
    public void deleteJobPosition(String jpId) {
        jobPositionMapper.deleteJobPosition(jpId);
    }

    @Override
    public void updateJobPosition(JobPosition jobPosition) {
        jobPositionMapper.updateJobPosition(jobPosition);
    }

    @Override
    public PageModel getJobListByENameAndJName(Integer pageCode, Integer pageSize, String eName, String jName) {
        //使用Mybatis分页插件
        PageHelper.startPage(pageCode,pageSize);

        //调用分页查询方法，其实就是查询所有数据，mybatis自动帮我们进行分页计算
        Page<JobPosition> page = jobPositionMapper.getJobListByENameAndJName(eName,jName);
        return new PageModel(page.getTotal(),page.getResult());
    }

}
