package com.qtu.zp.dao;

import com.github.pagehelper.Page;
import com.qtu.zp.domain.SocialHomepage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: AmberXu
 * @Date: 2019/5/12 17:15
 */
@Mapper
public interface SocialHomepageMapper {
    List<SocialHomepage> getSocialHomepageByPhone(String phone);
    //    分页：查询全部
    Page<SocialHomepage> findSocialHomepageByPhone(String phone);

    //    添加
    void addSocialHomepage(SocialHomepage socialHomepage);

    //    删除
    void deleteSocialHomepage(String shId);

    //    更新信息
    void updateSocialHomepage(SocialHomepage socialHomepage);
}
