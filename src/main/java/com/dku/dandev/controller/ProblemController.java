package com.dku.dandev.controller;

import com.dku.dandev.domain.GradingEntity;
import com.dku.dandev.domain.TestStatus;
import com.dku.dandev.dto.SubmissionDto;
import com.dku.dandev.service.ProblemService;
import com.dku.dandev.util.TestRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/problem")
public class ProblemController {

    private final ProblemService problemService;
    private final TestRunner testRunner;

    public ProblemController(ProblemService problemService, TestRunner testRunner) {
        this.problemService = problemService;
        this.testRunner = testRunner;
    }

    @PostMapping("/submit")
    public ResponseEntity<GradingEntity<TestStatus>> submit(@ModelAttribute SubmissionDto submissionDto) throws IOException {
        String code = submissionDto.getCode();
        Long problemId = submissionDto.getProblemId();
        GradingEntity<TestStatus> testResult = testRunner.runTest(code, problemService.findTestcasesByProblemId(problemId));
        return new ResponseEntity<>(testResult, HttpStatus.OK);
    }
}
