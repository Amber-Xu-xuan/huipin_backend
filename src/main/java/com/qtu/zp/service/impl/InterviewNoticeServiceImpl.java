package com.qtu.zp.service.impl;

import com.qtu.zp.Vo.PageModel;
import com.qtu.zp.dao.InterviewNoticeMapper;
import com.qtu.zp.domain.InterviewNotice;
import com.qtu.zp.service.InterviewNoticeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: AmberXu
 * @Date: 2019/5/30 13:20
 */
@Service
public class InterviewNoticeServiceImpl implements InterviewNoticeService {


    @Resource
    InterviewNoticeMapper interviewNoticeMapper;
    @Override
    public List<InterviewNotice> getInterviewNoticeByPhone(String phone) {
        return interviewNoticeMapper.getInterviewNoticeByPhone(phone);
    }

    @Override
    public PageModel findInterviewNoticeByPhone(Integer pageCode, Integer pageSize, String phone) {
        return null;
    }

    @Override
    public PageModel findInterviewNoticeByPhoneAndEName(Integer pageCode, Integer pageSize, String phone, String companyName) {
        return null;
    }

    @Override
    public void addInterviewNotice(InterviewNotice interviewNotice) {
        interviewNoticeMapper.addInterviewNotice(interviewNotice);
    }

    @Override
    public void deleteInterviewNotice(String weId) {

    }

    @Override
    public void updateInterviewNotice(InterviewNotice interviewNotice) {

    }

    @Override
    public List<InterviewNotice> getInterviewNoticeByCPhoneAndENameAndInjob(String cphone, String eName, String injob) {
        return interviewNoticeMapper.getInterviewNoticeByCPhoneAndENameAndInjob(cphone,eName,injob);
    }
}
