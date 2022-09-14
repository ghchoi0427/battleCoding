package com.dku.dandev.service;

import com.dku.dandev.domain.Board;
import com.dku.dandev.domain.Comment;
import com.dku.dandev.dto.BoardDto;
import com.dku.dandev.repository.BoardRepository;
import com.dku.dandev.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    private final BoardRepository repository;
    private final CommentRepository commentRepository;

    public BoardService(BoardRepository repository, CommentRepository commentRepository) {
        this.repository = repository;
        this.commentRepository = commentRepository;
    }

    public List<Board> findAll() {
        return repository.findAll();
    }

    public void saveBoard(BoardDto dto) {
        Board board = new Board(dto.getWriterId(), dto.getTitle(), dto.getContent(), dto.getLikes());
        repository.save(board);
    }

    public Optional<BoardDto> getBoardById(Long id) {
        return Optional.of(BoardDto.of(repository.findBoardById(id).get()));
    }

    public void updateBoard(Long id, BoardDto dto) {
        Board board = repository.findBoardById(id).orElseThrow(() -> new IllegalArgumentException("해당 ID의 게시글이 존재하지 않습니다."));
        board.update(dto.getTitle(), dto.getContent());
        repository.save(board);
    }

    public void deleteBoard(Long id) {
        repository.deleteById(id);
    }

    public List<Board> getPostsByWriter(Long writerId) {
        return repository.findBoardsByWriterId(writerId);
    }

    public List<Comment> getComments(Long id) {
        return commentRepository.findCommentsByBoardId(id);
    }
}
