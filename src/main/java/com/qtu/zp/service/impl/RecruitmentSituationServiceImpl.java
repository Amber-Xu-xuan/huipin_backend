package com.qtu.zp.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qtu.zp.Vo.AllMessageAboutCandidateVo;
import com.qtu.zp.Vo.PageModel;
import com.qtu.zp.Vo.RecruitmentSituationVo;
import com.qtu.zp.Vo.SelectRecruitmentSituationVo;
import com.qtu.zp.dao.*;
import com.qtu.zp.domain.*;
import com.qtu.zp.service.RecruitmentSituationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: AmberXu
 * @Date: 2019/5/11 18:17
 */
@Service
public class RecruitmentSituationServiceImpl implements RecruitmentSituationService {
    @Resource
    RecruitmentSituationMapper recruitmentSituationMapper;

    @Resource
    ProjectExperienceMapper projectExperienceMapper;

    @Resource
    WorkExperienceMapper workExperienceMapper;

    @Resource
    EducationExperienceMapper educationExperienceMapper;

    @Resource
    SocialHomepageMapper socialHomepageMapper;

    @Resource
    CandidateMapper candidateMapper;


    @Override
    public void addRecruitmentSituation(RecruitmentSituation recruitmentSituation) {
        recruitmentSituationMapper.addRecruitmentSituation(recruitmentSituation);
    }

    @Override
    public PageModel selectRecruitmentSituationByeNameAndjName(SelectRecruitmentSituationVo selectRecruitmentSituationVo) {
        //使用Mybatis分页插件
        PageHelper.startPage(selectRecruitmentSituationVo.getPageCode(), selectRecruitmentSituationVo.getPageSize());

        //调用分页查询方法，其实就是查询所有数据，mybatis自动帮我们进行分页计算
        Page<RecruitmentSituation> page = recruitmentSituationMapper.selectRecruitmentSituationByeNameAndjName(selectRecruitmentSituationVo.geteName(), selectRecruitmentSituationVo.getjName());
        return new PageModel(page.getTotal(), page.getResult());
    }

    @Override
    public List<String> selectPhoneByeNameAndjName(SelectRecruitmentSituationVo selectRecruitmentSituationVo) {
        return recruitmentSituationMapper.selectPhoneByeNameAndjName(selectRecruitmentSituationVo.geteName(), selectRecruitmentSituationVo.getjName());
    }

    @Override
    public AllMessageAboutCandidateVo selectAllMessageAboutCandidateByphone(String phone) {
//        获取求职信息

        List<WorkExperience> workExperienceList = workExperienceMapper.getWorkExperienceByPhone(phone);
        List<ProjectExperience> projectExperienceList = projectExperienceMapper.getProjectExperienceByPhone(phone);
        List<EducationExperience> educationExperienceList = educationExperienceMapper.getEducationExperienceByPhone(phone);
        List<SocialHomepage> socialHomepages = socialHomepageMapper.getSocialHomepageByPhone(phone);

        AllMessageAboutCandidateVo candidateVo = new AllMessageAboutCandidateVo();
        candidateVo.setPhone(phone);

        if (!workExperienceList.isEmpty()) {
            candidateVo.setWorkExperience(workExperienceList);
            candidateVo.setWorkExperience(true);
        }
        if (!projectExperienceList.isEmpty()) {
            candidateVo.setProjectExperience(projectExperienceList);
            candidateVo.setProjectExperience(true);
        }
        if (!educationExperienceList.isEmpty()) {
            candidateVo.setEducationExperience(educationExperienceList);
        }
        if (!socialHomepages.isEmpty()) {
            candidateVo.setSocialHomepage(socialHomepages);
        }
        return candidateVo;
    }

    @Override
    public RecruitmentSituationVo selectRecruitmentSituationAboutCandidateByphone(String phone) {
        //        获取求职信息

        List<CandidateMessage> candidateMessage = candidateMapper.getCandidateMessageByPhone(phone);
        List<WorkExperience> workExperienceList = workExperienceMapper.getWorkExperienceByPhone(phone);
        List<ProjectExperience> projectExperienceList = projectExperienceMapper.getProjectExperienceByPhone(phone);
        List<EducationExperience> educationExperienceList = educationExperienceMapper.getEducationExperienceByPhone(phone);
        List<SocialHomepage> socialHomepages = socialHomepageMapper.getSocialHomepageByPhone(phone);

        RecruitmentSituationVo candidateVo = new RecruitmentSituationVo();
        candidateVo.setPhone(phone);
        candidateVo.setCandidateMessage(candidateMessage.get(0));
        candidateVo.setWorkExperienceList(workExperienceList);
        candidateVo.setProjectExperienceList(projectExperienceList);
        candidateVo.setEducationExperienceList(educationExperienceList);
        candidateVo.setSocialHomepageList(socialHomepages);


        List<Integer> weIDData = new ArrayList<Integer>();
        List<Integer> peIDData = new ArrayList<Integer>();
        if (!workExperienceList.isEmpty()) {
            Integer size = workExperienceList.size();
            candidateVo.setHavaWorkExperience("有" + size + "条记录");
            for (WorkExperience we : workExperienceList) {
                weIDData.add(we.getWeId());
            }
            candidateVo.setWeId(weIDData);
        } else {
            candidateVo.setHavaWorkExperience("无工作经验");
        }
        if (!projectExperienceList.isEmpty()) {
            Integer size = projectExperienceList.size();
            candidateVo.setHavaProjectExperience("有" + size + "条记录");
            for (ProjectExperience pe : projectExperienceList) {
                peIDData.add(pe.getPeId());
            }
            candidateVo.setPeId(peIDData);
        } else {
            candidateVo.setHavaProjectExperience("无项目经验");
        }
        if (!educationExperienceList.isEmpty()) {
//            StringBuffer educations = new StringBuffer();
            Map<String, String> educations = new HashMap<String, String>();
            for (EducationExperience ee : educationExperienceList) {
                educations.put(ee.getEducationBackground(), ee.getMajor());
            }
            String educ = educations.toString();
            if (educ == null || educ == "") {
                candidateVo.setEducationBackground("该用户没有填写学历信息");
            } else if (educ.contains("博士")) {
                candidateVo.setEducationBackground("博士");
                candidateVo.setMajor(educations.get("博士"));
            } else if (educ.contains("硕士")) {
                candidateVo.setEducationBackground("硕士");
                candidateVo.setMajor(educations.get("硕士"));
            } else if (educ.contains("本科")) {
                candidateVo.setEducationBackground("本科");
                candidateVo.setMajor(educations.get("本科"));
            } else if (educ.contains("中专")) {
                candidateVo.setEducationBackground("中专");
                candidateVo.setMajor(educations.get("中专"));
            } else if (educ.contains("高中")) {
                candidateVo.setEducationBackground("高中");
            } else {
                candidateVo.setEducationBackground("初中及以下");
            }

        }
        if (!socialHomepages.isEmpty()) {
            StringBuffer socialPageBuffer = new StringBuffer();
            for (SocialHomepage sh : socialHomepages) {
                socialPageBuffer.append(sh.getHomePage() + "|");
            }
            String homePage = socialPageBuffer.toString();
            candidateVo.setSocialHomePage(homePage);
        }
        return candidateVo;
    }

    @Override
    public List<JobPosition> getJobPositionByDiliveryResumeAndPhone(String phone) {
        List<JobPosition> j = recruitmentSituationMapper.getJobPositionByRecruitmentSituationAndPhone(phone);
        return j;
    }
}
