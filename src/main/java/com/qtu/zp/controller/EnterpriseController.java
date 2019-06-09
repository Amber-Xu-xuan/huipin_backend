package com.qtu.zp.controller;

import com.qtu.zp.domain.BusinessInformation;
import com.qtu.zp.domain.Enterprise;
import com.qtu.zp.Vo.EnterpriseRegisterModel;
import com.qtu.zp.Vo.LoginModel;
import com.qtu.zp.Vo.PageModel;
import com.qtu.zp.domain.EnterpriseMessage;
import com.qtu.zp.domain.JobPositionAndEnterpriseMessage;
import com.qtu.zp.service.EnterpriseService;
import com.qtu.zp.service.JobService;
import com.qtu.zp.utils.result.Result;
import com.qtu.zp.utils.result.ResultFactory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * @Author: AmberXu
 * @Date: 2019/4/11 21:46
 */
@Api(value = "企业管理", tags = "企业管理")
@RestController
@RequestMapping(value = "/zp")
public class EnterpriseController extends AbstractController {

    @Resource
    private EnterpriseService enterpriseService;

    @Resource
    private JobService jobPositionService;


    @RequestMapping("/getAllEnterprise")
    public List<Enterprise> getAllEnterprise() {

        List<Enterprise> enterprises = enterpriseService.getAllEnterprise();
        return enterprises;
    }

    /**
     * @param user
     * @param bindingResult
     * @param request
     * @param response
     * @return 登录操作
     */

