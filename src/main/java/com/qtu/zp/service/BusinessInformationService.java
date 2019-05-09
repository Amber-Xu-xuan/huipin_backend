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
    void addBusinessInformation(BusinessInformation jobPosition);

    List<BusinessInformation> getAllBusinessInformation();

    //    通过筛选获取所有工商信息
//    List<BusinessInformation> getBusinessInformationByFilterCondition(BusinessInformationFilterConditionVo selectCondition);

    //    删除工商信息
    void deleteBusinessInformation(String bId);

    //    更新工商信息
    void updateBusinessInformation(BusinessInformation businessInformation);

    //    条件查询工商信息
//    PageModel getBusinessInformationByENameAndJName(Integer pageCode, Integer pageSize, String eName, String jName);
}
