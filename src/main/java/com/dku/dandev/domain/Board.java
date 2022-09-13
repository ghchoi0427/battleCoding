package com.dku.dandev.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Board {
    @Id
    @GeneratedValue
    private Long id;
    private Long writerId;
    private String title;
    private String content;
    private int likes;

    public Board() {
    }

    public Board(Long writerId, String title, String content, int likes) {
        this.writerId = writerId;
        this.title = title;
        this.content = content;
        this.likes = likes;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Long getWriterId() {
        return writerId;
    }

    public void setWriterId(Long writerId) {
        this.writerId = writerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
