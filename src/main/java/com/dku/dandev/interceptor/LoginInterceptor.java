package com.dku.dandev.interceptor;

import com.dku.dandev.session.SessionConst;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginInterceptor implements HandlerInterceptor {

    /*
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                            @Nullable ModelAndView modelAndView) throws Exception {

        HttpSession session = request.getSession();
        if (session.getAttribute(SessionConst.LOGIN_MEMBER) == null) {
            System.out.println("not login");
            response.sendRedirect("/login");// 이거 종료시키는 메서드 아님!!!
            return;
        }
        System.out.println("login");
    }
    */

    /**
     * false -> 수행 안함
     * true -> 컨트롤러 수행
     */


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object Handler) throws Exception {

        HttpSession session = request.getSession();
        System.out.println(session);
        if (session.getAttribute(SessionConst.LOGIN_MEMBER) == null) {
            System.out.println("not login");
            response.sendRedirect("/login"); // 이거 종료시키는 메서드 아님!!!
            return false;
        }
        System.out.println("login!!");
        return true;
    }




}
