package com.dku.dandev.service;

import com.dku.dandev.domain.Member;
import com.dku.dandev.dto.MemberDto;
import com.dku.dandev.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberService{

    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public void saveMember(MemberDto dto) {
        Member member = new Member(dto.getName());
        repository.save(member);
    }

    public Member getMemberById(MemberDto dto) {
        return repository.findMemberById(dto.getId());
    }

    public List<MemberDto> findAll() {
        return repository.findAll().stream().map(MemberDto::of).collect(Collectors.toList());
    }
}
