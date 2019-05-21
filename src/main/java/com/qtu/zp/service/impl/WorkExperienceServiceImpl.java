package com.qtu.zp.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qtu.zp.Vo.PageModel;
import com.qtu.zp.dao.WorkExperienceMapper;
import com.qtu.zp.domain.WorkExperience;
import com.qtu.zp.service.WorkExperienceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: AmberXu
 * @Date: 2019/5/14 0:38
 */
@Service
public class WorkExperienceServiceImpl implements WorkExperienceService {
    @Resource
    WorkExperienceMapper workExperienceMapper;
    @Override
    public List<WorkExperience> getWorkExperienceByPhone(String phone) {
        return workExperienceMapper.getWorkExperienceByPhone(phone);
    }

    @Override
    public PageModel findWorkExperienceByPhone(Integer pageCode, Integer pageSize, String phone) {
        //使用Mybatis分页插件
        PageHelper.startPage(pageCode,pageSize);

        //调用分页查询方法，其实就是查询所有数据，mybatis自动帮我们进行分页计算
        Page<WorkExperience> page = workExperienceMapper.findWorkExperienceByPhone(phone);
        return new PageModel(page.getTotal(),page.getResult());
    }

    @Override
    public PageModel findWorkExperienceByPhoneAndEName(Integer pageCode, Integer pageSize, String phone, String companyName) {
        //使用Mybatis分页插件
        PageHelper.startPage(pageCode,pageSize);

        //调用分页查询方法，其实就是查询所有数据，mybatis自动帮我们进行分页计算
        Page<WorkExperience> page = workExperienceMapper.findWorkExperienceByPhoneAndEName(phone,companyName);
        return new PageModel(page.getTotal(),page.getResult());
    }

    @Override
    public void addWorkExperience(WorkExperience workExperience) {
        workExperienceMapper.addWorkExperience(workExperience);
    }

    @Override
    public void deleteWorkExperience(String weId) {
        workExperienceMapper.deleteWorkExperience(weId);
    }

    @Override
    public void updateWorkExperience(WorkExperience workExperience) {
        workExperienceMapper.updateWorkExperience(workExperience);
    }
}