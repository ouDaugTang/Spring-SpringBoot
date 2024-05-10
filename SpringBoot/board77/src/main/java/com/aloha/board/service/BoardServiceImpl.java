package com.aloha.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aloha.board.dto.Board;
import com.aloha.board.dto.Files;
import com.aloha.board.dto.Option;
import com.aloha.board.dto.Page;
import com.aloha.board.mapper.BoardMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service    // 서비스 역할의 스프링 빈 등록
public class BoardServiceImpl implements BoardService {
public static void main(String[] args) {
    
}    
    
    @Autowired
    private BoardMapper boardMapper;

    @Autowired
    private FileService fileService;

    @Autowired
    private ReplyService replyService;
    

    @Override
    public List<Board> list(Page page, Option option) throws Exception {

        // 게시글 데이터 개수 조회
        int total = boardMapper.count(option);
        page.setTotal(total);
        
        List<Board> boardList = boardMapper.list(page, option);
        return boardList;
    }

    /**
     * 게시글 조회
     * - no 매개변수로 게시글 번호를 전달받아서
     *   데이터베이스에 조회 요청
     */
    @Override
    public Board select(int no) throws Exception {
        // TODO : boardMapper 로 select(no) 호출
        /*
         *        ➡ Board board 로 받아옴
         *        ➡ return board
         */
        Board board = boardMapper.select(no);
        return board;
    }

    /**
     * 게시글 등록
     */

    @Override
    public int insert(Board board) throws Exception {

        
        int result = boardMapper.insert(board);
        
        String parentTable = "board";
        int parentNo = boardMapper.maxPk();
        
        // 썸네일 업로드
        // - 부모테이블, 부모번호, 멀티파트파일, 파일코드:1(썸네일)
        MultipartFile thumbnailFile = board.getThumbnail();
        if (thumbnailFile != null && !thumbnailFile.isEmpty()) {
            
            Files thumbnail = new Files();
            thumbnail.setFile(thumbnailFile);
            thumbnail.setParentTable(parentTable);
            thumbnail.setParentNo(parentNo);
            thumbnail.setFileCode(1);
            fileService.upload(thumbnail);      // 썸네일 파일 업로드
        }

        // 첨부파일 업로드
        List<MultipartFile> fileList = board.getFile();
        if( !fileList.isEmpty() ) {
            for (MultipartFile file : fileList) {
                if( file.isEmpty() ) continue;

                // 파일 정보 등록
                Files uploadFile = new Files();
                uploadFile.setParentTable(parentTable);
                uploadFile.setParentNo(parentNo);
                uploadFile.setFile(file);

                fileService.upload(uploadFile);

            }
        }
        return result;
    }
    
    /**
     * 게시글 수정
     */
    @Override
    public int update(Board board) throws Exception {
        // TODO : boardMapper 로 update(Board) 호출
        /*
        *        ➡ int result 로 데이터 처리 행(개수) 받아옴
        *        ➡ return result
        */
        int result = boardMapper.update(board);
        return result;
    }
    
    /**
     * 게시글 삭제
     */
    @Override
    public int delete(int no) throws Exception {
        // TODO : boardMapper 로 delete(no) 호출
        /*
        *        ➡ int result 로 데이터 처리 행(개수) 받아옴
        *        ➡ return result
        */
        int result = boardMapper.delete(no);
        if ( result > 0 ) {
            result += replyService.deleteByBoardNo(no);
        }
        return result;
    }

    @Override
    public List<Board> search(Page page) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }

    @Override
    public int views(int no) throws Exception {
       int result =  boardMapper.views(no);

        return result;

    }

    


}