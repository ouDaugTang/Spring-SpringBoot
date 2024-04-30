package com.jslee.board.controller;

import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jslee.board.dto.Files;
import com.jslee.board.service.FileService;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/file")
public class FileController {
    @Autowired
    FileService fileService;

    @GetMapping("/{no}")
    public void fileDownload(@PathVariable("no") int no
                            , HttpServletResponse response) throws Exception {
        Files downloadFile = fileService.download(no);

        // 파일이 없는 경우 메소드 종료
        if(downloadFile == null){
            return;
        }
        
        // 필요정보? -> 파일 경로, 파일 명
        String path = downloadFile.getFilePath(); 
        String fileName = downloadFile.getFileName();
        // 한국어 인코딩 설정
        fileName = URLEncoder.encode(fileName, "UTF-8");

        // 다운로드를 위한 응답 헤더 세팅
        // - ContentType            : application/octect-stream
        // - Content-Disposition    : attachment, name="파일명.확장자"
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

        // 파일 다운로드
        File file = new File(path);
        FileInputStream fis =  new FileInputStream(file);       // 파일 입력
        ServletOutputStream sos = response.getOutputStream();   // 파일 출력
        FileCopyUtils.copy(fis,sos);

        fis.close();
        sos.close();
    }
}