package com.dku.dandev.dto;

import com.dku.dandev.domain.Member;

public class MemberDto {
    private String loginId;
    private String password;

    public MemberDto(String loginId, String password) {
        this.loginId = loginId;
        this.password = password;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static MemberDto of(Member member) {
        return new MemberDto(member.getLoginId(), member.getPassword());
    }
}
