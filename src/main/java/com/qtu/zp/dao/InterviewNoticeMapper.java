package com.qtu.zp.dao;

import com.github.pagehelper.Page;
import com.qtu.zp.domain.InterviewNotice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: AmberXu
 * @Date: 2019/5/30 13:27
 */
@Mapper
public interface InterviewNoticeMapper {
    List<InterviewNotice> getInterviewNoticeByPhone(String phone);
    //    分页：查询全部
    Page<InterviewNotice> findInterviewNoticeByPhone(String phone);

    //    分页：通过公司名查询全部
    Page<InterviewNotice> findInterviewNoticeByPhoneAndEName(String phone,String companyName);

    //    添加
    void addInterviewNotice(InterviewNotice workExperience);

    //    删除
    void deleteInterviewNotice(String weId);

    //    更新工作信息
    void updateInterviewNotice(InterviewNotice workExperience);

    // 通过手机号、公司名、职位名称查询
    List<InterviewNotice> getInterviewNoticeByCPhoneAndENameAndInjob(String cphone, String eName, String injob);
}
