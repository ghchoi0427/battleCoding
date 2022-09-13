package com.dku.dandev.repository;

import com.dku.dandev.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

    List<Board> findBoardByWriterId(Long writerId);

}
