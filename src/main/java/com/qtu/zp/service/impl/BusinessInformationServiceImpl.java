package com.qtu.zp.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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
    public void addBusinessInformation(BusinessInformation businessInformation) {
        businessInformationMapper.addBusinessInformation(businessInformation);
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
        businessInformationMapper.updateBusinessInformation(businessInformation);
    }

    //    管理员模块：查询所有未通过验证的公司信息
    @Override
    public PageModel getBusinessInfoByIsVerification(Integer pageCode, Integer pageSize, String phone) {
        //使用Mybatis分页插件
        PageHelper.startPage(pageCode,pageSize);

        //调用分页查询方法，其实就是查询所有数据，mybatis自动帮我们进行分页计算
        Page<BusinessInformation> page = businessInformationMapper.getBusinessInfoByIsVerification(phone);
        return new PageModel(page.getTotal(),page.getResult());
    }

    @Override
    public void editBusinessInfoIsVerificationByBId(String bId) {
        businessInformationMapper.editBusinessInfoIsVerificationByBId(bId);
    }

    @Override
    public void editBusinessInfoNotifyInfoByBId(String bId, String info) {
        businessInformationMapper.editBusinessInfoNotifyInfoByBId(bId,"未通过验证，" + info);
    }

}
