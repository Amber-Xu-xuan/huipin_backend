package com.qtu.zp.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qtu.zp.Vo.PageModel;
import com.qtu.zp.dao.SocialHomepageMapper;
import com.qtu.zp.domain.SocialHomepage;
import com.qtu.zp.service.SocialHomepageService;
import com.qtu.zp.utils.result.Result;
import com.qtu.zp.utils.result.ResultFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author: AmberXu
 * @Date: 2019/5/13 23:21
 */
@RestController
@RequestMapping("/zp")
public class SocialHomepageController {
    @Resource
    private SocialHomepageService socialHomepageService;

    @CrossOrigin
    @PostMapping(value = "/candidate/addSocialHomepage", produces = "application/json;charset=UTF-8")
    public Result addSocialHomepage(@RequestBody SocialHomepage socialHomepage, HttpServletRequest request, HttpServletResponse response) {
        if (socialHomepage.getPhone() == null || socialHomepage.getPhone() == "") {
            return ResultFactory.buildFailResult("请先登录您的账号，再重新添加");
        } else {
                socialHomepageService.addSocialHomepage(socialHomepage);
                String message = String.format("成功添加。");
                return ResultFactory.buildSuccessResult(message);
        }
    }

    //删除
    @CrossOrigin
    @DeleteMapping(value = "/candidate/deleteSocialHomepage", produces = "application/json;charset=UTF-8")
    public Result deleteSocialHomepage(@RequestBody String shId, HttpServletRequest request, HttpServletResponse response) {
        JSONObject idJSON = JSON.parseObject(shId);
        String id = idJSON.getString("shId");
        socialHomepageService.deleteSocialHomepage(id);
        String message = String.format("成功删除。");
        return ResultFactory.buildSuccessResult(message);
    }

    //更新
    @CrossOrigin
    @PostMapping(value = "/candidate/updateSocialHomepage", produces = "application/json;charset=UTF-8")
    public Result updateSocialHomepage(@RequestBody SocialHomepage socialHomepage) {
        socialHomepageService.updateSocialHomepage(socialHomepage);
        String message = String.format("成功修改。");
        return ResultFactory.buildSuccessResult(message);
    }

    //    不分页查询
    @CrossOrigin
    @PostMapping(value = "/candidate/getSocialHomepageByPhone", produces = "application/json; charset=UTF-8")
    public Result getSocialHomepageByPhone(@RequestBody String phone) {
        System.out.println(phone);
        JSONObject phoneJSON = JSON.parseObject(phone);
        String phonep = phoneJSON.getString("phone");
        if (phone == "" || phone == null) {
            return ResultFactory.buildFailResult("请先登录您的账号");
        }else
        {
            List<SocialHomepage>  result = socialHomepageService.getSocialHomepageByPhone(phonep);
            return ResultFactory.buildSuccessResult(result);
        }
    }

}
