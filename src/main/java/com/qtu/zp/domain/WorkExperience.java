package com.qtu.zp.domain;

/**
 * @Author: AmberXu
 * @Date: 2019/3/31 10:16
 */
public class WorkExperience {
    private Integer weId;
    private String companyName; //
    private String industryInvolved; //
    private String jobTitle ; //
    private String workingStartTime; //
    private String workingEndTime; //
    private String phone; //

    private String jobDescription; //
    private String salary; //

    public Integer getWeId() {
        return weId;
    }

    public void setWeId(Integer weId) {
        this.weId = weId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getIndustryInvolved() {
        return industryInvolved;
    }

    public void setIndustryInvolved(String industryInvolved) {
        this.industryInvolved = industryInvolved;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getWorkingStartTime() {
        return workingStartTime;
    }

    public void setWorkingStartTime(String workingStartTime) {
        this.workingStartTime = workingStartTime;
    }

    public String getWorkingEndTime() {
        return workingEndTime;
    }

    public void setWorkingEndTime(String workingEndTime) {
        this.workingEndTime = workingEndTime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
