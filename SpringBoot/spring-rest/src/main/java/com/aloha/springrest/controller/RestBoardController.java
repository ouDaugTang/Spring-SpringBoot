package com.aloha.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aloha.springrest.dto.Board;
import com.aloha.springrest.service.BoardService;

import lombok.extern.slf4j.Slf4j;

/**
 * 🟢 RestFul
 * 👩‍🏫 게시판 컨트롤러
 * - 게시글 목록          -       [GET] /rest/board         
 * - 게시글 조회          -       [GET] /rest/board/10
 * - 게시글 등록 처리      -      [POST] /rest/board
 * - 게시글 수정 처리      -      [PUT] /rest/board
 * - 게시글 삭제 처리      -      [DELETE] /rest/board
 */

@Slf4j
@RestController
@RequestMapping("/rest/board")
public class RestBoardController {
    
    @Autowired
    private BoardService boardService;
    /**
     * 게시글 목록 [GET] /rest/board
     * @return
     */
    @GetMapping()
    public ResponseEntity<?> getAll() {
        try {
            List<Board> boardList = boardService.list();
            return new ResponseEntity<>(boardList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    /**
     * 게시글 조회 -[GET] /rest/board/10
     * @param no
     * @return
     */
    @GetMapping("/{no}")
    public ResponseEntity<?> getOne(@PathVariable("no") int no) {
        try {
            Board board = boardService.select(no);
            return new ResponseEntity<>(board, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    /**
     * 게시글 등록 - [POST] /rest/board
     * @param board
     * @return
     */     
    @PostMapping()
    public ResponseEntity<?> create(@RequestBody Board board) {
        try {
            int result = boardService.insert(board);
            if (result > 0) {
                return new ResponseEntity<>("SUCCESS", HttpStatus.CREATED);
            }else{
                return new ResponseEntity<>("FAIL", HttpStatus.OK);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    /**
     * 게시글 수정
     * @param board
     * @return
     */
    @PutMapping()
    public ResponseEntity<?> update(@RequestBody Board board) {
        try {
            int result = boardService.update(board);
            if (result > 0) {
                return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
            }else{
                return new ResponseEntity<>("FAIL", HttpStatus.OK);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    /**
     * 게시글 삭제
     * @param no
     * @return
     */
    @DeleteMapping("/{no}")
    public ResponseEntity<?> destroy(@PathVariable("no") int no) {
        try {
            int result = boardService.delete(no);
            if (result > 0) {
                return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
            }else{
                return new ResponseEntity<>("FAIL", HttpStatus.OK);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
