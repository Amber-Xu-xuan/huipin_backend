package com.qtu.zp.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qtu.zp.Vo.PageModel;
import com.qtu.zp.Vo.SelectRecruitmentSituationVo;
import com.qtu.zp.Vo.SelectResumeConditionVo;
import com.qtu.zp.dao.EducationExperienceMapper;
import com.qtu.zp.domain.EducationExperience;
import com.qtu.zp.domain.RecruitmentSituation;
import com.qtu.zp.service.EducationExperienceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: AmberXu
 * @Date: 2019/5/8 11:55
 */
@Service
public class EducationExperienceServiceImpl implements EducationExperienceService {
    @Resource
    EducationExperienceMapper educationExperienceMapper;
    @Override
    public List<EducationExperience> getEducationExperienceByCondition(EducationExperience educationExperience) {

        return educationExperienceMapper.getEducationExperienceByCondition( educationExperience.getPhone(), educationExperience.getEducationBackground(),educationExperience.getMajor());
    }

//    分页
    @Override
    public PageModel getEducationExperienceByPhone(SelectResumeConditionVo selectResumeConditionVo) {
        //使用Mybatis分页插件
        PageHelper.startPage(selectResumeConditionVo.getPageCode(),selectResumeConditionVo.getPageSize());

        Page<EducationExperience> educationExperience = educationExperienceMapper.findEducationExperienceByPhone( selectResumeConditionVo.getPhone());
        return  new PageModel(educationExperience.getTotal(),educationExperience.getResult());
    }

    @Override
    public void addEducationExperience(EducationExperience educationExperience) {
        educationExperienceMapper.addEducationExperience(educationExperience);
    }

    @Override
    public void deleteEducationExperience(String eId) {
        educationExperienceMapper.deleteEducationExperience(eId);
    }

    @Override
    public void updateEducationExperience(EducationExperience educationExperience) {
        educationExperienceMapper.updateEducationExperience(educationExperience);
    }


}
