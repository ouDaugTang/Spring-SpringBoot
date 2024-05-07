package com.aloha.board2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aloha.board2.dto.Board;
import com.aloha.board2.service.BoardService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;




@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {
    
    @Autowired
    BoardService boardService;

    @GetMapping("/list")
    public String list(Model model) throws Exception {

        List<Board> boardList = boardService.list();

        model.addAttribute("boardList", boardList);

        return "/board/list";
    }
    
    @GetMapping("/read")
    public String read(@RequestParam("no") int no, Model model) throws Exception {

        Board board = boardService.read(no);
        
        model.addAttribute("board", board);

        return "/board/read";
    }
    
    @GetMapping("/insert")
    public String insert() throws Exception {
        return "/board/insert";
    }

    @PostMapping("/insert")
    public String insertPro(Board board) throws Exception {
        
        int result = boardService.insert(board);
        
        if( result > 0) {
            log.info("게시글 등록 성공!");
            return "redirect:/board/list";
         }
        
        return "redirect:/board/insert?error";
    }

    @GetMapping("/update")
    public String update(@RequestParam("no") int no, Model model) throws Exception {

        Board board = boardService.read(no);
        
        model.addAttribute("board", board);

        return "/board/update";
    }
    
    @PostMapping("/update")
    public String updatePro(Board board) throws Exception {
        
        int result = boardService.update(board);

        return "redirect:/board/list";
    }
    
    @PostMapping("/delete")
    public String deletePro(@RequestParam("no") int no) throws Exception {
        
        int result = boardService.delete(no);

        return "redirect:/board/list";
    }
    
    
}
