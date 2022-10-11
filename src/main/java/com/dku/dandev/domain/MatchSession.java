package com.dku.dandev.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MatchSession {
    @Id
    private String matchId;
    private Long problemId;
    private Long hostId;
    private Long guestId;

    public MatchSession() {
    }

    public MatchSession(String matchId, Long problemId, Long hostId, Long guestId) {
        this.matchId = matchId;
        this.problemId = problemId;
        this.hostId = hostId;
        this.guestId = guestId;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public Long getProblemId() {
        return problemId;
    }

    public void setProblemId(Long problemId) {
        this.problemId = problemId;
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
}
