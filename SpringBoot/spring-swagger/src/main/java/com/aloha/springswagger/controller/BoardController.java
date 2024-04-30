package com.aloha.springswagger.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.print.attribute.standard.Media;
import javax.print.attribute.standard.MediaTray;

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

import com.aloha.springswagger.dto.Board;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.models.media.MediaType;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/board")
public class BoardController {

// sp-crud      :CRUD 를 위한 모든 컨트롤러 자동완성
  /**
   * 게시글 목록
   * [GET]
   * /board
   * - response : boardList
   * @author 홍준범
   * @return
   */
  @GetMapping()
  public ResponseEntity<?> getAllBoard() {
      try {
        List<Board> boardList = new ArrayList<>();

        boardList.add(new Board(1, "제목1", "작성자1", "내용1", new Date(), new Date(), 0));
        boardList.add(new Board(2, "제목2", "작성자2", "내용2", new Date(), new Date(), 0));
        boardList.add(new Board(3, "제목3", "작성자3", "내용3", new Date(), new Date(), 0));

          return new ResponseEntity<>(boardList, HttpStatus.OK);
      } catch (Exception e) {
          return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
  }
  
  /**
   * 게시글 조회
   * [GET]
   * /board/{no}
   * @param no
   * @return
   */
  @GetMapping("/{no}")
  public ResponseEntity<?> getOneBoard( @Parameter(name = "no", description = "글 번호를 입력해주세요.", required = true)
                                        @PathVariable("no") Integer no) {
      try {
            Board board = new Board(no,"제목","작성자","내용",new Date(), new Date(),0);

          return new ResponseEntity<>(board, HttpStatus.OK);
      } catch (Exception e) {
          return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
  }
  
  /**
   * 게시글 등록 처리
   * [POST]
   * /board
   * ✅ 요청 성공 : 201 CREATED                                        "SUCCESS"
   * ❌ 요청 실패 : 400 Bad Request OR 500 Internal Server ERROR       "FAIL"
   * @param board
   * @return
   */
  @PostMapping()
  @Operation(summary = "POST 요청", description = "POST 방식 요청을 테스트합니다.")
  public ResponseEntity<?> createBoard(@RequestBody Board board) {
      try {
        log.info("board : " + board);
          return new ResponseEntity<>("Create Result", HttpStatus.OK);
      } catch (Exception e) {
          return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
  }
  

  /**
   * 게시글 수정 처리
   * [PUT]
   * /board
   * ✅ 요청 성공 : 200 OK                                             "SUCCESS"
   * ❌ 요청 실패 : 400 Bad Request OR 500 Internal Server ERROR       "FAIL"
   * @param board
   * @return
   */
  @PutMapping()
  public ResponseEntity<?> updateBoard(@RequestBody Board board) {
      try {
            log.info("board : " + board);
          //TODO Implement Your Logic To Update Data And Return Result Through ResponseEntity
          return new ResponseEntity<>("Update Result", HttpStatus.OK);
      } catch (Exception e) {
          return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
  }
  

  /**
   * 게시글 삭제 처리
   * [DELETE]
   * ✅ 요청 성공 : 201 CREATED                                        "SUCCESS"
   * ❌ 요청 실패 : 400 Bad Request OR 500 Internal Server ERROR       "FAIL"
   * @param no
   * @return
   */
  @DeleteMapping("/{no}")
  public ResponseEntity<?> destroyBoard(@PathVariable Integer no) {
      try {
            log.info("삭제할 글 번호 : " + no);

          return new ResponseEntity<>("Destroy Result", HttpStatus.OK);
      } catch (Exception e) {
          return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
  }
    
}
