package com.dku.dandev.repository;

import com.dku.dandev.domain.MatchSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchSessionRepository extends JpaRepository<MatchSession, String> {
}
