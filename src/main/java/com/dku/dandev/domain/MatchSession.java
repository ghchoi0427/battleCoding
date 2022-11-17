package com.dku.dandev.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 경기 진행동안 필요한 정보를 담은 엔티티
 */
@Entity
public class MatchSession {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String matchId;
    private Long problemId;
    private String hostId;
    private String guestId;

    public MatchSession() {
    }

    public MatchSession(String matchId, Long problemId, String hostId, String guestId) {
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

    public String getHostId() {
        return hostId;
    }

    public void setHostId(String hostId) {
        this.hostId = hostId;
    }

    public String getGuestId() {
        return guestId;
    }

    public void setGuestId(String guestId) {
        this.guestId = guestId;
    }
}
