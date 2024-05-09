package com.aloha.board6.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aloha.board6.dto.Board;
import com.aloha.board6.service.BoardService;

import lombok.extern.slf4j.Slf4j;




@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {
    
    @Autowired
    BoardService boardService;

    @GetMapping("/list")
    public String list(Model model) {
        List<Board> boardList = boardService.list();

        model.addAttribute("boardList", boardList);

        return "/board/list";
    }

    @GetMapping("/read")
    public String read(@RequestParam("no") int no, Model model) {
        Board board = boardService.read(no);
        
        model.addAttribute("board", board);
        return "/board/read";
    }

    @GetMapping("/insert")
    public String insert() {
        return "/board/insert";
    }

    @PostMapping("/insert")
    public String insertPro(Board board) {
        int result = boardService.insert(board);
        
        if (result > 0) {
            return "redirect:/board/list";    
        }

        return "redirect:/board/insert?error=";
    }
    
    @GetMapping("/update")
    public String update(@RequestParam("no") int no, Model model) {
        Board board = boardService.read(no);
        
        model.addAttribute("board", board);
        return "/board/update";
    }
    
    @PostMapping("/update")
    public String updatePro(Board board) {
        int result = boardService.update(board);
        
        if (result > 0) {
            return "redirect:/board/list";    
        }

        return "redirect:/board/update?error=";
    }

    @PostMapping("/delete")
    public String deletePro(int no) {
        int result = boardService.delete(no);
        
        if (result > 0) {
            return "redirect:/board/list";    
        }

        return "redirect:/board/delete?error=";
    }
}
