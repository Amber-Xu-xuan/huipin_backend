package com.qtu.zp.service;

import com.qtu.zp.domain.JobPosition;

import java.util.List;

/**
 * @Author: AmberXu
 * @Date: 2019/5/22 17:06
 */
public interface TouristService {
    List<JobPosition> getJobListByEName(String eName);
}
