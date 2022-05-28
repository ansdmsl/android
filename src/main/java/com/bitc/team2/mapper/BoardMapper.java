package com.bitc.team2.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bitc.team2.dto.BoardDto;

@Mapper
public interface BoardMapper {

	List<BoardDto> selectBoardList() throws Exception;

	void insertBoard(BoardDto board) throws Exception;

	BoardDto selectBoardDetail(int seq) throws Exception;

	void deleteBoard(int seq) throws Exception;

	void updateBoard(BoardDto board) throws Exception;
}
