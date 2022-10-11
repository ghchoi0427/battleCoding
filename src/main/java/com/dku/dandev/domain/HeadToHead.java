package com.dku.dandev.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
/**
 * 상대 전적을 나타내는 클래스
 * 경기가 끝난 후 참가자 각각이 HeadToHead 기록을 따로 갖게 된다.
 * ex) A와 B가 겨뤄 A가 이겼을 경우
 * A는 MatchResult가 win인 HeadToHead 기록을, B는 lose인 기록을 갖는다.
 *
 * 과연 필요할까?
 */
public class HeadToHead {
    @Id
    @GeneratedValue
    private Long id;
    private Long memberId;
    private Long opponentId;
    private MatchResult matchResult;

    public HeadToHead() {
    }

    public HeadToHead(Long memberId, Long opponentId, MatchResult matchResult) {
        this.memberId = memberId;
        this.opponentId = opponentId;
        this.matchResult = matchResult;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
