package com.qtu.zp.service;

import com.qtu.zp.Vo.PageModel;
import com.qtu.zp.domain.InterviewNotice;

import java.util.List;

/**
 * @Author: AmberXu
 * @Date: 2019/5/30 12:57
 */
public interface InterviewNoticeService {
    //    分页：find 不分页：get
    List<InterviewNotice> getInterviewNoticeByPhone(String phone);

    //    获取面试通知信息(分页）
    PageModel findInterviewNoticeByPhone(Integer pageCode, Integer pageSize, String phone);

    //    获取面试通知信息(分页）
    PageModel findInterviewNoticeByPhoneAndEName(Integer pageCode, Integer pageSize, String phone, String companyName);

    //    添加面试通知信息
    void addInterviewNotice(InterviewNotice workExperience);

//    List<InterviewNotice> getAllInterviewNotice();

    //    删除面试通知信息
    void deleteInterviewNotice(String weId);

    //    更新面试通知信息
    void updateInterviewNotice(InterviewNotice workExperience);

    // 避免重复添加
    List<InterviewNotice> getInterviewNoticeByCPhoneAndENameAndInjob(String cphone, String eName, String injob);

}
