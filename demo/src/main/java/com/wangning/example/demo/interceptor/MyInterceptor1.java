package com.wangning.example.demo.interceptor;

import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class MyInterceptor1 implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
      /*  String principal =
                request.getUserPrincipal().getName();*/
        request.getSession(true);//创建session,HttpOnly
        request.getSession().invalidate();//删除session
        String method = request.getMethod();
        String requestURI = request.getRequestURI();
        String servletPath = request.getServletPath();
        String remoteUser = request.getRemoteUser();
        String remoteAddr = request.getRemoteAddr();
        String protocol = request.getProtocol();
        String sessionId = request.getRequestedSessionId();
        String serverName = request.getServerName();
        System.out.println("preHandle1");
      //  System.out.println("principal="+principal);
        System.out.println("method="+method);
        System.out.println("requestURI="+requestURI);
        System.out.println("servletPath="+servletPath);
        System.out.println("remoteUser="+remoteUser);
        System.out.println("remoteAddr="+remoteAddr);
        System.out.println("protocol="+protocol);
        System.out.println("sessionId="+sessionId);
        System.out.println("serverName="+serverName);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion1");
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle1");
    }

}
