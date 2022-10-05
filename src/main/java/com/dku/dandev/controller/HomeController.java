package com.dku.dandev.controller;

import com.dku.dandev.service.MemberService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

    private final MemberService memberService;

    public HomeController(MemberService memberService) {
        this.memberService = memberService;
    }
}
