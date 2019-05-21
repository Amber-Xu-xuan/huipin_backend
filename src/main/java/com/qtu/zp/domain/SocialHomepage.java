package com.qtu.zp.domain;

/**
 * @Author: AmberXu
 * @Date: 2019/5/12 14:51
 */
public class SocialHomepage {
    //    social_homepage
    private Integer shId;
    private String homePage;
    private String phone;
    private String platform;

    public Integer getShId() {
        return shId;
    }

    public void setShId(Integer shId) {
        this.shId = shId;
    }

    public String getHomePage() {
        return homePage;
    }

    public void setHomePage(String homePage) {
        this.homePage = homePage;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }
}
