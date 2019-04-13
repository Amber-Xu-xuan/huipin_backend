package com.qtu.zp.dao;

import com.qtu.zp.domain.JobPosition;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: AmberXu
 * @Date: 2019/4/13 20:08
 */
@Mapper
public interface JobPositionMapper {
    List<JobPosition> findJobListByEName(String eName);
    List<JobPosition> getAllJobList();
}
