package com.qtu.zp.domain;

/**
 * @Author: AmberXu
 * @Date: 2019/3/31 10:17
 */
public class Manager {
    private Integer mid;
    private String managerName; //
    private String headImage; //
    private String jarea; //
    private String mpassword; //

    private String mcreateTime; //
    private String mphone; //

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }

    public String getJarea() {
        return jarea;
    }

    public void setJarea(String jarea) {
        this.jarea = jarea;
    }

    public String getMpassword() {
        return mpassword;
    }

    public void setMpassword(String mpassword) {
        this.mpassword = mpassword;
    }

    public String getMcreateTime() {
        return mcreateTime;
    }

    public void setMcreateTime(String mcreateTime) {
        this.mcreateTime = mcreateTime;
    }

    public String getMphone() {
        return mphone;
    }

    public void setMphone(String mphone) {
        this.mphone = mphone;
    }
}
