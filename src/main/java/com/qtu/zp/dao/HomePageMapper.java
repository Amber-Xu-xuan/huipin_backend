package com.qtu.zp.dao;

import com.github.pagehelper.Page;
import com.qtu.zp.domain.SocialHomepage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: AmberXu
 * @Date: 2019/5/12 15:03
 */
@Mapper
public interface HomePageMapper {
    List<SocialHomepage> getHomePageByCondition(String phone);
    //    分页：查询全部
    Page<SocialHomepage> getHomePageByPhone(String phone);

    //    添加
    void addHomePage(SocialHomepage SocialHomepage);

    //    删除
    void deleteHomePage(String eId);

    //    更新工作信息
    void updateHomePage(SocialHomepage SocialHomepage);
}
