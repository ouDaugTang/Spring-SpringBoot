package com.aloha.springmybatis.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aloha.springmybatis.dto.Files;
import com.aloha.springmybatis.mapper.FileMapper;

import jakarta.servlet.http.HttpServletResponse;


@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileMapper fileMapper;

    //파일 목록
    @Override
    public List<Files> list() throws Exception {
        List<Files> filesList = fileMapper.list();

        return filesList;
    }

    //파일 조회
    @Override
    public Files select(int no) throws Exception {
        Files file = fileMapper.select(no);
        return file;
    }

    @Override
    public int insert(Files file) throws Exception {
        int result = fileMapper.insert(file);
        return result;
    }

    @Override
    public int update(Files file) throws Exception {
        int result = fileMapper.update(file);
        return result;
    }

    @Override
    public int delete(int no) throws Exception {
        int result = fileMapper.delete(no);
        return result;
    }

    @Override
    public List<Files> listByParent(Files file) throws Exception {
       List<Files> fileList = fileMapper.listByParent(file);
        return fileList;
    }

    @Override
    public int deleteByParent(Files file) throws Exception {
        int result = fileMapper.deleteByParent(file);
        return result;
    }

    @Override
    public int upload(String parentTable, int parentNo, List<MultipartFile> fileList) throws Exception {
        // TODO : 파일 업로드
        throw new UnsupportedOperationException("파일 업로드 구현하세요.");
    }

    @Override
    public int download(int no, HttpServletResponse response) throws Exception {
        // TODO : 파일 다운로드
        throw new UnsupportedOperationException("파일 다운로드 구현하세요.");
    }

    
}

    

