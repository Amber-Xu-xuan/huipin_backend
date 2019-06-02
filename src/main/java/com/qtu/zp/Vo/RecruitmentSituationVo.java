package com.qtu.zp.Vo;

import com.qtu.zp.domain.*;

import java.util.List;

/**
 * @Author: AmberXu
 * @Date: 2019/5/12 18:02
 */
public class RecruitmentSituationVo {
    private CandidateMessage candidateMessage;
    private String phone;
    private String educationBackground;
    private String major;
    private String graduationTime;
    private String havaWorkExperience;

    private List<WorkExperience> workExperienceList;
    private List<ProjectExperience> projectExperienceList;
    private List<EducationExperience> educationExperienceList;
    private List<SocialHomepage> socialHomepageList;

    private List<Integer> weId;
    private String havaProjectExperience;
    private List<Integer> peId;
    private String socialHomePage;

    public List<SocialHomepage> getSocialHomepageList() {
        return socialHomepageList;
    }

    public void setSocialHomepageList(List<SocialHomepage> socialHomepageList) {
        this.socialHomepageList = socialHomepageList;
    }

    public List<WorkExperience> getWorkExperienceList() {
        return workExperienceList;
    }

    public void setWorkExperienceList(List<WorkExperience> workExperienceList) {
        this.workExperienceList = workExperienceList;
    }

    public List<ProjectExperience> getProjectExperienceList() {
        return projectExperienceList;
    }

    public void setProjectExperienceList(List<ProjectExperience> projectExperienceList) {
        this.projectExperienceList = projectExperienceList;
    }

    public List<EducationExperience> getEducationExperienceList() {
        return educationExperienceList;
    }

    public void setEducationExperienceList(List<EducationExperience> educationExperienceList) {
        this.educationExperienceList = educationExperienceList;
    }

    public CandidateMessage getCandidateMessage() {
        return candidateMessage;
    }

    public void setCandidateMessage(CandidateMessage candidateMessage) {
        this.candidateMessage = candidateMessage;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEducationBackground() {
        return educationBackground;
    }

    public void setEducationBackground(String educationBackground) {
        this.educationBackground = educationBackground;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGraduationTime() {
        return graduationTime;
    }

    public void setGraduationTime(String graduationTime) {
        this.graduationTime = graduationTime;
    }

    public String getHavaWorkExperience() {
        return havaWorkExperience;
    }

    public void setHavaWorkExperience(String havaWorkExperience) {
        this.havaWorkExperience = havaWorkExperience;
    }

    public String getHavaProjectExperience() {
        return havaProjectExperience;
    }

    public void setHavaProjectExperience(String havaProjectExperience) {
        this.havaProjectExperience = havaProjectExperience;
    }


    public String getSocialHomePage() {
        return socialHomePage;
    }

    public void setSocialHomePage(String socialHomePage) {
        this.socialHomePage = socialHomePage;
    }

    public List<Integer> getWeId() {
        return weId;
    }

    public void setWeId(List<Integer> weId) {
        this.weId = weId;
    }

    public List<Integer> getPeId() {
        return peId;
    }

    public void setPeId(List<Integer> peId) {
        this.peId = peId;
    }
}
