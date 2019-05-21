package com.qtu.zp.Vo;

/**
 * @Author: AmberXu
 * @Date: 2019/5/9 2:09
 */
public class SelectRecruitmentSituationVo {

    private Integer pageCode;
    private Integer pageSize;
    private String eName;
    private String jName;

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

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String getjName() {
        return jName;
    }

    public void setjName(String jName) {
        this.jName = jName;
    }
}
