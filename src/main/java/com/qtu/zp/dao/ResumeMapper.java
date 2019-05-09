package com.qtu.zp.dao;

import com.github.pagehelper.Page;
import com.qtu.zp.Vo.RecruitmentSituationVo;
import com.qtu.zp.domain.Resume;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: AmberXu
 * @Date: 2019/5/8 11:54
 */
@Mapper
public interface ResumeMapper {
    Page<Resume> getResumeByCondition(String phone, String educationBackground, String major);

    //    添加
    void addResume(Resume resume);

    //    删除
    void deleteResume(String rId);

    //    更新职位信息
    void updateResume(Resume resume);

    //    投递简历
    void addRecruitmentSituation(RecruitmentSituationVo recruitmentSituationVo);
}
