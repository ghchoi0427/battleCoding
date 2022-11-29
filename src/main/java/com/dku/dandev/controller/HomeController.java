package com.dku.dandev.controller;

import com.dku.dandev.domain.Member;
import com.dku.dandev.service.MemberService;
import com.dku.dandev.session.SessionConst;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

@Controller
@RequestMapping("/home")
public class HomeController {

    private final MemberService memberService;

    public HomeController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("")
    public String home(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        System.out.println(session.getAttribute("loginMember"));
        String userId = (String) session.getAttribute(SessionConst.LOGIN_MEMBER);
        System.out.println("Home -  user.getLoginId() = " + userId);
        model.addAttribute("userID", userId);
        model.addAttribute("members", memberService.findAll());
        return "home";
    }
}
