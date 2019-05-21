package com.qtu.zp.dao;

import com.github.pagehelper.Page;
import com.qtu.zp.Vo.SelectRecruitmentSituationVo;
import com.qtu.zp.domain.EducationExperience;
import com.qtu.zp.domain.RecruitmentSituation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: AmberXu
 * @Date: 2019/5/8 11:54
 */
@Mapper
public interface EducationExperienceMapper {

    List<EducationExperience> getEducationExperienceByCondition(String phone, String educationBackground, String major);
//    查询全部
    Page<EducationExperience> findEducationExperienceByPhone(String phone);

    List<EducationExperience> getEducationExperienceByPhone(String phone);

    //    添加
    void addEducationExperience(EducationExperience educationExperience);

    //    删除
    void deleteEducationExperience(String eId);

    //    更新职位信息
    void updateEducationExperience(EducationExperience educationExperience);
}
