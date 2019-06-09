package com.qtu.zp.service.impl;

import com.qtu.zp.dao.ManagerMapper;
import com.qtu.zp.domain.Manager;
import com.qtu.zp.domain.StatisticResult;
import com.qtu.zp.service.ManagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: AmberXu
 * @Date: 2019/4/18 15:11
 */
@Service
public class ManagerServiceImpl implements ManagerService{


    @Resource
    ManagerMapper managerMapper;

    @Override
    public Manager findManagerByPhone(String phone) {
        return managerMapper.findManagerByPhone(phone);
    }

    @Override
    public List<StatisticResult> StatisticCandidateNumByMonth() {
        return managerMapper.StatisticCandidateNumByMonth();
    }

    @Override
    public List<StatisticResult> StatisticEnterpriseNumByMonth() {
        return managerMapper.StatisticEnterpriseNumByMonth();
    }

    @Override
    public void updatePassword(String mphone, String mpassword) {
        managerMapper.updatePassword(mphone,mpassword);
    }

    //    统计每个月的简历投递增量
    @Override
    public List<StatisticResult> StatisticResumeNumByMonth() {
        return managerMapper.StatisticResumeNumByMonth();
    }
}
