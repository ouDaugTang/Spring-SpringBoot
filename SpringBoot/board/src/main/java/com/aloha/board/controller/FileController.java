package com.aloha.board.controller;

import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aloha.board.dto.Files;
import com.aloha.board.service.FileService;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService fileService;
    
    /**
     * 파일 다운로드
     * @param no
     * @param response
     * @throws Exception
     */
    @GetMapping("/{no}")
    public void FileDownload(@PathVariable("no") int no
                              ,HttpServletResponse response) throws Exception {
        Files downloadFile = fileService.download(no);

        // 파일이 없으면, 
        if( downloadFile == null ) {
            return;
        }
        
        String fileName = downloadFile.getFileName();   // 파일 명
        String filePath = downloadFile.getFilePath();   // 파일 경로

        // 다운로드를 위한 응답 헤더 세팅
        // - ContentType            : aopplication/octect-stream
        // - Content-Disposition    : attachment, filename="파일명.확장자"
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
        fileName = URLEncoder.encode(filePath, "UTF-8");
        response.setHeader("Content-Disposition"
                           ,"attachment; filename=\"" + fileName + "\"");     
        
        // 파일 다운로드
        File file = new File(filePath);
        FileInputStream fis = new FileInputStream(file);
        ServletOutputStream sos = response.getOutputStream();
        FileCopyUtils.copy(fis, sos);
        
        fis.close();
        sos.close();

    }
    
    @DeleteMapping("/{no}")
    public ResponseEntity<String> deleteFile(@PathVariable("no") int no) throws Exception {
        log.info("[DELETE] - /file/" + no);

        // 파일 삭제 요청
        int result = fileService.delete(no);

        // ✅ 삭제 성공
        if( result > 0) {
            return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
        }
        // ❌ 삭제 실패
        return new ResponseEntity<>("FAIL", HttpStatus.OK);
    }
}