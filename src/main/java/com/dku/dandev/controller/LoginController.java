package com.dku.dandev.controller;

import com.dku.dandev.domain.Member;
import com.dku.dandev.dto.LoginForm;
import com.dku.dandev.dto.MemberDto;
import com.dku.dandev.service.MemberService;
import com.dku.dandev.session.SessionConst;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;

@Controller
public class LoginController {

    private final MemberService memberService;

    public LoginController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/memberInfo")
    public List<MemberDto> viewMembers() {
        return memberService.findAll();
    }

    @GetMapping("/tempLogin")
    public String tempLogin(HttpServletResponse response) {
        String id = UUID.randomUUID().toString().split("-")[0];
        memberService.saveMember(new MemberDto(id, "pw"));
        setCookie(response, id);
        return "redirect:/home";
    }

    private void setCookie(HttpServletResponse response, String id) {
        Cookie cookie = new Cookie("userId", id);
        response.addCookie(cookie);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginForm form, BindingResult bindingResult, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Member loginMember = memberService.login(form.getLoginId(), form.getPassword());
        if (loginMember == null) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return new ResponseEntity<>("로그인 실패", HttpStatus.OK);
        }
        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);
        return new ResponseEntity<>("로그인 성공", HttpStatus.OK);
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("member/{memberId}")
    public MemberDto getMemberInfo(@PathVariable Long memberId) {
        return MemberDto.of(memberService.getMemberById(memberId));
    }

    @PostMapping("/signup")
    public ResponseEntity<Void> save(@RequestBody MemberDto memberDto, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        memberService.saveMember(memberDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
