package com.qtu.zp.Vo;

/**
 * @Author: AmberXu
 * @Date: 2019/4/27 22:50
 */
public class FilterConditionVo {
    private String filterSalary;
    private String filterExperience;
    private String filterEducation;
    private String filterFinancing;
    private String filterCompanyScale;

    public String getFilterSalary() {
        return filterSalary;
    }

    public void setFilterSalary(String filterSalary) {
        this.filterSalary = filterSalary;
    }

    public String getFilterExperience() {
        return filterExperience;
    }

    public void setFilterExperience(String filterExperience) {
        this.filterExperience = filterExperience;
    }

    public String getFilterEducation() {
        return filterEducation;
    }

    public void setFilterEducation(String filterEducation) {
        this.filterEducation = filterEducation;
    }

    public String getFilterFinancing() {
        return filterFinancing;
    }

    public void setFilterFinancing(String filterFinancing) {
        this.filterFinancing = filterFinancing;
    }

    public String getFilterCompanyScale() {
        return filterCompanyScale;
    }

    public void setFilterCompanyScale(String filterCompanyScale) {
        this.filterCompanyScale = filterCompanyScale;
    }

    @Override
    public String toString() {
        return "FilterConditionVo{" +
                "filterSalary='" + filterSalary + '\'' +
                ", filterExperience='" + filterExperience + '\'' +
                ", filterEducation='" + filterEducation + '\'' +
                ", filterFinancing='" + filterFinancing + '\'' +
                ", filterCompanyScale='" + filterCompanyScale + '\'' +
                '}';
    }
}
