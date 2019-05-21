package com.qtu.zp.service;

import com.qtu.zp.Vo.PageModel;
import com.qtu.zp.domain.WorkExperience;

import java.util.List;

/**
 * @Author: AmberXu
 * @Date: 2019/5/14 0:36
 */
public interface WorkExperienceService {
    //    分页：find 不分页：get
    List<WorkExperience> getWorkExperienceByPhone(String phone);

    //    获取岗位信息(分页）
    PageModel findWorkExperienceByPhone(Integer pageCode, Integer pageSize, String phone);

//    获取岗位信息(分页）
    PageModel findWorkExperienceByPhoneAndEName(Integer pageCode, Integer pageSize, String phone,String companyName);

    //    添加职位信息
    void addWorkExperience(WorkExperience workExperience);

//    List<WorkExperience> getAllWorkExperience();

    //    删除职位信息
    void deleteWorkExperience(String weId);

    //    更新职位信息
    void updateWorkExperience(WorkExperience workExperience);
}
