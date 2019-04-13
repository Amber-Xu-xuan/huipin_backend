package com.qtu.zp.service;

import com.qtu.zp.domain.Candidate;
import com.qtu.zp.domain.JobPosition;
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
    List<JobPosition> getAllJobList();
}
