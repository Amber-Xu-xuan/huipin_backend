package com.qtu.zp.component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author: AmberXu
 * @Date: 2019/4/9 13:13
 * 登录检查
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    //目标方法执行之前
//    登录拦截器
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");

        HttpSession session = request.getSession();
//        Object user = session.getAttribute("enterprise");
        System.out.println("拦截器中的session的id是===="+ session.getId());
//        if(user == null){
//            //未登录，返回登陆页面
//            request.setAttribute("msg","没有权限请先登陆");
//            System.out.println("必须先登录");
////            request.getRequestDispatcher("/zp/enterpriseCenter").forward(request,response);
//            return false;
//        }else{
//            //已登录，放行请求
//            System.out.println("hahhahah");
//            return true;
//        }
return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}

