package com.qtu.zp.service;

import com.qtu.zp.Vo.PageModel;
import com.qtu.zp.Vo.SelectRecruitmentSituationVo;
import com.qtu.zp.Vo.SelectResumeConditionVo;
import com.qtu.zp.domain.EducationExperience;
import com.qtu.zp.domain.RecruitmentSituation;

import java.util.List;


/**
 * @Author: AmberXu
 * @Date: 2019/5/8 11:55
 */
public interface EducationExperienceService {
//    多条件
    List<EducationExperience> getEducationExperienceByCondition(EducationExperience educationExperience);

    //    分页
    PageModel getEducationExperienceByPhone(SelectResumeConditionVo selectResumeConditionVo);

    //    添加
    void addEducationExperience(EducationExperience educationExperience);

    //    删除
    void deleteEducationExperience(String eId);

    //    更新职位信息
    void updateEducationExperience(EducationExperience educationExperience);
}
