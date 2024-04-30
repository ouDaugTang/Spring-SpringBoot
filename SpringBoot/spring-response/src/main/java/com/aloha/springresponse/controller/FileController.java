package com.aloha.springresponse.controller;

import java.io.File;
import java.io.FileInputStream;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aloha.springresponse.util.MediaUtil;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/file")
public class FileController {
    /**
    * 이미지 썸네일 
    * @param filePath
    * @param response
    * @throws Exception
    */
   @GetMapping("/img")
   public void showImg(String filePath
                  ,HttpServletResponse response ) throws Exception {
      
      log.info("filePath : " + filePath);
      
      File file = new File(filePath);
      FileInputStream fis = new FileInputStream(file);
      ServletOutputStream sos = response.getOutputStream();
      FileCopyUtils.copy(fis, sos);

      // filePath  : C:/KHM/upload/[UID]_강아지.png
      // 이미지 컨텐트 타입 확인 ( .jpg, .png, .gif, ... )
      String ext = filePath.substring( filePath.lastIndexOf(".") + 1 );   // 확장자
      MediaType mType = MediaUtil.getMediaType(ext);
      
      // 이미지 타입이 아닐 경우
      if( mType == null ) {
         return;
      }
      
      
      log.info("mType : " + mType);
      response.setContentType( mType.toString() );
   }
    
   /**
	 * 파일 다운로드
	 * @param fileNo
	 * @param response
	 * @throws Exception
	 */
	@GetMapping("/download")
	public void fileDownload(@RequestParam("filePath") String filePath
							,HttpServletResponse response) throws Exception {
		
		log.info("filePath : " + filePath);
		
		String fileName = "sample.png";

		// 파일 다운로드를 위한 헤더 세팅
		// - ContentType 			: application/octet-straem
		// - Content-Disposition 	: attachment; fileanme="파일명.확장자"
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
		
		
		// 파일 입력
		File downloadFile = new File(filePath);
		FileInputStream fis = new FileInputStream(downloadFile);
		ServletOutputStream sos = response.getOutputStream();

		// 다운로드
		FileCopyUtils.copy(fis, sos);
		
	}
}