package com.qtu.zp.service;

import com.qtu.zp.Vo.PageModel;
import com.qtu.zp.domain.ProjectExperience;

import java.util.List;

/**
 * @Author: AmberXu
 * @Date: 2019/5/14 1:00
 */
public interface ProjectExperienceService {
    //    分页：find 不分页：get
    List<ProjectExperience> getProjectExperienceByPhone(String phone);

    //    获取岗位信息(分页）
    PageModel findProjectExperienceByPhone(Integer pageCode, Integer pageSize, String phone);

//    获取岗位信息(分页）
    PageModel findProjectExperienceByProjectNameAndPhone(Integer pageCode, Integer pageSize, String phone,String projectName);

    //    添加信息
    void addProjectExperience(ProjectExperience projectExperience);

//    List<ProjectExperience> getAllProjectExperience();

    //    删除职位信息
    void deleteProjectExperience(String peId);

    //    更新职位信息
    void updateProjectExperience(ProjectExperience projectExperience);
}
