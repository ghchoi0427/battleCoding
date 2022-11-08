package com.dku.dandev.domain;

public class SystemMessage {

    public enum MessageType{
        ENTER, GAME_START, GAME_END, UPDATE_SCORE
    }

    private MessageType messageType;
    private String matchId;
    private Long sender;

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public Long getSender() {
        return sender;
    }

    public void setSender(Long sender) {
        this.sender = sender;
    }
}
