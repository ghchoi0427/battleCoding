package com.dku.dandev.service;

import com.dku.dandev.domain.HeadToHead;
import com.dku.dandev.domain.MatchRecord;
import com.dku.dandev.domain.MatchSession;
import com.dku.dandev.domain.Problem;
import com.dku.dandev.repository.HeadToHeadRepository;
import com.dku.dandev.repository.MatchRecordRepository;
import com.dku.dandev.repository.MatchSessionRepository;
import com.dku.dandev.repository.ProblemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class MatchService {

    private final MatchRecordRepository matchRecordRepository;
    private final ProblemRepository problemRepository;
    private final MatchSessionRepository matchSessionRepository;
    private final HeadToHeadRepository headToHeadRepository;

    public MatchService(MatchRecordRepository matchRecordRepository, ProblemRepository problemRepository, MatchSessionRepository matchSessionRepository, HeadToHeadRepository headToHeadRepository) {
        this.matchRecordRepository = matchRecordRepository;
        this.problemRepository = problemRepository;
        this.matchSessionRepository = matchSessionRepository;
        this.headToHeadRepository = headToHeadRepository;
    }

    public void saveMatchRecord(MatchRecord matchRecord) {
        matchRecordRepository.save(matchRecord);
    }

    public MatchRecord getMatchRecord(Long matchRecordId) {
        if (matchRecordRepository.findById(matchRecordId).isPresent()) {
            return matchRecordRepository.findById(matchRecordId).get();
        } else return null;
    }

    public Long getRandomProblem() {
        List<Problem> problems = problemRepository.findAll();
        if (problems.size() == 0) {
            return null;
        }
        return problems.get(new Random().nextInt(problems.size())).getId();
    }

    public Long saveProblem(Problem problem) {
        Problem save = problemRepository.save(problem);
        return save.getId();
    }

    public void saveMatchSession(MatchSession matchSession) {
        matchSessionRepository.save(matchSession);
    }

    public MatchSession getMatchSession(String matchSessionId) {
        if (matchSessionRepository.findById(matchSessionId).isPresent()) {
            return matchSessionRepository.findById(matchSessionId).get();
        } else {
            return null;
        }
    }

    public void saveHeadToHead(HeadToHead headToHead) {
        headToHeadRepository.save(headToHead);
    }
}
