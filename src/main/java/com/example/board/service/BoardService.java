package com.example.board.service;

import com.example.board.entity.Board;
import com.example.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public List<Board> getAllBoards() {
        return boardRepository.findAll();
    }

    public Board save(Board board) {
        return boardRepository.save(board);
    }

    public Board getById(Long id) {
        return boardRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        boardRepository.deleteById(id);
    }
}
