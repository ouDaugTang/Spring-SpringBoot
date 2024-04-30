package com.aloha.spring.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.aloha.spring.dto.Board;

@Mapper
public interface BoardMapper {

  // 메소드 명은 Mapper.xml 매핑 파일의 SQL 태그 id 값과 일치해야한다.
  public List<Board> list() throws Exception;

	public Integer insert(@Param("title") String title
						 ,@Param("writer") String writer
						 ,@Param("content") String content) throws Exception;

	public Board select(Integer no) throws Exception;

	
	public Integer update(Map<String, String> map) throws Exception;

	public Integer delete(Integer no) throws Exception;

}