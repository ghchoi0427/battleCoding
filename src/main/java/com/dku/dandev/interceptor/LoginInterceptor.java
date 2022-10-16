package com.dku.dandev.interceptor;

import com.dku.dandev.session.SessionConst;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginInterceptor implements HandlerInterceptor {


    /**
     * false -> 수행 안함
     * true -> 컨트롤러 수행
     */

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object Handler) throws Exception {

        HttpSession session = request.getSession();
        if (session.getAttribute(SessionConst.LOGIN_MEMBER) == null) {
            System.out.println("not login");
            response.sendRedirect("/home"); // 이거 종료시키는 메서드 아님!!!
            return false;
        }
        System.out.println("login!!");
        return true;
    }

}
