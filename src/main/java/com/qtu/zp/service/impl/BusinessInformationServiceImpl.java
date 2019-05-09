package com.qtu.zp.service.impl;

import com.qtu.zp.Vo.PageModel;
import com.qtu.zp.dao.BusinessInformationMapper;
import com.qtu.zp.domain.BusinessInformation;
import com.qtu.zp.service.BusinessInformationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: AmberXu
 * @Date: 2019/5/9 8:01
 */
@Service
public class BusinessInformationServiceImpl implements BusinessInformationService {

    @Resource
    BusinessInformationMapper businessInformationMapper;
    @Override
    public BusinessInformation getBusinessInformationByEName(String eName) {
        return businessInformationMapper.findBusinessInformationByEName(eName);
    }

    @Override
    public PageModel findBusinessInformationByEName(Integer pageCode, Integer pageSize, String eName) {
        return null;
    }

    @Override
    public void addBusinessInformation(BusinessInformation jobPosition) {
        businessInformationMapper.addBusinessInformation(jobPosition);
    }

    @Override
    public List<BusinessInformation> getAllBusinessInformation() {
        return null;
    }

    @Override
    public void deleteBusinessInformation(String bId) {

    }

    @Override
    public void updateBusinessInformation(BusinessInformation businessInformation) {

    }
}
