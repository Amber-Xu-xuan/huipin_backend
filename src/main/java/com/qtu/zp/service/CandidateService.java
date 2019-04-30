package com.qtu.zp.service;

import com.qtu.zp.Vo.FilterConditionVo;
import com.qtu.zp.domain.Candidate;
import com.qtu.zp.domain.CandidateMessage;
import com.qtu.zp.domain.JobPosition;
import com.qtu.zp.domain.JobPositionAndEnterpriseMessage;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: AmberXu
 * @Date: 2019/4/10 10:15
 */
public interface CandidateService {

    List<Candidate> getAllCandidate();

    Candidate findCandidateByPhone(String phone);

    //    用户获取所有岗位信息
    List<JobPositionAndEnterpriseMessage> getAllJobList();

    //    注册用户
    void addCandidate(Candidate candidate,CandidateMessage candidateMessage);

    //    通过筛选获取所有岗位信息
    List<JobPositionAndEnterpriseMessage> getJobListByFilterCondition(FilterConditionVo selectCondition);

}
