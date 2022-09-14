package com.dku.dandev.dto;

import com.dku.dandev.domain.Member;

public class MemberDto {
    private String name;
    private String password;

    public MemberDto(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static MemberDto of(Member member) {
        return new MemberDto(member.getName(), member.getPassword());
    }
}
