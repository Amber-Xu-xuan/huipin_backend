package com.qtu.zp.domain;

/**
 * @Author: AmberXu
 * @Date: 2019/3/31 9:43
 */
//简历
public class EducationExperience {
    private Integer rId;
    private String phone;
    private String school; // 学校名称
    private String educationBackground; // 学历
    private String major; // 所学专业
    private String studyingStartTime; // 就读时间

    private String graduationTime; // 毕业时间
    private String internship; // 实习情况（有实习、无实习）
//    工作经验表以phone为外键

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
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

    public String getStudyingStartTime() {
        return studyingStartTime;
    }

    public void setStudyingStartTime(String studyingStartTime) {
        this.studyingStartTime = studyingStartTime;
    }

    public String getGraduationTime() {
        return graduationTime;
    }

    public void setGraduationTime(String graduationTime) {
        this.graduationTime = graduationTime;
    }

    public String getInternship() {
        return internship;
    }

    public void setInternship(String internship) {
        this.internship = internship;
    }
}
