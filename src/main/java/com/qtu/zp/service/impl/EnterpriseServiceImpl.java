package com.qtu.zp.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qtu.zp.dao.BusinessInformationMapper;
import com.qtu.zp.dao.EnterpriseMapper;
import com.qtu.zp.dao.JobPositionMapper;
import com.qtu.zp.domain.BusinessInformation;
import com.qtu.zp.domain.Enterprise;
import com.qtu.zp.domain.EnterpriseMessage;
import com.qtu.zp.domain.JobPosition;
import com.qtu.zp.Vo.PageModel;
import com.qtu.zp.service.EnterpriseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: AmberXu
 * @Date: 2019/4/11 21:53
 */
@Service
public class EnterpriseServiceImpl implements EnterpriseService {

    @Resource
    EnterpriseMapper enterpriseMapper;




    @Resource
    BusinessInformationMapper businessInformationMapper;

    @Override
    public List<Enterprise> getAllEnterprise() {
        return enterpriseMapper.getAllEnterprise();
    }

    @Override
    public Enterprise findEnterpriseByPhone(String ephone) {
        return enterpriseMapper.findEnterpriseByPhone(ephone);
    }

    @Override
    public void registerEnterprise(Enterprise enterprise, EnterpriseMessage enterpriseMessage) {
        enterpriseMapper.registerEnterprise(enterprise);
        enterpriseMapper.registerEnterpriseMessage(enterpriseMessage);
        System.out.println(enterpriseMessage.toString());
    }

    @Override
    public List<EnterpriseMessage> getEnterpriseByEName(String eName) {
        return enterpriseMapper.getEnterpriseByEName(eName);
    }

    @Override
    public BusinessInformation getBusinessInformation(String eName) {
        return businessInformationMapper.findBusinessInformationByEName(eName);
    }

}
