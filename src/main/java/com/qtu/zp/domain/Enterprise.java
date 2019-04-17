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

    public Enterprise(Integer eid, String eName, String epassword, String ecreateTime, String ephone) {
        this.eid = eid;
        this.eName = eName;
        this.epassword = epassword;
        this.ecreateTime = ecreateTime;
        this.ephone = ephone;
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
                '}';
    }
}
