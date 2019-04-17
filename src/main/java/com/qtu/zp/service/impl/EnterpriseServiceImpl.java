package com.qtu.zp.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qtu.zp.dao.EnterpriseMapper;
import com.qtu.zp.dao.JobPositionMapper;
import com.qtu.zp.domain.Enterprise;
import com.qtu.zp.domain.JobPosition;
import com.qtu.zp.model.PageModel;
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
    JobPositionMapper jobPositionMapper;

    @Override
    public List<Enterprise> getAllEnterprise() {
        return enterpriseMapper.getAllEnterprise();
    }

    @Override
    public Enterprise findEnterpriseByPhone(String ephone) {
        return enterpriseMapper.findEnterpriseByPhone(ephone);
    }

    @Override
    public PageModel findJobListByEName(Integer pageCode,Integer pageSize,String eName) {
        //使用Mybatis分页插件
        PageHelper.startPage(pageCode,pageSize);

        //调用分页查询方法，其实就是查询所有数据，mybatis自动帮我们进行分页计算
        Page<JobPosition> page = jobPositionMapper.findJobListByEName(eName);
        return new PageModel(page.getTotal(),page.getResult());
    }

}
