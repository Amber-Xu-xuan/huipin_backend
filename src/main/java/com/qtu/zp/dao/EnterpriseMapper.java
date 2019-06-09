package com.qtu.zp.dao;

import com.qtu.zp.domain.Enterprise;
import com.qtu.zp.domain.EnterpriseMessage;
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

    void registerEnterprise(Enterprise enterprise);
    void registerEnterpriseMessage(EnterpriseMessage enterpriseMessage);

    List<EnterpriseMessage> getEnterpriseByEName(String eName);

    List<EnterpriseMessage> getEnterpriseMessageByEmphone(String emphone);

    void updatePassword(String ephone,String epassword);

    //    更新Enterprise
    void updateEnterprise(Enterprise enterprise);
    //    更新EnterpriseMessage
    void updateEnterpriseMessage(EnterpriseMessage enterpriseMessage);
}
