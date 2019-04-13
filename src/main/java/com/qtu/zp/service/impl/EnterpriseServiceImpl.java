package com.qtu.zp.service.impl;

import com.qtu.zp.dao.EnterpriseMapper;
import com.qtu.zp.dao.JobPositionMapper;
import com.qtu.zp.domain.Enterprise;
import com.qtu.zp.domain.JobPosition;
import com.qtu.zp.service.EnterpriseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: AmberXu
 * @Date: 2019/4/11 21:53
 */
@Service
public class EnterpriseServiceImpl implements EnterpriseService {

    @Resource
    EnterpriseMapper enterpriseMapper;


    @Resource
    JobPositionMapper jobPositionMapper;

    @Override
    public List<Enterprise> getAllEnterprise() {
        return enterpriseMapper.getAllEnterprise();
    }

    @Override
    public Enterprise findEnterpriseByPhone(String ephone) {
        return enterpriseMapper.findEnterpriseByPhone(ephone);
    }

    @Override
    public List<JobPosition> findJobListByEName(String eName) {
        return jobPositionMapper.findJobListByEName(eName);
    }

}
