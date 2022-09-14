package com.dku.dandev.dto;

import com.dku.dandev.domain.Board;

public class BoardDto {
    private Long writerId;
    private String title;
    private String content;
    private int likes;

    public BoardDto(Long writerId, String title, String content, int likes) {
        this.writerId = writerId;
        this.title = title;
        this.content = content;
        this.likes = likes;
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

    public static BoardDto of(Board board) {
        return new BoardDto(board.getWriterId(), board.getTitle(), board.getContent(), board.getLikes());
    }
}
