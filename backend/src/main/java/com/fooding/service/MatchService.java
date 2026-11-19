package com.fooding.service;

import com.fooding.model.Match;
import com.fooding.repository.MatchRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatchService {

    private final MatchRepository matchRepo;

    public MatchService(MatchRepository matchRepo) {
        this.matchRepo = matchRepo;
    }

    // 거래 저장 (나눔 또는 교환)
    public Match save(Match match) {
        return matchRepo.save(match);
    }

    // 전체 거래 기록
    public List<Match> findAll() {
        return matchRepo.findAll();
    }

    // 거래 ID로 조회
    public Optional<Match> findById(Long id) {
        return matchRepo.findById(id);
    }

    // 삭제
    public void delete(Long id) {
        matchRepo.deleteById(id);
    }
}
