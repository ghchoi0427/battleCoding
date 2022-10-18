package com.dku.dandev.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

/**
 * 알고리즘 문제의 테스트케이스 엔티티
 * Problem과 다대일 관계를 갖는다.
 */
@Entity
public class Testcase {
    @Id
    @GeneratedValue
    private Long id;
    @Lob
    private String input;
    @Lob
    private String output;
    private Long problemId;

    public Testcase() {
    }

    public Testcase(String input, String output, Long problemId) {
        this.input = input;
        this.output = output;
        this.problemId = problemId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public Long getProblemId() {
        return problemId;
    }

    public void setProblemId(Long problemId) {
        this.problemId = problemId;
    }
}
