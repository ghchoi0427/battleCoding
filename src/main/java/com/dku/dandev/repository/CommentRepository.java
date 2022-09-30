package com.dku.dandev.repository;

import com.dku.dandev.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findCommentsByBoardId(Long boardId);
}
