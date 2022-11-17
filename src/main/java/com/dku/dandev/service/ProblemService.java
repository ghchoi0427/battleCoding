package com.dku.dandev.service;

import com.dku.dandev.domain.Problem;
import com.dku.dandev.domain.Submission;
import com.dku.dandev.domain.Testcase;
import com.dku.dandev.repository.ProblemRepository;
import com.dku.dandev.repository.SubmissionRepository;
import com.dku.dandev.repository.TestcaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProblemService {

    private final ProblemRepository problemRepository;
    private final SubmissionRepository submissionRepository;
    private final TestcaseRepository testcaseRepository;

    public ProblemService(ProblemRepository problemRepository, SubmissionRepository submissionRepository, TestcaseRepository testcaseRepository) {
        this.problemRepository = problemRepository;
        this.submissionRepository = submissionRepository;
        this.testcaseRepository = testcaseRepository;
    }

    public Long saveSubmission(Submission submission) {
        Submission save = submissionRepository.save(submission);
        return save.getId();
    }

    public List<Testcase> findTestcasesByProblemId(Long problemId) {
        return testcaseRepository.findTestcasesByProblemId(problemId);
    }

    public void saveTestcase(Testcase testcase) {
        testcaseRepository.save(testcase);
    }

    public Problem findProblem(Long id) {
        return problemRepository.findById(id).get();
    }

}
