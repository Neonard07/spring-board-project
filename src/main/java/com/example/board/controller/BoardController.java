package com.example.board.controller;

import com.example.board.entity.Board;
import com.example.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/boards")
public class BoardController {

    private final BoardService boardService;

    @GetMapping
    public String list(Model model) {
        List<Board> boards = boardService.getAllBoards();
        model.addAttribute("boards", boards);
        return "board/list";
    }

    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("board", new Board());
        return "board/form";
    }

    @PostMapping
    public String save(@ModelAttribute Board board) {
        boardService.save(board);
        return "redirect:/boards";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Board board = boardService.getById(id);
        model.addAttribute("board", board);
        return "board/detail";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        boardService.deleteById(id);
        return "redirect:/boards";
    }
}
