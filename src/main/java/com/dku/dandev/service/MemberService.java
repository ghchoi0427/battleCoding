package com.dku.dandev.service;

import com.dku.dandev.domain.Member;
import com.dku.dandev.dto.MemberDto;
import com.dku.dandev.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MemberService{

    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public void saveMember(MemberDto dto) {
        repository.save(new Member(dto.getLoginId(), dto.getPassword()));
    }

    public Member getMemberById(Long memberId) {
        return repository.findMemberById(memberId);
    }

    public List<MemberDto> findAll() {
        return repository.findAll().stream().map(MemberDto::of).collect(Collectors.toList());
    }

    public Member login(String loginId, String password) {
        Optional<Member> member = repository.findMemberByLoginId(loginId);
        return member.filter(m -> m.getPassword().equals(password)).orElse(null);
    }
}
