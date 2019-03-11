package com.qtu.zp.controller;

import com.qtu.zp.model.Candidate;
import com.qtu.zp.model.CandidateMessage;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @Author amberXu
 * @Description //TODO
 * @Date 2019/3/11  10:59
 * @Param
 **/
@RestController
@RequestMapping(value = "/candidate") // 映射到/candidate路径下
public class CandidateController {
    //    创建线程安全的Map
    static Map<Long, Candidate> Candidates = Collections.synchronizedMap(new HashMap<Long, Candidate>());

    @RequestMapping(value="/", method= RequestMethod.GET)
    public List<Candidate> getCandidateList() {
        // 处理"/Candidates/"的GET请求，用来获取用户列表
        // 还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递
        List<Candidate> r = new ArrayList<Candidate>(Candidates.values());
        return r;
    }

    @RequestMapping(value="/", method=RequestMethod.POST)
    public String postCandidate(@ModelAttribute Candidate candidate) {
        // 处理"/Candidates/"的POST请求，用来创建Candidate
        // 除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从页面中传递参数
        Candidates.put(candidate.getCid().longValue(), candidate);
        return "success";
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public Candidate getCandidate(@PathVariable Long id) {
        // 处理"/Candidates/{id}"的GET请求，用来获取url中id值的Candidate信息
        // url中的id可通过@PathVariable绑定到函数的参数中
        return Candidates.get(id);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public String putCandidate(@PathVariable Long id, @ModelAttribute Candidate candidate) {
        // 处理"/Candidates/{id}"的PUT请求，用来更新Candidate信息
        Candidate u = Candidates.get(id);
        CandidateMessage cmold = candidate.getCandidate_message();
        CandidateMessage cmnew = u.getCandidate_message();
        u.setcName(candidate.getcName());
        cmnew.setHeadImage(cmold.getHeadImage());
        u.setCandidate_message(cmnew);
        Candidates.put(id, u);
        return "success";
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String deleteCandidate(@PathVariable Long id) {
        // 处理"/Candidates/{id}"的DELETE请求，用来删除Candidate
        Candidates.remove(id);
        return "success";
    }
}
