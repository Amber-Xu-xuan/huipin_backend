package com.qtu.zp.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qtu.zp.Vo.PageModel;
import com.qtu.zp.dao.ProjectExperienceMapper;
import com.qtu.zp.domain.ProjectExperience;
import com.qtu.zp.service.ProjectExperienceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: AmberXu
 * @Date: 2019/5/14 1:03
 */
@Service
public class ProjectExperienceServiceImpl implements ProjectExperienceService {

    @Resource
    ProjectExperienceMapper projectExperienceMapper;
    @Override
    public List<ProjectExperience> getProjectExperienceByPhone(String phone) {
        return projectExperienceMapper.getProjectExperienceByPhone(phone);
    }

    @Override
    public PageModel findProjectExperienceByPhone(Integer pageCode, Integer pageSize, String phone) {
        //使用Mybatis分页插件
        PageHelper.startPage(pageCode,pageSize);

        //调用分页查询方法，其实就是查询所有数据，mybatis自动帮我们进行分页计算
        Page<ProjectExperience> page = projectExperienceMapper.findProjectExperienceByPhone(phone);
        return new PageModel(page.getTotal(),page.getResult());
    }

    @Override
    public PageModel findProjectExperienceByProjectNameAndPhone(Integer pageCode, Integer pageSize, String phone, String projectName) {
        //使用Mybatis分页插件
        PageHelper.startPage(pageCode,pageSize);

        //调用分页查询方法，其实就是查询所有数据，mybatis自动帮我们进行分页计算
        Page<ProjectExperience> page = projectExperienceMapper.findProjectExperienceByProjectNameAndPhone(phone,projectName);
        return new PageModel(page.getTotal(),page.getResult());
    }

    @Override
    public void addProjectExperience(ProjectExperience projectExperience) {
        projectExperienceMapper.addProjectExperience(projectExperience);
    }

    @Override
    public void deleteProjectExperience(String peId) {
        projectExperienceMapper.deleteProjectExperience(peId);
    }

    @Override
    public void updateProjectExperience(ProjectExperience projectExperience) {
        projectExperienceMapper.updateProjectExperience(projectExperience);
    }
}
