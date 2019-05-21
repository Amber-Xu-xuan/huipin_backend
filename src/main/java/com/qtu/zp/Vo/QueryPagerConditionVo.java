package com.qtu.zp.Vo;

/**
 * @Author: AmberXu
 * @Date: 2019/5/15 19:21
 */
public class QueryPagerConditionVo {
    private String id;
    private Integer pageCode;
    private Integer pageSize;
    private String phone;
    private String companyName;
    private String projectName;
    private String info;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

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
}
