package com.bitc.team2.service.board;

import java.util.List;

import com.bitc.team2.dto.BoardDto;

public interface BoardService {

	List<BoardDto> selectBoardList() throws Exception;

	void insertBoard(BoardDto board) throws Exception;

	BoardDto selectBoardDetail(int seq) throws Exception;

	void deleteBoard(int seq) throws Exception;

	void updateBoard(BoardDto board) throws Exception;

}
