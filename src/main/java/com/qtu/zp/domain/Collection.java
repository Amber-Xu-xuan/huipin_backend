package com.qtu.zp.domain;

/**
 * @Author: AmberXu
 * @Date: 2019/5/18 16:19
 */
public class Collection {
    private Integer id;
    private String cphone;
    private String jpId;
    private String jName;
    private String eName;
    private String collectTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCphone() {
        return cphone;
    }

    public void setCphone(String cphone) {
        this.cphone = cphone;
    }

    public String getJpId() {
        return jpId;
    }

    public void setJpId(String jpId) {
        this.jpId = jpId;
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

    public String getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(String collectTime) {
        this.collectTime = collectTime;
    }
}
