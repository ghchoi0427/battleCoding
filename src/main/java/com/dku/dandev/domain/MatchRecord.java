package com.dku.dandev.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MatchRecord {
    @Id
    private Long id;
    private Long memberId; // 대결을 신청한 사람의 ID
    private Long opponentId; // 대결을 수락한 사람의 ID
    private MatchResult matchResult;    //대결을 신청한 사람 기준으로 승패여부

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getOpponentId() {
        return opponentId;
    }

    public void setOpponentId(Long opponentId) {
        this.opponentId = opponentId;
    }

    public MatchResult getMatchResult() {
        return matchResult;
    }

    public void setMatchResult(MatchResult matchResult) {
        this.matchResult = matchResult;
    }
}
