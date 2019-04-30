package com.qtu.zp.dao;

import com.qtu.zp.domain.Manager;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: AmberXu
 * @Date: 2019/4/20 14:21
 */
@Mapper
public interface ManagerMapper {
    //     通过电话号码获取管理员信息
    Manager findManagerByPhone(String phone);
}
