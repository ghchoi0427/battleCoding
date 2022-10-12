package com.dku.dandev.controller;

import com.dku.dandev.dto.MemberDto;
import com.dku.dandev.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/signup")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    public ResponseEntity<?> save(@ModelAttribute MemberDto memberDto, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        memberService.saveMember(memberDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{memberId}")
    public MemberDto getMemberInfo(@PathVariable Long memberId) {
        return MemberDto.of(memberService.getMemberById(memberId));
    }
}
