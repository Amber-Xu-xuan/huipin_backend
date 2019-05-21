package com.qtu.zp.dao;

import com.github.pagehelper.Page;
import com.qtu.zp.domain.ProjectExperience;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: AmberXu
 * @Date: 2019/5/12 0:34
 */
@Mapper
public interface ProjectExperienceMapper {
    List<ProjectExperience> getProjectExperienceByPhone(String phone);
    //    分页：查询全部
    Page<ProjectExperience> findProjectExperienceByPhone(String phone);

    //    分页：条件查询
    Page<ProjectExperience> findProjectExperienceByProjectNameAndPhone(String phone,String projectName);
    //    添加
    void addProjectExperience(ProjectExperience projectExperience);

    //    删除
    void deleteProjectExperience(String weId);

    //    更新工作信息
    void updateProjectExperience(ProjectExperience projectExperience);
}
