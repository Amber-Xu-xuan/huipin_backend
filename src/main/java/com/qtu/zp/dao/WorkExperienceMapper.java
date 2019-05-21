package com.qtu.zp.dao;

import com.github.pagehelper.Page;
import com.qtu.zp.domain.WorkExperience;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: AmberXu
 * @Date: 2019/5/12 0:35
 */
@Mapper
public interface WorkExperienceMapper {
    List<WorkExperience> getWorkExperienceByPhone(String phone);
    //    分页：查询全部
    Page<WorkExperience> findWorkExperienceByPhone(String phone);

    //    分页：通过公司名查询全部
    Page<WorkExperience> findWorkExperienceByPhoneAndEName(String phone,String companyName);

    //    添加
    void addWorkExperience(WorkExperience workExperience);

    //    删除
    void deleteWorkExperience(String weId);

    //    更新工作信息
    void updateWorkExperience(WorkExperience workExperience);
}
