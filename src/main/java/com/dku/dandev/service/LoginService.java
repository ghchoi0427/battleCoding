package com.dku.dandev.service;

import com.dku.dandev.dto.MemberDto;
import com.dku.dandev.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final MemberRepository memberRepository;

    public LoginService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public MemberDto login(String loginId, String password) {
        return memberRepository.findByLoginId(loginId)
                .filter(m -> m.getPassword().equals(password))
                .orElse(null); //TODO: JPA 사용법 숙지 후 메서드 구현
    }
}
