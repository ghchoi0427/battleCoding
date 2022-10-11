package com.dku.dandev.controller;

import com.dku.dandev.dto.MemberDto;
import com.dku.dandev.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/{memberId}")
    public MemberDto getMemberInfo(@PathVariable Long memberId) {
        return MemberDto.of(memberService.getMemberById(memberId));
    }
}
