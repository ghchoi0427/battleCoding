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
}
