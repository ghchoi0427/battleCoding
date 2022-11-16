package com.dku.dandev.domain;

import com.sun.istack.NotNull;

public class MatchRequestMessage {
    @NotNull
    private String sender;
    private String receiver;
    private String matchId;

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        if (!receiver.equals(sender)) {
            this.receiver = receiver;
        }
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }
}
