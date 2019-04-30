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

    //    获取岗位信息(分页）
    PageModel findJobListByEName(Integer pageCode, Integer pageSize, String eName);

    void registerEnterprise(Enterprise enterprise, EnterpriseMessage enterpriseMessage);

    //    通过公司名获取企业信息
    List<EnterpriseMessage> getEnterpriseByEName(String eName);

//    获取工商信息
    BusinessInformation getBusinessInformation(String eName);
}
