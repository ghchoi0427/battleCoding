package com.dku.dandev.dto;

import com.dku.dandev.domain.MatchResult;
import com.dku.dandev.domain.Member;

import javax.persistence.Entity;
import javax.persistence.Id;

public class MatchRecordDto {
    private Long hostId;
    private Long guestId;
    private MatchResult result;


    public MatchRecordDto(Long hostId, Long guestId, MatchResult result) {
        this.hostId = hostId;
        this.guestId = guestId;
        this.result = result;
    }

    public Long getHostId() {
        return hostId;
    }

    public void setHostId(Long hostId) {
        this.hostId = hostId;
    }

    public Long getGuestId() {
        return guestId;
    }

    public void setGuestId(Long guestId) {
        this.guestId = guestId;
    }

    public MatchResult getResult() {
        return result;
    }

    public void setResult(MatchResult result) {
        this.result = result;
    }

    public static MatchRecordDto of(MatchRecordDto matchRecordDto) {
        return new MatchRecordDto(matchRecordDto.getHostId(), matchRecordDto.getGuestId(), matchRecordDto.getResult());
    }
}

