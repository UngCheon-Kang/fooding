package com.fooding.repository;

import com.fooding.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;

// 나눔/교환 거래 내역을 처리하는 인터페이스
public interface MatchRepository extends JpaRepository<Match, Long> {

}
