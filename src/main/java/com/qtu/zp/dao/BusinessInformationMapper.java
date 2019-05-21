package com.qtu.zp.dao;

import com.github.pagehelper.Page;
import com.qtu.zp.domain.BusinessInformation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Author: AmberXu
 * @Date: 2019/4/30 16:41
 */
@Mapper
public interface BusinessInformationMapper {
    //    获取工商信息
    BusinessInformation findBusinessInformationByEName(String eName);
    void addBusinessInformation(BusinessInformation businessInformation);
    void updateBusinessInformation(BusinessInformation businessInformation);
    //    管理员模块：查询所有未通过验证的公司信息
    Page<BusinessInformation> getBusinessInfoByIsVerification(String phone);
//    管理员审核成功
    void editBusinessInfoIsVerificationByBId(String bId);

    void editBusinessInfoNotifyInfoByBId(String bId,String info);
}
