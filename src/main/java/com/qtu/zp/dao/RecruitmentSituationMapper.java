package com.qtu.zp.dao;

import com.github.pagehelper.Page;
import com.qtu.zp.Vo.AllMessageAboutCandidateVo;
import com.qtu.zp.Vo.RecruitmentSituationVo;
import com.qtu.zp.domain.JobPosition;
import com.qtu.zp.domain.RecruitmentSituation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: AmberXu
 * @Date: 2019/5/11 18:18
 */
@Mapper
public interface RecruitmentSituationMapper {
    //    投递简历
    void addRecruitmentSituation(RecruitmentSituation recruitmentSituation);
    Page<RecruitmentSituation> selectRecruitmentSituationByeNameAndjName(String eName,String jName);
    List<String> selectPhoneByeNameAndjName(String eName, String jName);
    List<JobPosition> getJobPositionByRecruitmentSituationAndPhone(String phone);
}
