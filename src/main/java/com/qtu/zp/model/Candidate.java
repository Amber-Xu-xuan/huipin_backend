package com.qtu.zp.model;

/**
 * @Author amberXu
 * @Description //求职者
 * @Date 2019/3/11  10:37
 * @Param
 **/
public class Candidate {
    private Integer cid;
    private String cName;
    private String cpassword;
    private String ccreateTime;
    private String findJobTime;
    private String status;
    private String requestJobList;
    private String checked;  //当前你已经投递过多少简历,数据库中不用有
    private String requestJobNum;
    private CandidateMessage candidate_message;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
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

    public String getRequestJobList() {
        return requestJobList;
    }

    public void setRequestJobList(String requestJobList) {
        this.requestJobList = requestJobList;
    }

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }

    public String getRequestJobNum() {
        return requestJobNum;
    }

    public void setRequestJobNum(String requestJobNum) {
        this.requestJobNum = requestJobNum;
    }

    public CandidateMessage getCandidate_message() {
        return candidate_message;
    }

    public void setCandidate_message(CandidateMessage candidate_message) {
        this.candidate_message = candidate_message;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "cName='" + cName + '\'' +
                ", cpassword='" + cpassword + '\'' +
                ", ccreateTime='" + ccreateTime + '\'' +
                ", findJobTime='" + findJobTime + '\'' +
                ", status='" + status + '\'' +
                ", requestJobList='" + requestJobList + '\'' +
                ", checked='" + checked + '\'' +
                ", requestJobNum='" + requestJobNum + '\'' +
                ", candidate_message=" + candidate_message +
                '}';
    }
}
