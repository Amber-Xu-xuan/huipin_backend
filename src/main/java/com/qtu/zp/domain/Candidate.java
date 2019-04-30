package com.qtu.zp.domain;

import javax.validation.constraints.NotNull;

/**
 * @Author amberXu
 * @Description //求职者
 * @Date 2019/3/11  10:37
 * @Param
 **/
public class Candidate {

    private String phone; //电话
    private Integer cid;
    private String cusername; //用户名
    private String cpassword;
    private String ccreateTime;
    private String findJobTime;
    private String status;
//    private String requestJobList;
//    private String checked;  //当前你已经投递过多少简历,数据库中不用有
//    private String requestJobNum;

//    设置投递过某岗位的求职者列表
//    当求职者点击投递简历之后，在相应岗位上的求职者列表中添加改求职者的信息
//    招聘企业可以点击招聘详情查看该岗位的相应投递简历情况。
//    通过电话联系或e-mail联系进行沟通

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getcusername() {
        return cusername;
    }

    public void setcusername(String cusername) {
        this.cusername = cusername;
    }

    public String getCpassword() {
        return cpassword;
    }

    public void setCpassword(String cpassword) {
        this.cpassword = cpassword;
    }

    public String getCcreateTime() {
        return ccreateTime;
    }

    public void setCcreateTime(String ccreateTime) {
        this.ccreateTime = ccreateTime;
    }

    public String getFindJobTime() {
        return findJobTime;
    }

    public void setFindJobTime(String findJobTime) {
        this.findJobTime = findJobTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
