package com.qtu.zp.controller;

import com.qtu.zp.domain.Candidate;
import com.qtu.zp.domain.CandidateMessage;
import com.qtu.zp.domain.JobPosition;
import com.qtu.zp.model.LoginModel;
import com.qtu.zp.service.CandidateService;
import com.qtu.zp.utils.result.Result;
import com.qtu.zp.utils.result.ResultFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
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
@RequestMapping(value = "/api") // 映射到/candidate路径下
public class CandidateController {
    //    创建线程安全的Map
//    static Map<Long, Candidate> Candidates = Collections.synchronizedMap(new HashMap<Long, Candidate>());

    //    这样就是获取nginx传过来的用户真实ip
//    String userIp = request.getHeader("X-real-ip");

    @Resource
    private CandidateService candidateService;

    @RequestMapping("/getAllCandidate")
    public List<Candidate> getAllCandidate() {

        List<Candidate> candidates = candidateService.getAllCandidate();
        return candidates;
    }


    @CrossOrigin
    @RequestMapping(value = "/candidate/login", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public Result login(@RequestBody LoginModel user, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response) {
        Candidate candidate = candidateService.findCandidateByPhone(user.getPhone());
        if (candidate.getCpassword().equals(user.getPassword())) {
            request.getSession().setAttribute("candidateInfo", candidate);
            return ResultFactory.buildSuccessResult("登陆成功。");
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
    @RequestMapping(value = "/candidate/getAllJobList", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public Result getAllJobList( HttpServletRequest request, HttpServletResponse response) {
            List<JobPosition> jobPositions = candidateService.getAllJobList();
            System.out.println("获取到的数据" + jobPositions.toString());
            if(jobPositions == null){
                return ResultFactory.buildFailResult("无法获取数据");
            }else{
                return ResultFactory.buildSuccessResult(jobPositions);
            }
    }

//
//    @RequestMapping(value="/", method=RequestMethod.POST)
//    public String postCandidate(@ModelAttribute Candidate candidate) {
//        // 处理"/Candidates/"的POST请求，用来创建Candidate
//        // 除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从页面中传递参数
//        Candidates.put(candidate.getCid().longValue(), candidate);
//        return "success";
//    }
//
//    @RequestMapping(value="/{id}", method=RequestMethod.GET)
//    public Candidate getCandidate(@PathVariable Long id) {
//        // 处理"/Candidates/{id}"的GET请求，用来获取url中id值的Candidate信息
//        // url中的id可通过@PathVariable绑定到函数的参数中
//        return Candidates.get(id);
//    }
//
//    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
//    public String putCandidate(@PathVariable Long id, @ModelAttribute Candidate candidate) {
//        // 处理"/Candidates/{id}"的PUT请求，用来更新Candidate信息
//        Candidate u = Candidates.get(id);
//        CandidateMessage cmold = candidate.getCandidate_message();
//        CandidateMessage cmnew = u.getCandidate_message();
//        u.setcName(candidate.getcName());
//        cmnew.setHeadImage(cmold.getHeadImage());
//        u.setCandidate_message(cmnew);
//        Candidates.put(id, u);
//        return "success";
//    }
//
//    @RequestMapping(value="", method=RequestMethod.DELETE)
//    public String deleteCandidate(@PathVariable Long id) {
//        // 处理"/Candidates/{id}"的DELETE请求，用来删除Candidate
//        Candidates.remove(id);
//        return "success";
//    }
}
