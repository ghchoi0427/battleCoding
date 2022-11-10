package com.dku.dandev.service;

import com.dku.dandev.domain.MatchRecord;
import com.dku.dandev.domain.MatchResult;
import com.dku.dandev.domain.Problem;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

@SpringBootTest
class MatchServiceTest {

    @Autowired
    MatchService matchService;

    @Test
    void creation() {

    }

    @Test
    void uuid_로_pk지정() {
        MatchRecord matchRecord = new MatchRecord();
        long presetPK = (new Random()).nextLong();
        System.out.println("presetPK = " + presetPK);
        matchRecord.setId(presetPK);
        matchRecord.setMatchResult(MatchResult.win);
        matchRecord.setMemberId(12L);
        matchRecord.setOpponentId(34L);

        matchService.saveMatchRecord(matchRecord);

        Assertions.assertThat(matchService.getMatchRecord(presetPK).getId()).isEqualTo(presetPK);
    }

    @Test
    void 랜덤문제() {
        Problem p1 = new Problem("q","a");
        Problem p2 = new Problem("q","a");
        Problem p3 = new Problem("q","a");

        matchService.saveProblem(p1);
        matchService.saveProblem(p2);
        matchService.saveProblem(p3);

        Assertions.assertThat(matchService.getRandomProblem()).isNotNull();
    }

}