package com.qtu.zp.domain;

/**
 * @Author: AmberXu
 * @Date: 2019/3/31 9:43
 */
public class EnterpriseMessage {
    private Integer emid;
    private String emphone; //手机号
    private String emName; //公司名称  外键
    private String emheadImage; //公司图标
    private String emintroduce; // 简介
    private String emstablishmentDate; //创立日期
    private String emaddress; //公司地址
    private String ememail; //电子邮件
    private String emofficialWebsite; //公司官网
    private String enterpriceStatus; //公司运营状态
    private String emFinancing; // 融资情况

    private String emScaleList; // 公司规模
//    private String businessScope; //经营类型
//    private String hiringJobType; //招聘岗位类型
//    private String jpId; // 招聘岗位

//    private String emnum; //公司总人数


    public Integer getEmid() {
        return emid;
    }

    public void setEmid(Integer emid) {
        this.emid = emid;
    }

    public String getEmName() {
        return emName;
    }

    public void setEmName(String emName) {
        this.emName = emName;
    }

    public String getEmheadImage() {
        return emheadImage;
    }

    public void setEmheadImage(String emheadImage) {
        this.emheadImage = emheadImage;
    }

    public String getEmintroduce() {
        return emintroduce;
    }

    public void setEmintroduce(String emintroduce) {
        this.emintroduce = emintroduce;
    }

    public String getEmstablishmentDate() {
        return emstablishmentDate;
    }

    public void setEmstablishmentDate(String emstablishmentDate) {
        this.emstablishmentDate = emstablishmentDate;
    }

    public String getEmaddress() {
        return emaddress;
    }

    public void setEmaddress(String emaddress) {
        this.emaddress = emaddress;
    }

    public String getEmphone() {
        return emphone;
    }

    public void setEmphone(String emphone) {
        this.emphone = emphone;
    }

    public String getEmemail() {
        return ememail;
    }

    public void setEmemail(String ememail) {
        this.ememail = ememail;
    }

    public String getEmofficialWebsite() {
        return emofficialWebsite;
    }

    public void setEmofficialWebsite(String emofficialWebsite) {
        this.emofficialWebsite = emofficialWebsite;
    }

//    public String getBusinessScope() {
//        return businessScope;
//    }
//
//    public void setBusinessScope(String businessScope) {
//        this.businessScope = businessScope;
//    }

    public String getEnterpriceStatus() {
        return enterpriceStatus;
    }

    public void setEnterpriceStatus(String enterpriceStatus) {
        this.enterpriceStatus = enterpriceStatus;
    }

    public String getEmFinancing() {
        return emFinancing;
    }

    public void setEmFinancing(String emFinancing) {
        this.emFinancing = emFinancing;
    }

    public String getEmScaleList() {
        return emScaleList;
    }

    public void setEmScaleList(String emScaleList) {
        this.emScaleList = emScaleList;
    }

}
