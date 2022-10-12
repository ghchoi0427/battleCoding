package com.dku.dandev.repository;

import com.dku.dandev.domain.Testcase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestcaseRepository extends JpaRepository<Testcase, Long> {
    List<Testcase> findTestcasesByProblemId(Long problemId);
}
