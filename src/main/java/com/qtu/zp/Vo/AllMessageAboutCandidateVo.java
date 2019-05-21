package com.qtu.zp.Vo;

import com.github.pagehelper.Page;
import com.qtu.zp.domain.EducationExperience;
import com.qtu.zp.domain.SocialHomepage;
import com.qtu.zp.domain.ProjectExperience;
import com.qtu.zp.domain.WorkExperience;

import java.util.List;

/**
 * @Author: AmberXu
 * @Date: 2019/5/12 0:19
 */
public class AllMessageAboutCandidateVo {
    private String phone;
//    private String educationBackground; //education_experience
//    private String major;
//    private String graduationTime;
    private List<WorkExperience> workExperience;
    private List<ProjectExperience> projectExperience;
    private List<EducationExperience> educationExperience;
    private List<SocialHomepage> SocialHomepage;
    private Boolean isWorkExperience;
//    private List<String> weId;

    private Boolean isProjectExperience;
//    private List<String> peId;


    @Override
    public String toString() {
        return "AllMessageAboutCandidateVo{" +
                "phone='" + phone + '\'' +
                ", workExperience=" + workExperience +
                ", projectExperience=" + projectExperience +
                ", educationExperience=" + educationExperience +
                ", SocialHomepage=" + SocialHomepage +
                ", isWorkExperience=" + isWorkExperience +
                ", isProjectExperience=" + isProjectExperience +
                '}';
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<WorkExperience> getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(Boolean workExperience) {
        isWorkExperience = workExperience;
    }

    public void setWorkExperience(List<WorkExperience> workExperience) {
        this.workExperience = workExperience;
    }

    public List<ProjectExperience> getProjectExperience() {
        return projectExperience;
    }

    public void setProjectExperience(Boolean projectExperience) {
        isProjectExperience = projectExperience;
    }

    public void setProjectExperience(List<ProjectExperience> projectExperience) {
        this.projectExperience = projectExperience;
    }

    public List<EducationExperience> getEducationExperience() {
        return educationExperience;
    }

    public void setEducationExperience(List<EducationExperience> educationExperience) {
        this.educationExperience = educationExperience;
    }

    public List<com.qtu.zp.domain.SocialHomepage> getSocialHomepage() {
        return SocialHomepage;
    }

    public void setSocialHomepage(List<com.qtu.zp.domain.SocialHomepage> socialHomepage) {
        SocialHomepage = socialHomepage;
    }
}
