package com.qtu.zp.dao;

import com.github.pagehelper.Page;
import com.qtu.zp.domain.JobPosition;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: AmberXu
 * @Date: 2019/4/13 20:08
 */
@Mapper
public interface JobPositionMapper {
    Page<JobPosition> findJobListByEName(String eName);
    List<JobPosition> getAllJobList();
    List<JobPosition> getJobListByFilter(String salary, String experience, String education, String financing, String companyScale);
}
