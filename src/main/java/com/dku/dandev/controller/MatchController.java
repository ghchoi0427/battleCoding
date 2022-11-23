package com.dku.dandev.controller;

import com.dku.dandev.domain.*;
import com.dku.dandev.dto.MatchRequestDto;
import com.dku.dandev.service.MatchService;
import com.dku.dandev.service.ProblemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.UUID;

@Controller
@RequestMapping("/match")
public class MatchController {

    private final MatchService matchService;
    private final ProblemService problemService;

    public MatchController(MatchService matchService, ProblemService problemService) {
        this.matchService = matchService;
        this.problemService = problemService;
    }

    @PostMapping("/new")
    public ResponseEntity<MatchSession> matchRequest(@RequestBody MatchRequestDto matchRequest) {
        String matchId = getMatchId();
        if (matchService.getRandomProblem() == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            MatchSession matchSession = new MatchSession(matchId, matchService.getRandomProblem(), matchRequest.getHost(), matchRequest.getGuest());
            matchService.saveMatchSession(matchSession);
            return new ResponseEntity<>(matchSession, HttpStatus.OK);
        }
    }

    @GetMapping("/{matchId}")
    public String enterMatch(@PathVariable String matchId, Model model, HttpServletRequest request) {
        model.addAttribute("matchSession", matchService.getMatchSession(matchId));
        Cookie[] cookies = request.getCookies();
        String userId = Arrays.stream(cookies).filter(e -> e.getName().equals("userId")).map(Cookie::getValue).findFirst().get();
        model.addAttribute("userId", userId);
        model.addAttribute("matchId", matchId);
        return "match";
    }

    @ResponseBody
    @GetMapping("/{matchId}/problem")
    public Problem getProblem(@PathVariable String matchId, Model model) {
        model.addAttribute("matchId", matchId);
        MatchSession matchSession = matchService.getMatchSession(matchId);
        Long problemId = matchSession.getProblemId();
        if (matchSession.getProblemId() == null) {
            return null;
        }
        return problemService.findProblem(problemId);
    }

    @PostMapping("/save")
    public void saveMatchRecord(@RequestBody MatchRecord matchRecord) {
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
