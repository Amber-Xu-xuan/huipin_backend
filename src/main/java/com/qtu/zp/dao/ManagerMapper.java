package com.qtu.zp.dao;

import com.qtu.zp.domain.Manager;
import com.qtu.zp.domain.StatisticResult;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: AmberXu
 * @Date: 2019/4/20 14:21
 */
@Mapper
public interface ManagerMapper {
    //     通过电话号码获取管理员信息
    Manager findManagerByPhone(String phone);
    List<StatisticResult> StatisticCandidateNumByMonth();
    List<StatisticResult> StatisticEnterpriseNumByMonth();
    void updatePassword(String mphone,String mpassword);
    List<StatisticResult> StatisticResumeNumByMonth();
}
