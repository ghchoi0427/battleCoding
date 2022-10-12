package com.dku.dandev.dto;

public class MatchRequestDto {
    private Long host;
    private Long guest;

    public Long getHost() {
        return host;
    }

    public void setHost(Long host) {
        this.host = host;
    }

    public Long getGuest() {
        return guest;
    }

    public void setGuest(Long guest) {
        this.guest = guest;
    }
}
