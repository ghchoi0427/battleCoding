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
    public String loginForm(@ModelAttribute("loginForm") LoginForm loginForm, Model model) {
        System.out.println("call");
        model.addAttribute("loginForm", loginForm);
        return "/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginForm loginForm, BindingResult bindingResult, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            System.out.println("error");
            return "/login";
        }
        System.out.println(loginForm.getLoginId());
        System.out.println(loginForm.getPassword());
        Member loginMember = memberService.login(loginForm.getLoginId(), loginForm.getPassword());
        if (loginMember == null) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            System.out.println("login fail");
            return "/login";
        }
        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);
        System.out.println("complete");
        return "redirect:/home";
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

    @GetMapping("/signup")
    public String signUpForm(Model model) {
        model.addAttribute("member", new MemberDto());
        return "signup";
    }

    @PostMapping("/signup")
    public String save(@ModelAttribute("member") MemberDto memberDto, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("error");
            return "/signup";
        }
        memberService.saveMember(memberDto);
        System.out.println(memberDto.getLoginId());
        System.out.println(memberDto.getPassword());
        return "redirect:/login";
    }
}
