package com.aloha.springmybatis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aloha.springmybatis.dto.Board;
import com.aloha.springmybatis.service.BoardService;

import lombok.extern.slf4j.Slf4j;




@Controller
@RequestMapping("/board")
@Slf4j
public class BoardController {
    
    @Autowired
    private BoardService boardService;

    /**
     * 게시글 목록
     * @param model
     * @return
     * @throws Exception
s     */

     @GetMapping("/list")
     public String list(Model model) throws Exception {
        List<Board> boardList = boardService.list();
        model.addAttribute("boardList", boardList);
        return "board/list";
     }

     /**
      * 게시글 조회
      * @param model
      * @param no
      * @return
      * @throws Exception
      */
    @GetMapping("/read")
     public String select(Model model, int no) throws Exception {
        Board board = boardService.select(no);
        model.addAttribute("board", board);
        return "board/read";
     }

     /**
      * 게시글 등록
      * @return
      * @throws Exception
      */
     @GetMapping("/insert")
     public String insert() throws Exception {
         return "board/insert";
     }
     
     /**
      * 게시글 등록 처리
      * @param board
      * @return
      * @throws Exception
      */
     @PostMapping("/insert")
     public String insertPro(Board board) throws Exception {
        int result = boardService.insert(board);
        log.info("게시글 등록 요청 - result" + result);
         return "redirect:/board/list";
     }
     /**
      * 게시글 수정
      * @param model
      * @param no
      * @return
      * @throws Exception
      */

     @GetMapping("/update")
     public String update(Model model, int no) throws Exception {
        Board board = boardService.select(no);
        model.addAttribute("board", board);
        return "board/update";
     }

     @PostMapping("/update")
     public String updatePro(Board board) throws Exception {
         int result = boardService.update(board);
         log.info("게시글 수정 요청" + result);
         return "redirect:/board/list";
     }
     
     @PostMapping("/delete")
     public String deletePro(int no) throws Exception {
        int result = boardService.delete(no);
        log.info("게시글 삭제 요청" + result);         
         return "redirect:/board/list";
     }
     
}