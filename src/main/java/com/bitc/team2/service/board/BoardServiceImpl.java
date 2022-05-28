package com.bitc.team2.service.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitc.team2.dto.BoardDto;
import com.bitc.team2.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public List<BoardDto> selectBoardList() throws Exception {
		
		return boardMapper.selectBoardList();
	}

	@Override
	public void insertBoard(BoardDto board) throws Exception {
		boardMapper.insertBoard(board);
		
	}

	@Override
	public BoardDto selectBoardDetail(int seq) throws Exception {
		return boardMapper.selectBoardDetail(seq);
	}

	@Override
	public void deleteBoard(int seq) throws Exception {
		boardMapper.deleteBoard(seq);
		
	}

	@Override
	public void updateBoard(BoardDto board) throws Exception {
		boardMapper.updateBoard(board);
	}

}
