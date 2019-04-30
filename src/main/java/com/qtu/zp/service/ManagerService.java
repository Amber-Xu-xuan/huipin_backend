package com.qtu.zp.service;

import com.qtu.zp.domain.Manager;

import java.util.List;

/**
 * @Author: AmberXu
 * @Date: 2019/4/18 15:11
 */
public interface ManagerService {
    //     通过电话号码获取管理员信息
    Manager findManagerByPhone(String phone);
}
