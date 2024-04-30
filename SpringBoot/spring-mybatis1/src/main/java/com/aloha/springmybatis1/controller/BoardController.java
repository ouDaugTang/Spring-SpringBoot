package com.aloha.springmybatis1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aloha.springmybatis1.dto.Board;
import com.aloha.springmybatis1.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping("/list")
    public String getAllBoard(Model model) throws Exception {

        // BoardMapper에 있는 list랑 매핑된 DAO를 가지고 온 후 그 값을 boardList 객체에 저장
        List<Board> boardList = boardService.list();
        // boardList 객체를 "boardList" 이름으로 model에 저장 (add)
        model.addAttribute("boardList", boardList);
        // GETMapping 으로 매핑된 주소로 들어오면 /board/list 로 메소드 실행 후 리턴해 목록 보여줌.
        // 모델값도 가지고 return값으로 감
        return "/board/list";
    }

    @GetMapping("/read")
    public String getOneBoard(@RequestParam("no") int no, Model model) throws Exception {

        // BoardMapper에 있는 select랑 매핑된 DAO를 가지고 온 후 그 값을 board 객체에 저장
        Board board = boardService.select(no);
        model.addAttribute("board", board);
        return "/board/read";
    }

     /**
     * 게시글 등록
     * @param board
     * @return
     * @throws Exception
     */
    @GetMapping("/insert")
    public String getOneBoard() throws Exception {

        return "/board/insert";
    }
    
   
    @PostMapping("/insert")
    public String insertPro(Board board) throws Exception {
        
        int result = boardService.insert(board);
        if (result != 0) {
            log.info("등록 성공");
        } else {
            log.info("등록 실패");
        }
        return "redirect:/board/list";
    }

    /**
     * 게시글 수정
     * @param no
     * @param model
     * @return
     * @throws Exception
     */
    @GetMapping("/update")
    public String update(@RequestParam("no") int no, Model model) throws Exception {

        //updatePro랑 연결 시키는 getmapping
        Board board = boardService.select(no);
        model.addAttribute("board", board);
        return "/board/update";
    }

    @PostMapping("/update")
    public String updatePro(Board board) throws Exception {
        
        int result = boardService.update(board);
        if (result != 0) {
            log.info("업데이트 성공");
        } else {
            log.info("업데이트 실패");
        }
        return "redirect:/board/list";
    }


    /**
     * 게시글 삭제
     * @param no
     * @param model
     * @return
     * @throws Exception
     */
    @GetMapping("/delete")
    public String delete(@RequestParam("no") int no, Model model) throws Exception {

        //updatePro랑 연결 시키는 getmapping
        Board board = boardService.select(no);
        model.addAttribute("board", board);
        return "/board/delete";
    }

    @PostMapping("/delete")
    public String deletePro(@RequestParam("no") int no) throws Exception {
        
        int result = boardService.delete(no);
        if (result != 0) {
            log.info("삭제 성공");
        } else {
            log.info("삭제 실패");
        }
        return "redirect:/board/list";
    }

}
