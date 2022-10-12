package com.dku.dandev.service;

import com.dku.dandev.domain.Member;
import com.dku.dandev.dto.MemberDto;
import com.dku.dandev.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    private final MemberRepository memberRepository;

    public LoginService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member login(String loginId, String password) {

        Optional<Member> member = memberRepository.findMemberByLoginId(loginId);
        return member
                .filter(m -> m.getPassword().equals(password))
                .orElse(null);
    }

}
