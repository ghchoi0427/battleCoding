package com.dku.dandev.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MatchRecord {
    @Id
    private Long id;
    private Long hostId;
    private Long guestId;
    private MatchResult result;

    public MatchRecord() {}

    public MatchRecord(Long hostId, Long guestId, MatchResult result) {
        this.hostId = hostId;
        this.guestId = guestId;
        this.result = result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
