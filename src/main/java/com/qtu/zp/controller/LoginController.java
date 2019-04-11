//package com.qtu.zp.controller;
//
//import com.qtu.zp.domain.Candidate;
//import com.qtu.zp.service.CandidateService;
//import com.qtu.zp.utils.result.Result;
//import com.qtu.zp.utils.result.ResultFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Controller;
//import org.springframework.util.StringUtils;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpSession;
//import javax.validation.Valid;
//import java.util.Map;
//import java.util.Objects;
//
///**
// * @Author: AmberXu
// * @Date: 2019/4/8 21:05
// */
//
//@RestController
//public class LoginController {
//
////    @Autowired
////    private CandidateService candidateServiceImpl;
////    @Resource(name="candidateService")
////    private CandidateService candidateServiceImpl;
//
//    /**
//     *
//     * @param phone
//     * @param password
//     * @return 求职者登录，与前端api：/candidate/login
//     * 跳转到usercenter
//     */
//
////    开发tip：模板引擎页面修改之后，要实时生效
////    （1）、禁用模板引擎的缓存：spring.thymeleaf.cache=false
////    （2）、页面修改完成以后ctrl+f9重新编译
//    @CrossOrigin
//    @RequestMapping(value = "/api/candidate/login", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
//    public Result login(@Valid @RequestBody Candidate candidate, BindingResult bindingResult
//                        ){
//        if (bindingResult.hasErrors()) {
//            String message = String.format("登陆失败，详细信息[%s]。", bindingResult.getFieldError().getDefaultMessage());
//            return ResultFactory.buildFailResult(message);
//        }
//        if (!Objects.equals("javalsj", candidate.getcusername()) || !Objects.equals("123456", candidate.getCpassword())) {
//            String message = String.format("登陆失败，详细信息[用户名、密码信息不正确]。");
//            return ResultFactory.buildFailResult(message);
//        }
//        return ResultFactory.buildSuccessResult("登陆成功。");
////        if(StringUtils.isEmpty(phone) && "123456".equals(password)){
//////            登录成功,防止表单重复提交，可以重定向到主页
//////            loginCandidate存放登录的求职者的电话账号
//////            Candidate candidate = candidateServiceImpl.findCandidateByPhone(phone);
////            session.setAttribute("loginCandidate",phone);
////            return "redirect:/usercenter.html";
////        }else{
//////            登录失败
////            map.put("msg","用户名密码错误");
////            return "login";
////        }
//    }
//}
