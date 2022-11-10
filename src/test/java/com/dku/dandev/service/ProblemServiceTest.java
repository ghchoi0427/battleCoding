package com.dku.dandev.service;

import com.dku.dandev.domain.Problem;
import com.dku.dandev.domain.Testcase;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class ProblemServiceTest {

    @Autowired
    ProblemService problemService;
    @Autowired
    MatchService matchService;

    @Test
    void save() {
        String question = "두 개의 숫자를 입력받아 더한 값을 출력하는 프로그램을 작성하시오";
        String example = "입력: \"1 2\", 출력: \"3\"";
        Problem problem = new Problem(question, example);
        Long problemId = matchService.saveProblem(problem);
        problemService.saveTestcase(new Testcase("1 2", "3", problemId));
        problemService.saveTestcase(new Testcase("10 20", "30", problemId));
        problemService.saveTestcase(new Testcase("4 5", "9", problemId));
        System.out.println("problem added");

        Assertions.assertThat(problemService.findTestcasesByProblemId(problemId)).isNotNull();
    }


}