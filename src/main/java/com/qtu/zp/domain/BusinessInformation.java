package com.qtu.zp.domain;

import java.sql.Date;

/**
 * @Author: AmberXu
 * @Date: 2019/4/30 13:13
 */
public class BusinessInformation {
    private Integer bId;

    private String eName;
    private String ePhone;
    private String eFullName;
    private String legalRepresentative;
    private String registeredCapital;
    private String establishmentTime;
    private String enterprisesType;
    private String managementState;
    private String registeredAddress;
    private String unifiedCreditCode;
    private String businessScope;
    private String updateTime;
    private String isVerification;
    private String tianYanCha;

    public String getePhone() {
        return ePhone;
    }

    public void setePhone(String ePhone) {
        this.ePhone = ePhone;
    }

    public String getEstablishmentTime() {
        return establishmentTime;
    }

    public void setEstablishmentTime(String establishmentTime) {
        this.establishmentTime = establishmentTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String geteFullName() {
        return eFullName;
    }

    public void seteFullName(String eFullName) {
        this.eFullName = eFullName;
    }

    public String getTianYanCha() {
        return tianYanCha;
    }

    public void setTianYanCha(String tianYanCha) {
        this.tianYanCha = tianYanCha;
    }

    public Integer getbId() {
        return bId;
    }

    public void setbId(Integer bId) {
        this.bId = bId;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String getLegalRepresentative() {
        return legalRepresentative;
    }

    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative;
    }

    public String getRegisteredCapital() {
        return registeredCapital;
    }

    public void setRegisteredCapital(String registeredCapital) {
        this.registeredCapital = registeredCapital;
    }

    public String getEnterprisesType() {
        return enterprisesType;
    }

    public void setEnterprisesType(String enterprisesType) {
        this.enterprisesType = enterprisesType;
    }

    public String getManagementState() {
        return managementState;
    }

    public void setManagementState(String managementState) {
        this.managementState = managementState;
    }

    public String getRegisteredAddress() {
        return registeredAddress;
    }

    public void setRegisteredAddress(String registeredAddress) {
        this.registeredAddress = registeredAddress;
    }

    public String getUnifiedCreditCode() {
        return unifiedCreditCode;
    }

    public void setUnifiedCreditCode(String unifiedCreditCode) {
        this.unifiedCreditCode = unifiedCreditCode;
    }

    public String getBusinessScope() {
        return businessScope;
    }

    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope;
    }

    public String getIsVerification() {
        return isVerification;
    }

    public void setIsVerification(String isVerification) {
        this.isVerification = isVerification;
    }
}
