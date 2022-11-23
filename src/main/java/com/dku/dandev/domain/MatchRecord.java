package com.dku.dandev.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 경기 결과를 담는 엔티티
 */
@Entity
public class MatchRecord {
    @Id
    @GeneratedValue
    private Long id;
    private String memberId; // 대결을 신청한 사람의 ID
    private String opponentId; // 대결을 수락한 사람의 ID
    private MatchResult matchResult;    //대결을 신청한 사람 기준으로 승패여부

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getOpponentId() {
        return opponentId;
    }

    public void setOpponentId(String opponentId) {
        this.opponentId = opponentId;
    }

    public MatchResult getMatchResult() {
        return matchResult;
    }

    public void setMatchResult(MatchResult matchResult) {
        this.matchResult = matchResult;
    }
}
