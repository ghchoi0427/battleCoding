package com.dku.dandev.domain;

public class SystemMessage {

    public enum MessageType {
        ENTER, GAME_START, GAME_END, UPDATE_SCORE, ARRIVED
    }

    private MessageType messageType;
    private String matchId;
    private String sender;
    private String body;

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

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
