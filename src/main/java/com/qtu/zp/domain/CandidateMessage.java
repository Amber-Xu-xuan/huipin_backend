package com.qtu.zp.domain;

/**
 * @Author amberXu
 * @Description //保存保存求职者的个人信息
 * @Date 2019/3/11  10:43
 * @Param
 **/
public class CandidateMessage {
    private String candidateName;
    private String headImage;
    private String introduce;
    private String birthday;
    private String sex;
    private String residenceAddress;
    private String nowAddress;
    private String hobby;
    private String phone;
    private String email;
    private String rId;
    private String findJobStatus;
    private String jiId;

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getResidenceAddress() {
        return residenceAddress;
    }

    public void setResidenceAddress(String residenceAddress) {
        this.residenceAddress = residenceAddress;
    }

    public String getNowAddress() {
        return nowAddress;
    }

    public void setNowAddress(String nowAddress) {
        this.nowAddress = nowAddress;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getrId() {
        return rId;
    }

    public void setrId(String rId) {
        this.rId = rId;
    }

    public String getFindJobStatus() {
        return findJobStatus;
    }

    public void setFindJobStatus(String findJobStatus) {
        this.findJobStatus = findJobStatus;
    }

    public String getJiId() {
        return jiId;
    }

    public void setJiId(String jiId) {
        this.jiId = jiId;
    }

    @Override
    public String toString() {
        return "CandidateMessage{" +
                ", candidateName='" + candidateName + '\'' +
                ", headImage='" + headImage + '\'' +
                ", introduce='" + introduce + '\'' +
                ", birthday='" + birthday + '\'' +
                ", sex='" + sex + '\'' +
                ", residenceAddress='" + residenceAddress + '\'' +
                ", nowAddress='" + nowAddress + '\'' +
                ", hobby='" + hobby + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", rId='" + rId + '\'' +
                ", findJobStatus='" + findJobStatus + '\'' +
                ", jiId='" + jiId + '\'' +
                '}';
    }
}
