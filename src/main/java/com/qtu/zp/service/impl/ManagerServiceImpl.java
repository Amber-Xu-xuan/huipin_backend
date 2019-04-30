package com.qtu.zp.service.impl;

import com.qtu.zp.dao.ManagerMapper;
import com.qtu.zp.domain.Manager;
import com.qtu.zp.service.ManagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
        return null;
    }
}
