package com.qtu.zp.dao;

import com.qtu.zp.domain.Enterprise;
import com.qtu.zp.domain.JobPosition;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: AmberXu
 * @Date: 2019/4/11 21:49
 */
@Mapper
public interface EnterpriseMapper {
    List<Enterprise> getAllEnterprise();
    //     通过电话号码获取用户信息
    Enterprise findEnterpriseByPhone(String ephone);


}
