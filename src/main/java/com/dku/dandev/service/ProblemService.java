package com.dku.dandev.service;

import com.dku.dandev.domain.Submission;
import com.dku.dandev.repository.ProblemRepository;
import com.dku.dandev.repository.SubmissionRepository;
import org.springframework.stereotype.Service;

@Service
public class ProblemService {

    private final ProblemRepository problemRepository;
    private final SubmissionRepository submissionRepository;

    public ProblemService(ProblemRepository problemRepository, SubmissionRepository submissionRepository) {
        this.problemRepository = problemRepository;
        this.submissionRepository = submissionRepository;
    }

    public Long saveSubmission(Submission submission) {
        Submission save = submissionRepository.save(submission);
        return save.getId();
    }


}