    @ApiOperation("企业管理登录")
    @CrossOrigin
    @RequestMapping(value = "/enterprise/login", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public Result login(@RequestBody LoginModel user, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Enterprise enterprise = enterpriseService.findEnterpriseByPhone(user.getPhone());
        if(enterprise == null){
            return ResultFactory.buildFailResult("该账号未进行注册");
        }else if (enterprise.getEpassword().equals(user.getPassword())) {
            session.setAttribute("enterprise", enterprise);
//            System.out.println("登录session的id是====" + session.getId());

            return ResultFactory.buildSuccessResult(enterprise);
        } else if (bindingResult.hasErrors()) {
            String message = String.format("登录失败，详细信息[%s]。", bindingResult.getFieldError().getDefaultMessage());
            return ResultFactory.buildFailResult(message);
        } else {
            String message = String.format("登录失败，用户名、密码信息不正确。");
            return ResultFactory.buildFailResult(message);
        }
    }

    /**
     * @param
     * @param request
     * @param
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/enterprise/getJobListByEName", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public Result getJobListByEName(@RequestParam("pageCode") Integer pageCode, @RequestParam("pageSize") Integer pageSize, @RequestParam("phone") String phone, HttpServletRequest request, HttpServletResponse response) {

//        获取公司名称
        if (phone == null) {
            return ResultFactory.buildFailResult("请先登录您的企业账号");
        } else {
            Enterprise enterprise = enterpriseService.findEnterpriseByPhone(phone);
            String eName = enterprise.geteName();
            if (eName == null) {
                return ResultFactory.buildFailResult("请先完善您的企业信息");
            } else {
                PageModel result = jobPositionService.findJobListByEName(pageCode, pageSize, eName);
                return ResultFactory.buildSuccessResult(result);
            }

        }
    }

    //    修改密码
    @CrossOrigin
    @PostMapping(value = "/enterprise/updatePassword", produces = "application/json; charset=UTF-8")
    public Result updatePassword(@RequestBody Enterprise enterprise) {
        enterpriseService.updatePassword(enterprise.getEphone(), enterprise.getEpassword());
        return ResultFactory.buildSuccessResult("密码修改成功");
    }

    @RequestMapping(value = "/registerEnterprise", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public Result registerEnterprise(@RequestBody EnterpriseRegisterModel enterpriseRegister, HttpServletRequest request, HttpServletResponse response) {
        if (enterpriseRegister == null) {
            return ResultFactory.buildFailResult("请重新注册");
        } else {
            enterpriseService.registerEnterprise(enterpriseRegister.getEnterprise(), enterpriseRegister.getEnterpriseMessage());
            String message = String.format("成功注册。");
            return ResultFactory.buildSuccessResult(message);
        }
    }


    //    游客模式：通过点击职位card上公司名称跳转到相应的公司信息页面 getEnterpriseByEName
    @CrossOrigin
    @RequestMapping(value = "/getEnterpriseByEName", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public Result getEnterpriseByEName(@RequestParam("eName") String eName, HttpServletRequest request, HttpServletResponse response) {

        List<EnterpriseMessage> enterpriseMessages = enterpriseService.getEnterpriseByEName(eName);
        if (enterpriseMessages == null) {
            return ResultFactory.buildFailResult("无法获取该公司的相关信息。");
        } else {
            return ResultFactory.buildSuccessResult(enterpriseMessages);
        }
    }

    //更新职位信息
    @CrossOrigin
    @PostMapping(value = "/enterprise/editEnterprise", produces = "application/json;charset=UTF-8")
    public Result updateEnterprise(@RequestBody EnterpriseRegisterModel enterpriseRegisterModel, HttpServletRequest request, HttpServletResponse response) {
        enterpriseService.updateEnterprise(enterpriseRegisterModel.getEnterprise());
        enterpriseService.updateEnterpriseMessage(enterpriseRegisterModel.getEnterpriseMessage());
        String message = String.format("成功修改。");
        return ResultFactory.buildSuccessResult(message);
    }

    //    游客模式：获取公司的工商信息
//    todo：时间转换
    @CrossOrigin
//    @RequestMapping(value = "/getBusinessInformation", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    @GetMapping(value = "/getBusinessInformation", produces = "application/json; charset=UTF-8")
    public Result getBusinessInformation(@RequestParam("eName") String eName) {
        BusinessInformation businessInformation = enterpriseService.getBusinessInformation(eName);
        if (businessInformation == null) {
            return ResultFactory.buildFailResult("由于该企业未进行认证，无法获取该公司的工商信息");
        } else if (!businessInformation.getIsVerification().equals("通过验证")) {
//            当该公司的工商信息没有获得验证时，不能显示改公司的工商信息
            return ResultFactory.buildFailResult("由于该企业未进行认证，无法显示该公司的工商信息");
        } else {
            return ResultFactory.buildSuccessResult(businessInformation);
        }

    }

    @CrossOrigin
    @GetMapping(value = "enterprise/getEnterpriseAvatar",produces = "application/json; charset=UTF-8")
    public Result getEnterpriseAvatar(String emphone){
        if (emphone == null || emphone == "") {
            return ResultFactory.buildFailResult("请重新登录");
        } else {
            List<EnterpriseMessage> enterpriseMessageList = enterpriseService.getEnterpriseMessageByEmphone(emphone);
            EnterpriseMessage enterpriseMessage = enterpriseMessageList.get(0);
            return ResultFactory.buildSuccessResult(enterpriseMessage.getEmheadImage());
        }
    }

//    @RequestBody EnterpriseMessage enterpriseMessage
    @CrossOrigin
    @PostMapping(value = "enterprise/uploadEnterpriseAvatar",produces = "application/json; chartset=UTF-8")
    public Result uploadEnterpriseAvatar(HttpServletRequest req, @RequestParam("file") MultipartFile file,@RequestParam("emphone") String emphone, Model m){
        try {
            if (file.isEmpty()){
                return ResultFactory.buildFailResult("请选择您上传的头像文件，再重新上传");
            }else if(emphone == null || emphone == ""){
                return ResultFactory.buildFailResult("请登录账号，再重新上传");
            }
            //2.根据时间戳创建新的文件名，这样即便是第二次上传相同名称的文件，也不会把第一次的文件覆盖了
            String fileName = System.currentTimeMillis() + file.getOriginalFilename();

//            图片储存的路径
//            String filePath = "C://Program Files//Apache Software Foundation//Tomcat 8.0//webapps//"; // 上传后的路径
            String filePath = "G://dasixia//study_graduation_project//source program//frontend//vue//test//static//enterpriseAvatar"; // 上传后的路径
            //3.通过req.getServletContext().getRealPath("") 获取当前项目的真实路径，然后拼接前面的文件名
//            String destFileName = req.getServletContext().getRealPath("") + "uploaded" + File.separator + fileName;
            //4.第一次运行的时候，这个文件所在的目录往往是不存在的，这里需要创建一下目录（创建到了webapp下uploaded文件夹下）
            String destFileName = filePath + "//" + fileName;
            File destFile = new File(destFileName);

            destFile.getParentFile().mkdirs();
            //5.把浏览器上传的文件复制到希望的位置
            file.transferTo(destFile);
            //6.把文件名放在model里，以便后续显示用
            m.addAttribute("fileName", fileName);
//            存进数据库
            EnterpriseMessage enterpriseMessage = new EnterpriseMessage();
            enterpriseMessage.setEmheadImage(fileName);
            enterpriseMessage.setEmphone(emphone);
            enterpriseService.updateEnterpriseMessage(enterpriseMessage);

            return ResultFactory.buildSuccessResult(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return ResultFactory.buildFailResult("上传失败," + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            return ResultFactory.buildFailResult("上传失败," + e.getMessage());
        }

//        return "showImg";

    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        return null;
    }
}
