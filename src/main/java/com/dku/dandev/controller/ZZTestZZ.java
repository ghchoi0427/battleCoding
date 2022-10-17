package com.dku.dandev.controller;

import com.dku.dandev.domain.Problem;
import com.dku.dandev.domain.Testcase;
import com.dku.dandev.service.MatchService;
import com.dku.dandev.service.ProblemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZZTestZZ {

    private final ProblemService problemService;
    private final MatchService matchService;

    public ZZTestZZ(ProblemService problemService, MatchService matchService) {
        this.problemService = problemService;
        this.matchService = matchService;
    }

    @GetMapping("/addProblem")
    public String addProblem() {
        String question = "두 개의 숫자를 입력받아 더한 값을 출력하는 프로그램을 작성하시오";
        String example = "입력: \"1 2\", 출력: \"3\"";
        Problem problem = new Problem(question, example);
        Long problemId = matchService.saveProblem(problem);
        problemService.saveTestcase(new Testcase("1 2", "3", problemId));
        problemService.saveTestcase(new Testcase("10 20", "30", problemId));
        problemService.saveTestcase(new Testcase("4 5", "9", problemId));
        System.out.println("problem added");
        return "problem added";
    }
}
