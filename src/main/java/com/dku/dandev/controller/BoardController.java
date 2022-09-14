package com.dku.dandev.controller;

import com.dku.dandev.domain.Board;
import com.dku.dandev.domain.Comment;
import com.dku.dandev.dto.BoardDto;
import com.dku.dandev.service.BoardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class BoardController {

    private BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("")//전체 리스트
    public List<Board> boardList() {
        return boardService.findAll();
    }

    @PostMapping("")//게시물 등록
    public void createBoard(@ModelAttribute BoardDto dto) {
        boardService.saveBoard(dto);
    }

    @GetMapping("/{id}")//게시물 조회
    public Optional<BoardDto> readBoard(@PathVariable Long id) {
        return boardService.getBoardById(id);
    }

    @PostMapping("/{id}")//게시글 수정
    public void updateBoard(@PathVariable Long id, @ModelAttribute BoardDto dto) {
        boardService.updateBoard(id, dto);
    }

    @DeleteMapping("/{id}")//게시글 삭제
    public void deleteBoard(@PathVariable Long id) {
        boardService.deleteBoard(id);
    }

    @GetMapping("/{id}/comments")
    public List<Comment> loadComments(@PathVariable Long id) {
        return boardService.getComments(id);
    }

    //@PostConstruct
    public void postConstruct() {
        for (int i = 0; i < 1000; i++) {
            Board board = new Board();
            board.setId((long) i);
            board.setTitle("title" + i);
            board.setWriterId((long) i + 1);
            board.setContent("this is content" + i);
            board.setLikes(200);
            boardService.saveBoard(BoardDto.of(board));
        }
    }

}
