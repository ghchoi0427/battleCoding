package com.dku.dandev.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Board {
    private Long id;
    private Long writerId;
    private String title;
    private String content;
    private int likes;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
