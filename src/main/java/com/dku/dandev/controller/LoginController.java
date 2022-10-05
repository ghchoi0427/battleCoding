package com.dku.dandev.controller;

import com.dku.dandev.dto.MemberDto;
import com.dku.dandev.service.MemberService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final MemberService memberService;

    public LoginController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("")
    public void login(@ModelAttribute MemberDto dto) {
        memberService.saveMember(dto);
    }

}
