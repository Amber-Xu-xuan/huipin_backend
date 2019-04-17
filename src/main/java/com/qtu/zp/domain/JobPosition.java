package com.qtu.zp.domain;

/**
 * @Author: AmberXu
 * @Date: 2019/4/1 14:44
 */
public class JobPosition {
    private Integer jpId;
    private String jName; //
    private String salary; //
    private String jarea; //
    private String experienceDuration; //

    private String education; //
    private String obligation; //岗位职责
    private String qualification; //任职资格
    private String workAddress; //
    private String jType; //职位性质
    private String jPublishDate; //发布时间
    private String stopRecruitDate; //停止招聘时间
    private String eName;

    private EnterpriseMessage enterpriseMessage;

    public EnterpriseMessage getEnterpriseMessage() {
        return enterpriseMessage;
    }

    public void setEnterpriseMessage(EnterpriseMessage enterpriseMessage) {
        this.enterpriseMessage = enterpriseMessage;
    }

    public Integer getJpId() {
        return jpId;
    }

    public void setJpId(Integer jpId) {
        this.jpId = jpId;
    }

    public String getjName() {
        return jName;
    }

    public void setjName(String jName) {
        this.jName = jName;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getJarea() {
        return jarea;
    }

    public void setJarea(String jarea) {
        this.jarea = jarea;
    }

    public String getExperienceDuration() {
        return experienceDuration;
    }

    public void setExperienceDuration(String experienceDuration) {
        this.experienceDuration = experienceDuration;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getObligation() {
        return obligation;
    }

    public void setObligation(String obligation) {
        this.obligation = obligation;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress;
    }

    public String getjType() {
        return jType;
    }

    public void setjType(String jType) {
        this.jType = jType;
    }

    public String getjPublishDate() {
        return jPublishDate;
    }

    public void setjPublishDate(String jPublishDate) {
        this.jPublishDate = jPublishDate;
    }

    public String getStopRecruitDate() {
        return stopRecruitDate;
    }

    public void setStopRecruitDate(String stopRecruitDate) {
        this.stopRecruitDate = stopRecruitDate;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    @Override
    public String toString() {
        return "JobPosition{" +
                "jpId=" + jpId +
                ", jName='" + jName + '\'' +
                ", salary='" + salary + '\'' +
                ", jarea='" + jarea + '\'' +
                ", experienceDuration='" + experienceDuration + '\'' +
                ", education='" + education + '\'' +
                ", obligation='" + obligation + '\'' +
                ", qualification='" + qualification + '\'' +
                ", workAddress='" + workAddress + '\'' +
                ", jType='" + jType + '\'' +
                ", jPublishDate='" + jPublishDate + '\'' +
                ", stopRecruitDate='" + stopRecruitDate + '\'' +
                ", eName='" + eName + '\'' +
                ", enterpriseMessage=" + enterpriseMessage +
                '}';
    }
}
