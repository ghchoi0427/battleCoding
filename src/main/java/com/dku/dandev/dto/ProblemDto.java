package com.dku.dandev.dto;

import com.dku.dandev.domain.Problem;

import javax.persistence.Lob;

public class ProblemDto {
    @Lob
    private String question;
    @Lob
    private String example;

    public ProblemDto(String question, String example) {
        this.question = question;
        this.example = example;
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

    public static ProblemDto of(Problem problem) {
        return new ProblemDto(problem.getQuestion(), problem.getExample());
    }
}
