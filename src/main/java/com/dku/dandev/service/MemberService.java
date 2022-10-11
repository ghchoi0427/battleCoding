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
        repository.save(new Member(dto.getName(), dto.getPassword()));
    }

    public Member getMemberById(Member member) {
        return repository.findMemberById(member.getId());
    }

    public List<MemberDto> findAll() {
        return repository.findAll().stream().map(MemberDto::of).collect(Collectors.toList());
    }
}
