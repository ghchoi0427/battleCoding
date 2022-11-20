package com.dku.dandev.controller;

import com.dku.dandev.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
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
        Cookie[] cookies = request.getCookies();
        String userID = Arrays.stream(cookies).filter(e -> e.getName().equals("userId")).map(Cookie::getValue).findFirst().get();

        model.addAttribute("userID", userID);
        model.addAttribute("members", memberService.findAll());
        return "home";
    }
}
