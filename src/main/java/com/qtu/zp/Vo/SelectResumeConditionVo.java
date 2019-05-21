package com.qtu.zp.Vo;

/**
 * @Author: AmberXu
 * @Date: 2019/5/8 13:23
 */
// 教育经历筛选、
public class SelectResumeConditionVo {
    private Integer pageCode;
    private Integer pageSize;
    private String phone;
    private String educationBackground;
    private String major;

    public Integer getPageCode() {
        return pageCode;
    }

    public void setPageCode(Integer pageCode) {
        this.pageCode = pageCode;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
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
}
