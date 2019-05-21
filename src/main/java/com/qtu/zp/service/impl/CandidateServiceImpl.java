package com.qtu.zp.service.impl;

import com.qtu.zp.Vo.FilterConditionVo;
import com.qtu.zp.dao.CandidateMapper;
import com.qtu.zp.dao.JobPositionMapper;
import com.qtu.zp.domain.Candidate;
import com.qtu.zp.domain.CandidateMessage;
import com.qtu.zp.domain.JobPosition;
import com.qtu.zp.domain.JobPositionAndEnterpriseMessage;
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
    public void updateCandidateBaseInfo(CandidateMessage candidateMessage) {
        candidateMapper.updateCandidateBaseInfo(candidateMessage);
    }

    @Override
    public void updateIntroduce(String phone, String introduce) {
        candidateMapper.updateIntroduce(phone,introduce);
    }

    @Override
    public List<JobPositionAndEnterpriseMessage> getAllJobList() {
        return jobPositionMapper.getAllJobList();
    }

    @Override
    public List<CandidateMessage> getCandidateMessageByPhone(String phone) {
        return candidateMapper.getCandidateMessageByPhone(phone);
    }

    @Override
    public void addCandidate(Candidate candidate, CandidateMessage candidateMessage) {
        candidateMapper.addCandidate(candidate);
        candidateMapper.addCandidateMessage(candidateMessage);
    }

    @Override
    public void updatePassword(String phone, String cpassword) {
        candidateMapper.updatePassword(phone,cpassword);
    }

    @Override
    public List<JobPositionAndEnterpriseMessage> getJobListByFilterCondition(FilterConditionVo selectCondition) {
        return jobPositionMapper.getJobListByFilterCondition(selectCondition);
    }
}
