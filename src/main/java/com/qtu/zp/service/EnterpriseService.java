package com.qtu.zp.service;

import com.qtu.zp.domain.BusinessInformation;
import com.qtu.zp.domain.Enterprise;
import com.qtu.zp.domain.EnterpriseMessage;
import com.qtu.zp.Vo.PageModel;

import java.util.List;

/**
 * @Author: AmberXu
 * @Date: 2019/4/11 21:52
 */
public interface EnterpriseService {
    List<Enterprise> getAllEnterprise();

    //     通过电话号码获取用户信息
    Enterprise findEnterpriseByPhone(String phone);

    List<EnterpriseMessage> getEnterpriseMessageByEmphone(String emphone);


    void updatePassword(String ephone,String epassword);

    void registerEnterprise(Enterprise enterprise, EnterpriseMessage enterpriseMessage);

    //    通过公司名获取企业信息
    List<EnterpriseMessage> getEnterpriseByEName(String eName);

//    获取工商信息
    BusinessInformation getBusinessInformation(String eName);

//    更新Enterprise
    void updateEnterprise(Enterprise enterprise);
//    更新EnterpriseMessage
    void updateEnterpriseMessage(EnterpriseMessage enterpriseMessage);
}
