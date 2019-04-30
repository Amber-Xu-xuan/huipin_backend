package com.qtu.zp.dao;

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
}
