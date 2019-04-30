package com.qtu.zp.Vo;

import com.qtu.zp.domain.Enterprise;
import com.qtu.zp.domain.EnterpriseMessage;

/**
 * @Author: AmberXu
 * @Date: 2019/4/21 13:02
 */
public class EnterpriseRegisterModel {

    private Enterprise enterprise;
    private EnterpriseMessage enterpriseMessage;

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public EnterpriseMessage getEnterpriseMessage() {
        return enterpriseMessage;
    }

    public void setEnterpriseMessage(EnterpriseMessage enterpriseMessage) {
        this.enterpriseMessage = enterpriseMessage;
    }
}
