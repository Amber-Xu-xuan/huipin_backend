package com.qtu.zp.service;

import com.qtu.zp.domain.Candidate;
import org.springframework.stereotype.Service;

/**
 * @Author: AmberXu
 * @Date: 2019/4/10 10:15
 */
public interface CandidateService {

    Candidate findCandidateByPhone(String phone);
}
