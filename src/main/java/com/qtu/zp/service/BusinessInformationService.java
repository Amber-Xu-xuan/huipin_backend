package com.qtu.zp.service;

import com.qtu.zp.Vo.PageModel;
import com.qtu.zp.domain.BusinessInformation;

import java.util.List;

/**
 * @Author: AmberXu
 * @Date: 2019/5/9 8:00
 */
public interface BusinessInformationService {
    BusinessInformation getBusinessInformationByEName(String eName);

    //    获取工商信息(分页）
    PageModel findBusinessInformationByEName(Integer pageCode, Integer pageSize, String eName);

    //    添加工商信息
    void addBusinessInformation(BusinessInformation businessInformation);

    List<BusinessInformation> getAllBusinessInformation();

    //    通过筛选获取所有工商信息
//    List<BusinessInformation> getBusinessInformationByFilterCondition(BusinessInformationFilterConditionVo selectCondition);

    //    删除工商信息
    void deleteBusinessInformation(String bId);

    //    更新工商信息
    void updateBusinessInformation(BusinessInformation businessInformation);

    //    条件查询工商信息
//    PageModel getBusinessInformationByENameAndJName(Integer pageCode, Integer pageSize, String eName, String jName);

//    管理员模块：查询所有未通过验证的公司信息
    PageModel getBusinessInfoByIsVerification(Integer pageCode, Integer pageSize,String phone);
//    修改通过
    void editBusinessInfoIsVerificationByBId(String bId);
//    修改IsVerification字段，存放未通过验证的信息
    void editBusinessInfoNotifyInfoByBId(String bId,String info);
}
