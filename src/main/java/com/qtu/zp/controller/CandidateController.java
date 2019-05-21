package com.qtu.zp.controller;

import com.qtu.zp.Vo.CandidateRegisterModel;
import com.qtu.zp.Vo.FilterConditionVo;
import com.qtu.zp.domain.Candidate;
import com.qtu.zp.domain.CandidateMessage;
import com.qtu.zp.domain.JobPosition;
import com.qtu.zp.Vo.LoginModel;
import com.qtu.zp.domain.JobPositionAndEnterpriseMessage;
import com.qtu.zp.service.CandidateService;
import com.qtu.zp.service.CollectionService;
import com.qtu.zp.utils.result.Result;
import com.qtu.zp.utils.result.ResultFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @Author amberXu
 * @Description 关于求职者的控制器
 * 1.登录，前后端分离用的协议和端口不同，所以需要加入@CrossOrigin支持跨域
 * 2.添加@Valid注解，并在参数加入bindingResult来获取错误信息
 * 在逻辑处理中我们判断BindingResult是否含有错误信息，如果有错误信息，则直接返回错误信息。
 * @Date 2019/3/11  10:59
 * @Param
 **/
@RestController
@RequestMapping(value = "/zp") // 映射到/candidate路径下
public class CandidateController {
    //    创建线程安全的Map
//    static Map<Long, Candidate> Candidates = Collections.synchronizedMap(new HashMap<Long, Candidate>());

    //    这样就是获取nginx传过来的用户真实ip
//    String userIp = request.getHeader("X-real-ip");

    @Resource
    private CandidateService candidateService;

    @Resource
    private CollectionService collectionService;

    @CrossOrigin
    @RequestMapping("/getAllCandidate")
    public List<Candidate> getAllCandidate() {

//        b.isVerification!="未通过验证"
        List<Candidate> candidates = candidateService.getAllCandidate();
        return candidates;
    }


    @CrossOrigin
    @RequestMapping(value = "/candidate/login", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public Result login(@RequestBody LoginModel user, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response) {
        Candidate candidate = candidateService.findCandidateByPhone(user.getPhone());
        if(candidate == null){
            return ResultFactory.buildFailResult("账号错误，该用户不存在");
        }
        if (candidate.getCpassword().equals(user.getPassword())) {
            request.getSession().setAttribute("candidateInfo", candidate);
            return ResultFactory.buildSuccessResult(candidate);
        } else if (bindingResult.hasErrors()) {
            String message = String.format("登陆失败，详细信息[%s]。", bindingResult.getFieldError().getDefaultMessage());
            return ResultFactory.buildFailResult(message);
        } else {
            String message = String.format("登陆失败，用户名、密码信息不正确。");
            return ResultFactory.buildFailResult(message);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/candidate/logout", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public Result logout(BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.removeAttribute("candidateInfo");
        Object candidate = session.getAttribute("candidateInfo");
        if (candidate == null) {
            String message = String.format("注销退出失败。");
            return ResultFactory.buildFailResult(message);
        } else {
            String message = String.format("注销退出成功。");
            return ResultFactory.buildFailResult(message);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/getAllJobList", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public Result getAllJobList(HttpServletRequest request, HttpServletResponse response) {
        List<JobPositionAndEnterpriseMessage> jobPositions = candidateService.getAllJobList();
//            System.out.println("获取到的数据" + jobPositions.toString());
        if (jobPositions == null) {
            return ResultFactory.buildFailResult("无法获取数据");
        } else {
            return ResultFactory.buildSuccessResult(jobPositions);
        }
    }

    //    注册求职者账号
    @CrossOrigin
    @PostMapping(value = "/registerCandidate", produces = "application/json; charset=UTF-8")
    public Result registerCandidate(@RequestBody CandidateRegisterModel candidateRegisterModel, HttpServletRequest request, HttpServletResponse response) {
//        在数据库中查询是否有对应的数据重复注册，作出提示
            if (candidateRegisterModel == null) {
            return ResultFactory.buildFailResult("请重新注册");
        } else {
            candidateService.addCandidate(candidateRegisterModel.getCandidate(), candidateRegisterModel.getCandidateMessage());
            String message = String.format("成功注册。");
            return ResultFactory.buildSuccessResult(message);
        }

    }

    @CrossOrigin
//    首页通过筛选条件，返回工作列表
    @GetMapping(value = "/getJobListByFilterCondition",produces = "application/json; charset=UTF-8")
    public  Result getJobListByFilter(FilterConditionVo selectCondition,HttpServletRequest request, HttpServletResponse response){
        System.out.println("过滤器的条件" + selectCondition.toString());
        List<JobPositionAndEnterpriseMessage> jobPositions = candidateService.getJobListByFilterCondition(selectCondition);
//            System.out.println("获取到的数据" + jobPositions.toString());
        if (jobPositions == null) {
            return ResultFactory.buildFailResult("无法获取数据");
        } else {
            return ResultFactory.buildSuccessResult(jobPositions);
        }
//        return  null;
    }

    @CrossOrigin
    @PostMapping(value = "/candidate/updatePassword",produces = "application/json; charset=UTF-8")
    public Result updatePassword(@RequestBody Candidate candidate){
        candidateService.updatePassword(candidate.getPhone(),candidate.getCpassword());
        return ResultFactory.buildSuccessResult("密码修改成功");
    }


    //    修改自我描述
    @CrossOrigin
    @PostMapping(value = "/candidate/editSelfDescription", produces = "application/json; charset=UTF-8")
    public Result editSelfDescription(@RequestBody CandidateMessage candidateMessage) {
        if (candidateMessage.getPhone() == null) {
            return ResultFactory.buildFailResult("请重新登录");
        } else {
            candidateService.updateIntroduce(candidateMessage.getPhone(),candidateMessage.getIntroduce());
            String message = String.format("修改成功。");
            return ResultFactory.buildSuccessResult(message);
        }
    }

    //    修改基础信息
    @CrossOrigin
    @PostMapping(value = "/candidate/editCandidateBaseInfo", produces = "application/json; charset=UTF-8")
    public Result editCandidateBaseInfo(@RequestBody CandidateMessage candidateMessage) {
        if (candidateMessage.getPhone() == null) {
            return ResultFactory.buildFailResult("请重新登录");
        } else {
            candidateService.updateCandidateBaseInfo(candidateMessage);
            String message = String.format("修改成功。");
            return ResultFactory.buildSuccessResult(message);
        }
    }


    @CrossOrigin
    @PostMapping(value = "/candidate/getCandidateMessageByPhone", produces = "application/json; charset=UTF-8")
    public Result getCandidateMessageByPhone(@RequestBody CandidateMessage candidateMessage) {
        if (candidateMessage.getPhone() == null) {
            return ResultFactory.buildFailResult("请重新登录");
        } else {
            List<CandidateMessage> candidateMessagesList = candidateService.getCandidateMessageByPhone(candidateMessage.getPhone());
            return ResultFactory.buildSuccessResult(candidateMessagesList);
        }
    }

// 17606050420@qq.com
}
