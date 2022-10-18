package com.dku.dandev.dto;

import com.dku.dandev.domain.Problem;
import com.dku.dandev.domain.Testcase;

import java.util.List;

public class ProblemTestcaseDto {
    Problem problem;
    List<Testcase> testcases;

    public ProblemTestcaseDto(Problem problem, List<Testcase> testcases) {
        this.problem = problem;
        this.testcases = testcases;
    }

    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    public List<Testcase> getTestcases() {
        return testcases;
    }

    public void setTestcases(List<Testcase> testcases) {
        this.testcases = testcases;
    }
}
