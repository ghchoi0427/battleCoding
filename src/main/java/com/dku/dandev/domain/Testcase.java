package com.dku.dandev.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Testcase {
    @Id
    @GeneratedValue
    private Long id;
    private String input;
    private String output;
    @ManyToOne
    private Problem problem;

    public Testcase() {
    }

    public Testcase(String input, String output, Problem problem) {
        this.input = input;
        this.output = output;
        this.problem = problem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Object getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public Object getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }
}
