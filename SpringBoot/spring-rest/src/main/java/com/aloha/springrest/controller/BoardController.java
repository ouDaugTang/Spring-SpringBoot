package com.aloha.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aloha.springrest.dto.Board;
import com.aloha.springrest.service.BoardService;

import lombok.extern.slf4j.Slf4j;





/**
 * /board 경로로 요청 왔을 때 처리 
 * [GET]  - /board/list   : 게시글 목록 화면
 * [GET]  - /board/read   : 게시글 조회 화면
 * [GET]  - /board/insert : 게시글 등록 화면
 * [POST] - /board/insert : 게시글 등록 처리
 * [GET]  - /board/update : 게시글 수정 화면
 * [POST] - /board/update : 게시글 수정 처리
 * [POST] - /board/delete : 게시글 삭제 처리
 */
@Slf4j                          // 로그 어노테이션
@Controller                     // 컨트롤러 스프링 빈으로 등록
@RequestMapping("/board")       // 클레스 레벨 요청 경로 매핑 
public class BoardController {  // - /board/~
    
    // 데이터 요청과 화면 출력
    // Controller --> Service   (데이터 요청)
    // Service    <-- Controller(데이터 전달)
    // Controller --> Model     (모델 등록)
    // Model      --> View      (데이터 출력)

    @Autowired
    private BoardService boardService;

    @GetMapping("/list")
    public String list(Model model) throws Exception {
        // 데이터 요청
        List<Board> boardList = boardService.list();

        // 모델 등록
        model.addAttribute("boardList", boardList);

        // 뷰 페이지 지정
        return "/board/list";           // resources/templates/board/list.html
    }
    
    /**
     * 게시글 조회 화면
     * - /board/read?no=❓  [ ?no <- param]
     * @param no
     * @param model
     * @return
     * @throws Exception
     */
    // @RequestParam("파라미터명") 
    // - 스프링 부트 3.2버전 이하, 생략해도 자동매핑 ⭕
    // - 스프링 부트 3.2버전 이상, 생략해도 자동매핑 ❌ 필수로 명시해야 매핑됨
    @GetMapping("/read")
    public String read(@RequestParam("no") int no, Model model) throws Exception {

        // 데이터 요청
        Board board = boardService.select(no);

        // 모델 등록
        model.addAttribute("board", board);

        // 뷰페이지 지정
        return "/board/read";
    }
    
    /**
     * 데이터 등록
     */
    @GetMapping("/insert")
    public String insert() {

        return "/board/insert";
    }

    @PostMapping("/insert")
    public String insertPro(Board board) throws Exception {
        // 데이터 요청
        int result = boardService.insert(board);
        // 리다이렉트

        // ⭕ 데이터 처리 성공
        if (result > 0 ) {
            return "redirect:/board/list";
        }
        // ❌ 데이터 처리 실패
        return "redirect:/board/insert?error";
    }
    
    @GetMapping("/update")
    public String update(@RequestParam("no") int no, Model model) throws Exception {
        Board board = boardService.select(no);
        model.addAttribute("board", board);
        return "/board/update";
    }

    /**
     * 게시글 수정 처리
     * @param board
     * @return
     * @throws Exception 
     */
    @PostMapping("/update")
    public String updatePro(Board board) throws Exception {
        // 데이터 요청
        int result = boardService.update(board);
        // 리다이렉트

        // ⭕ 데이터 처리 성공
        if (result > 0 ) {
            return "redirect:/board/list";
        }
        // ❌ 데이터 처리 실패
        int no = board.getNo();
        return "redirect:/board/update?no=" + no + "&error";
    }
    
    /**
     * 게시글 삭제 처리
     * @param no
     * @return
     * @throws Exception
     */
    @PostMapping("/delete")
    public String delete(@RequestParam("no") int no) throws Exception {
        // 데이터 요청
        int result = boardService.delete(no);

        // 리다이렉트
        // ⭕ 데이터 처리 성공
        if (result > 0 ) {
            return "redirect:/board/list";
        }
        // ❌ 데이터 처리 실패
        return "redirect:/board/delete?no=" + no + "&error";
    }

  
}
