package com.dku.dandev.controller;

import com.dku.dandev.domain.Member;
import com.dku.dandev.dto.MemberDto;
import com.dku.dandev.repository.MemberRepository;
import com.dku.dandev.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/signup")
public class MemberController {

    private final MemberService memberService;

    public MemberController (MemberService memberService){
        this.memberService = memberService;
    }


    @GetMapping("/signup")
    public String addForm(@ModelAttribute("member") MemberDto memberDto) // TODO: 모델에트리뷰트 쌍따옴표 멤버 맞는지
    {
        return "/signup";
    }

    @PostMapping("/signup")
    public String save(@ModelAttribute MemberDto memberDto, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/signup"; // TODO: 나중에 검토 필요
        }

        memberService.saveMember(memberDto);
        return "redirect:/";
    }
    //TODO: 테스트 필요
}
