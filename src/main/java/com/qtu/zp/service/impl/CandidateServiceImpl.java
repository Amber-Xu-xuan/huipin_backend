package com.qtu.zp.service.impl;

import com.qtu.zp.dao.CandidateMapper;
import com.qtu.zp.dao.JobPositionMapper;
import com.qtu.zp.domain.Candidate;
import com.qtu.zp.domain.JobPosition;
import com.qtu.zp.service.CandidateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: AmberXu
 * @Date: 2019/4/10 10:46
 */
@Service
public class CandidateServiceImpl implements CandidateService {
    @Resource
    private CandidateMapper candidateMapper;

    @Resource
    JobPositionMapper jobPositionMapper;

    @Override
    public List<Candidate> getAllCandidate() {
        return candidateMapper.getAllCandidate();
    }

    @Override
    public Candidate findCandidateByPhone(String phone) {
        return candidateMapper.findCandidateByPhone(phone);
    }

    @Override
    public List<JobPosition> getAllJobList() {
        return jobPositionMapper.getAllJobList();
    }
}
