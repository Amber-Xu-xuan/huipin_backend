package com.qtu.zp.domain;

/**
 * @Author: AmberXu
 * @Date: 2019/5/11 17:49
 */
public class RecruitmentSituation {
    private Integer rsId;
    private String jName;
    private String eName;
    private String  phone;
    private String date;
    private String status;

    public Integer getRsId() {
        return rsId;
    }

    public void setRsId(Integer rsId) {
        this.rsId = rsId;
    }

    public String getjName() {
        return jName;
    }

    public void setjName(String jName) {
        this.jName = jName;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
