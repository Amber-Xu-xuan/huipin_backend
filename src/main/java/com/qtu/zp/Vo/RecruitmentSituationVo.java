package com.qtu.zp.Vo;

import java.util.List;

/**
 * @Author: AmberXu
 * @Date: 2019/5/12 18:02
 */
public class RecruitmentSituationVo {
    private String phone;
    private String educationBackground;
    private String major;
    private String graduationTime;
    private String havaWorkExperience;
    private List<Integer> weId;
    private String havaProjectExperience;
    private List<Integer> peId;
    private String socialHomePage;

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
