package com.dku.dandev.controller;

import com.dku.dandev.domain.GradingEntity;
import com.dku.dandev.domain.Problem;
import com.dku.dandev.domain.TestStatus;
import com.dku.dandev.dto.ProblemTestcaseDto;
import com.dku.dandev.dto.SubmissionDto;
import com.dku.dandev.service.ProblemService;
import com.dku.dandev.util.Crawler;
import com.dku.dandev.util.TestRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

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
    public ResponseEntity<GradingEntity<TestStatus>> submit(@RequestBody SubmissionDto submissionDto) throws IOException {
        String code = submissionDto.getCode();
        Long problemId = submissionDto.getProblemId();
        GradingEntity<TestStatus> testResult = testRunner.runTest(code, problemService.findTestcasesByProblemId(problemId));
        return new ResponseEntity<>(testResult, HttpStatus.OK);
    }

    @GetMapping("/crawl")
    public ResponseEntity<HttpStatus> crawlProblems(@RequestParam(defaultValue = "1000") int start, @RequestParam(defaultValue = "1010") int end) {
        Crawler crawler = new Crawler(problemService);
        crawler.crawlProblems(start, end);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Problem>> getProblemsList() {
        return new ResponseEntity<>(problemService.getAllProblems(), HttpStatus.OK);
    }

    @GetMapping("/listall")
    public ResponseEntity<List<ProblemTestcaseDto>> getProblemsAndTestcases() {
        List<ProblemTestcaseDto> dtos = problemService.getAllProblems()
                .stream()
                .map(e -> new ProblemTestcaseDto(e, problemService.findTestcasesByProblemId(e.getId()))).collect(Collectors.toList());
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

}
