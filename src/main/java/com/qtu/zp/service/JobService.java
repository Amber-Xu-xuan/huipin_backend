package com.qtu.zp.service;

import com.qtu.zp.Vo.FilterConditionVo;
import com.qtu.zp.Vo.PageModel;
import com.qtu.zp.domain.JobPosition;
import com.qtu.zp.domain.JobPositionAndEnterpriseMessage;

import java.util.List;

/**
 * @Author: AmberXu
 * @Date: 2019/4/15 18:28
 */
public interface JobService {
    List<JobPosition> getJobListByFilter(String salary, String Experience, String Education, String Financing, String CompanyScale);

    List<JobPosition> getJobListByENameAndJName(String eName, String JName);

    //    获取岗位信息(分页）
    PageModel findJobListByEName(Integer pageCode, Integer pageSize, String eName);

    //    添加职位信息
    void addJobPosition(JobPosition jobPosition);

    List<JobPositionAndEnterpriseMessage> getAllJobList();

    //    通过筛选获取所有岗位信息
    List<JobPositionAndEnterpriseMessage> getJobListByFilterCondition(FilterConditionVo selectCondition);

    //    删除职位信息
    void deleteJobPosition(String jpId);

    //    更新职位信息
    void updateJobPosition(JobPosition jobPosition);

    //    条件查询职位信息
    PageModel getJobListByENameAndJName(Integer pageCode, Integer pageSize, String eName, String jName);

    //    热门职位
    List<JobPositionAndEnterpriseMessage> selectHotJobPosition();
}
