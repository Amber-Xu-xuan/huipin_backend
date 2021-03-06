package com.qtu.zp.domain;

/**
 * @Author: AmberXu
 * @Date: 2019/3/31 9:42
 */
public class Enterprise {
    private Integer eid;
    private String eName; //
    private String epassword; //
    private String ecreateTime; //
    private String ephone; //
    private String status; //账号状态

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String getEpassword() {
        return epassword;
    }

    public void setEpassword(String epassword) {
        this.epassword = epassword;
    }

    public String getEcreateTime() {
        return ecreateTime;
    }

    public void setEcreateTime(String ecreateTime) {
        this.ecreateTime = ecreateTime;
    }

    public String getEphone() {
        return ephone;
    }

    public void setEphone(String ephone) {
        this.ephone = ephone;
    }

    @Override
    public String toString() {
        return "Enterprise{" +
                "eid=" + eid +
                ", eName='" + eName + '\'' +
                ", epassword='" + epassword + '\'' +
                ", ecreateTime='" + ecreateTime + '\'' +
                ", ephone='" + ephone + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
