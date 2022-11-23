package com.dku.dandev.controller;

import com.dku.dandev.domain.Member;
import com.dku.dandev.dto.LoginForm;
import com.dku.dandev.dto.MemberDto;
import com.dku.dandev.service.MemberService;
import com.dku.dandev.session.SessionConst;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    private final MemberService memberService;

    public LoginController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/login")
    public String loginForm(@ModelAttribute("loginForm") LoginForm form) {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginForm form, BindingResult bindingResult, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            return "/login";
        }
        Member loginMember = memberService.login(form.getLoginId(), form.getPassword());
        if (loginMember == null) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "/login";
        }
        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);
        return "/home";
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "/login";
    }

    @GetMapping("member/{memberId}")
    public String getMemberInfo(@PathVariable Long memberId, Model model) {
        MemberDto memberDto = MemberDto.of(memberService.getMemberById(memberId));
        model.addAttribute("modelDto", memberDto);
        return "";
        //TODO: 멤버정보 템플릿 만들기
    }

    @PostMapping("/signup")
    public String save(@RequestBody MemberDto memberDto, BindingResult result) {
        if (result.hasErrors()) {
            return "/signup";
        }
        memberService.saveMember(memberDto);
        return "/login";
    }
}
