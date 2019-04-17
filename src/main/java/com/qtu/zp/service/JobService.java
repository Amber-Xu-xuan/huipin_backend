package com.qtu.zp.service;

import com.qtu.zp.domain.JobPosition;

import java.util.List;

/**
 * @Author: AmberXu
 * @Date: 2019/4/15 18:28
 */
public interface JobService {
    List<JobPosition> getJobListByFilter(String salary, String Experience, String Education, String Financing, String CompanyScale);
}
