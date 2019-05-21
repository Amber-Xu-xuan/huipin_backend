package com.qtu.zp.service;

import com.qtu.zp.Vo.AllMessageAboutCandidateVo;
import com.qtu.zp.Vo.PageModel;
import com.qtu.zp.Vo.RecruitmentSituationVo;
import com.qtu.zp.Vo.SelectRecruitmentSituationVo;
import com.qtu.zp.domain.JobPosition;
import com.qtu.zp.domain.RecruitmentSituation;

import java.util.List;

/**
 * @Author: AmberXu
 * @Date: 2019/5/11 18:17
 */
public interface RecruitmentSituationService {
    //    投递简历
    void addRecruitmentSituation(RecruitmentSituation recruitmentSituation);

    // 分页：通过公司名称和职位名称查询对应岗位的招聘情况表
    PageModel selectRecruitmentSituationByeNameAndjName(SelectRecruitmentSituationVo selectRecruitmentSituationVo);

    List<String> selectPhoneByeNameAndjName(SelectRecruitmentSituationVo selectRecruitmentSituationVo);

    //
    AllMessageAboutCandidateVo selectAllMessageAboutCandidateByphone(String phone);

    RecruitmentSituationVo selectRecruitmentSituationAboutCandidateByphone(String phone);

    List<JobPosition> getJobPositionByDiliveryResumeAndPhone(String phone);
}
