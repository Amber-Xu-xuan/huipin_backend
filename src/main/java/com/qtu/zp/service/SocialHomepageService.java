package com.qtu.zp.service;

import com.qtu.zp.Vo.PageModel;
import com.qtu.zp.domain.SocialHomepage;

import java.util.List;

/**
 * @Author: AmberXu
 * @Date: 2019/5/13 23:29
 */
public interface SocialHomepageService {
//    分页：find 不分页：get
    List<SocialHomepage> getSocialHomepageByPhone(String phone);

    //    获取岗位信息(分页）
    PageModel findSocialHomepageByPhone(Integer pageCode, Integer pageSize, String phone);

    //    添加职位信息
    void addSocialHomepage(SocialHomepage socialHomepage);

//    List<SocialHomepage> getAllSocialHomepage();

    //    删除职位信息
    void deleteSocialHomepage(String shId);

    //    更新职位信息
    void updateSocialHomepage(SocialHomepage socialHomepage);
}
