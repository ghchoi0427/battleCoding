package com.dku.dandev.dto;

import com.dku.dandev.domain.Member;

public class MemberDto {
    private Long id;
    private String name;

    public MemberDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static MemberDto of(Member member) {
        return new MemberDto(member.getId(), member.getName());
    }
}
