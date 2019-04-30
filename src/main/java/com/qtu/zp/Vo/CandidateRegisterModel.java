package com.qtu.zp.Vo;

import com.qtu.zp.domain.Candidate;
import com.qtu.zp.domain.CandidateMessage;

/**
 * @Author: AmberXu
 * @Date: 2019/4/22 23:18
 */
public class CandidateRegisterModel {
    Candidate candidate;
    CandidateMessage candidateMessage;
    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public CandidateMessage getCandidateMessage() {
        return candidateMessage;
    }

    public void setCandidateMessage(CandidateMessage candidateMessage) {
        this.candidateMessage = candidateMessage;
    }
}
