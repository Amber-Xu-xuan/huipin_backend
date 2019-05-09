package com.qtu.zp.service;

import com.qtu.zp.Vo.PageModel;
import com.qtu.zp.Vo.RecruitmentSituationVo;
import com.qtu.zp.Vo.SelectResumeConditionVo;
import com.qtu.zp.domain.Resume;

import java.util.List;


/**
 * @Author: AmberXu
 * @Date: 2019/5/8 11:55
 */
public interface ResumeService {
    List<Resume> getResumeByCondition(Resume resume);

//    分页
    PageModel getResumePageByCondition(SelectResumeConditionVo selectResumeConditionVo);
    //    添加
    void addResume(Resume resume);

    //    删除
    void deleteResume(String rId);

    //    更新职位信息
    void updateResume(Resume resume);

//    投递简历
    void addRecruitmentSituation(RecruitmentSituationVo recruitmentSituationVo);
}
