package com.qtu.zp.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qtu.zp.Vo.PageModel;
import com.qtu.zp.Vo.RecruitmentSituationVo;
import com.qtu.zp.Vo.SelectResumeConditionVo;
import com.qtu.zp.dao.ResumeMapper;
import com.qtu.zp.domain.Resume;
import com.qtu.zp.service.ResumeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: AmberXu
 * @Date: 2019/5/8 11:55
 */
@Service
public class ResumeServiceImpl implements ResumeService{
    @Resource
    ResumeMapper resumeMapper;
    @Override
    public List<Resume> getResumeByCondition(Resume resume) {

        return resumeMapper.getResumeByCondition( resume.getPhone(), resume.getEducationBackground(),resume.getMajor());
    }

//    分页
    @Override
    public PageModel getResumePageByCondition(SelectResumeConditionVo selectResumeConditionVo) {
        //使用Mybatis分页插件
        PageHelper.startPage(selectResumeConditionVo.getPageCode(),selectResumeConditionVo.getPageSize());

        Page<Resume> resume = resumeMapper.getResumeByCondition( selectResumeConditionVo.getPhone(), selectResumeConditionVo.getEducationBackground(),selectResumeConditionVo.getMajor());
        return  new PageModel(resume.getTotal(),resume.getResult());
    }

    @Override
    public void addResume(Resume resume) {
        resumeMapper.addResume(resume);
    }

    @Override
    public void deleteResume(String rId) {
        resumeMapper.deleteResume(rId);
    }

    @Override
    public void updateResume(Resume resume) {
        resumeMapper.updateResume(resume);
    }

    @Override
    public void addRecruitmentSituation(RecruitmentSituationVo recruitmentSituationVo) {
        resumeMapper.addRecruitmentSituation(recruitmentSituationVo);
    }
}
