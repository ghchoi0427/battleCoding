package com.dku.dandev.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Testcase {
    @Id
    private Long id;
    private Object input;
    private Object output;
    @ManyToOne
    private Problem problem;

    public Testcase() {
    }

    public Testcase(Object input, Object output, Problem problem) {
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

    public void setInput(Object input) {
        this.input = input;
    }

    public Object getOutput() {
        return output;
    }

    public void setOutput(Object output) {
        this.output = output;
    }

    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }
}
