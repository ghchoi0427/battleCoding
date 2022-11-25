package com.dku.dandev.controller;

import com.dku.dandev.dto.MemberDto;
import com.dku.dandev.service.MemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {

    private final MemberService memberService;

    public HomeController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("")
    public List<MemberDto> home() {
        return memberService.findAll();
    }

    @GetMapping("/test")
    public String homeTest() {
        //push trigger test #9
        return "autonomous build #9";
    }
}
