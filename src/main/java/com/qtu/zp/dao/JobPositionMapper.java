package com.qtu.zp.dao;

import com.github.pagehelper.Page;
import com.qtu.zp.Vo.FilterConditionVo;
import com.qtu.zp.Vo.PageModel;
import com.qtu.zp.domain.Candidate;
import com.qtu.zp.domain.CandidateMessage;
import com.qtu.zp.domain.JobPosition;
import com.qtu.zp.domain.JobPositionAndEnterpriseMessage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: AmberXu
 * @Date: 2019/4/13 20:08
 */
@Mapper
public interface JobPositionMapper {
    //    分页：企业用户查询所发布的所有职位信息
    Page<JobPosition> findJobListByEName(String eName);

    List<JobPositionAndEnterpriseMessage> getAllJobList();

    //    通过筛选获取所有岗位信息
    List<JobPositionAndEnterpriseMessage> getJobListByFilterCondition(FilterConditionVo selectCondition);

    //    添加职位信息
    void addJobPosition(JobPosition jobPosition);

    List<JobPosition> getJobListByFilter(String salary, String experience, String education, String financing, String companyScale);

    //    删除职位信息
    void deleteJobPosition(String jpId);

    //    更新职位信息
    void updateJobPosition(JobPosition jobPosition);

//    // 企业用户是否发布了同一个职位
//    List<JobPosition> getJobListByENameAndJName(String eName, String jName);

    //    条件查询职位信息
    Page<JobPosition> getJobListByENameAndJName(String eName, String jName);

//    添加收藏数
    void addcollectNumByJpId(String jpId);

//    热门职位
    List<JobPositionAndEnterpriseMessage> selectHotJobPosition();
}
