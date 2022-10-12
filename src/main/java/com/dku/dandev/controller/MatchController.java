package com.dku.dandev.controller;

import com.dku.dandev.domain.*;
import com.dku.dandev.dto.MatchRequestDto;
import com.dku.dandev.service.MatchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/match")
public class MatchController {

    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @PostMapping("/new")
    public ResponseEntity<MatchSession> matchRequest(@ModelAttribute MatchRequestDto matchRequest, HttpServletResponse response) throws IOException {
        String matchId = getMatchId();
        if (matchService.getRandomProblem() == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            MatchSession matchSession = new MatchSession(matchId, matchService.getRandomProblem().getId(), matchRequest.getHost(), matchRequest.getGuest());
            matchService.saveMatchSession(matchSession);
            response.sendRedirect("/match/" + matchId);
            return new ResponseEntity<>(matchSession, HttpStatus.OK);
        }
    }

    @GetMapping("/{matchId}")
    public MatchSession enterMatch(@PathVariable String matchId) {
        return matchService.getMatchSession(matchId);
    }

    @PostMapping("/save")
    public void saveMatchRecord(@ModelAttribute MatchRecord matchRecord) {
        saveHeadToHead(matchRecord);//TODO: HeadToHead 필요한가
        matchService.saveMatchRecord(matchRecord);
    }

    @GetMapping("/result/{matchResultId}")
    public MatchRecord matchResult(@PathVariable Long matchResultId) {
        return matchService.getMatchRecord(matchResultId);
    }

    private String getMatchId() {
        return UUID.randomUUID().toString().split("-")[0];
    }

    private void saveHeadToHead(MatchRecord matchRecord) {
        Long host = matchRecord.getMemberId();
        Long guest = matchRecord.getOpponentId();
        matchService.saveHeadToHead(new HeadToHead(host, guest, matchRecord.getMatchResult()));
        if (matchRecord.getMatchResult() == MatchResult.draw) {
            matchService.saveHeadToHead(new HeadToHead(guest, host, MatchResult.draw));
        } else if (matchRecord.getMatchResult() == MatchResult.win) {
            matchService.saveHeadToHead(new HeadToHead(guest, host, MatchResult.lose));
        } else if (matchRecord.getMatchResult() == MatchResult.lose) {
            matchService.saveHeadToHead(new HeadToHead(guest, host, MatchResult.win));
        }
    }
}
