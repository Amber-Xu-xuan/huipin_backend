package com.qtu.zp.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qtu.zp.Vo.PageModel;
import com.qtu.zp.dao.SocialHomepageMapper;
import com.qtu.zp.domain.SocialHomepage;
import com.qtu.zp.service.SocialHomepageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: AmberXu
 * @Date: 2019/5/13 23:39
 */
@Service
public class SocialHomepageServiceImpl implements SocialHomepageService {

    @Resource
    SocialHomepageMapper socialHomepageMapper;

    @Override
    public List<SocialHomepage> getSocialHomepageByPhone(String phone) {
        return socialHomepageMapper.getSocialHomepageByPhone(phone);
    }

    @Override
    public PageModel findSocialHomepageByPhone(Integer pageCode, Integer pageSize, String phone) {
        //使用Mybatis分页插件
        PageHelper.startPage(pageCode,pageSize);

        //调用分页查询方法，其实就是查询所有数据，mybatis自动帮我们进行分页计算
        Page<SocialHomepage> page = socialHomepageMapper.findSocialHomepageByPhone(phone);
        return new PageModel(page.getTotal(),page.getResult());
    }

    @Override
    public void addSocialHomepage(SocialHomepage socialHomepage) {
        socialHomepageMapper.addSocialHomepage(socialHomepage);
    }

//    @Override
//    public List<SocialHomepage> getAllSocialHomepage() {
//        return socialHomepageMapper.getAllSocialHomepage();
//    }

    @Override
    public void deleteSocialHomepage(String shId) {
        socialHomepageMapper.deleteSocialHomepage(shId);
    }

    @Override
    public void updateSocialHomepage(SocialHomepage socialHomepage) {
        socialHomepageMapper.updateSocialHomepage(socialHomepage);
    }
}
