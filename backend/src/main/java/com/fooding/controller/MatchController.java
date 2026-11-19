package com.fooding.controller;

import com.fooding.model.Match;
import com.fooding.service.MatchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/matches")
public class MatchController {

    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    // 거래 등록
    @PostMapping
    public Match createMatch(@RequestBody Match match) {
        return matchService.save(match);
    }

    // 전체 거래 조회
    @GetMapping
    public List<Match> getAllMatches() {
        return matchService.findAll();
    }

    // 거래 ID로 조회
    @GetMapping("/{id}")
    public Optional<Match> getMatchById(@PathVariable Long id) {
        return matchService.findById(id);
    }

    // 거래 삭제
    @DeleteMapping("/{id}")
    public void deleteMatch(@PathVariable Long id) {
        matchService.delete(id);
    }
}
