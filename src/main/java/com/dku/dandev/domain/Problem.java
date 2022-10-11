package com.dku.dandev.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Problem {
    @Id
    @GeneratedValue
    private Long id;
    @Lob
    private String question;
    @Lob
    private String example;

    public Problem() {
    }

    public Problem(String question, String example) {
        this.question = question;
        this.example = example;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }
}
