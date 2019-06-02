package com.qtu.zp.service.impl;

import com.qtu.zp.dao.JobPositionMapper;
import com.qtu.zp.domain.JobPosition;
import com.qtu.zp.service.TouristService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.swing.text.Position;
import java.util.List;

/**
 * @Author: AmberXu
 * @Date: 2019/5/22 17:06
 */
@Service
public class TouristServiceImpl implements TouristService{
    @Resource
    JobPositionMapper jobPositionMapper;
    @Override
    public List<JobPosition> getJobListByEName(String eName) {
        List<JobPosition> jobs = jobPositionMapper.findJobListByEName(eName);
        return jobs;
    }
}
