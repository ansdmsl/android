package com.bitc.team2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bitc.team2.dto.BoardDto;
import com.bitc.team2.service.board.BoardService;

@Controller
public class NoticeController {

	@Autowired
	private BoardService boardService;
	
	
	@RequestMapping(value="/notice",method=RequestMethod.GET)
	public ModelAndView openBoardList() throws Exception{
		ModelAndView mv = new ModelAndView("/notice/noticeBoard");
		
		List<BoardDto> boardList = boardService.selectBoardList();
		mv.addObject("boardList",boardList);
		
		return mv;
	}
	
	@RequestMapping(value="/notice/write", method=RequestMethod.GET)
	public String writeBoard() throws Exception{
		return "/notice/noticeWrite";
	}
	
	@RequestMapping(value="/notice/write", method=RequestMethod.POST)
	public String insertBoard(BoardDto board) throws Exception{
		boardService.insertBoard(board);
		
		return "redirect:/notice"; 
	}
	
	@RequestMapping(value= "/notice/{seq}", method=RequestMethod.GET)
	public ModelAndView openBoardDetail(@PathVariable("seq")int seq) throws Exception{
		ModelAndView mv = new ModelAndView("/notice/noticeDetail");
		
		BoardDto boardList = boardService.selectBoardDetail(seq);
		mv.addObject("boardList", boardList);
		
		return mv;
	}
	
	@RequestMapping(value ="notice/delete/{seq}", method=RequestMethod.DELETE)
	public String deleteBoard(@PathVariable("seq") int seq) throws Exception{
		boardService.deleteBoard(seq);
		return "redirect:/notice";
	}
	
	@RequestMapping(value = "notice/update/{seq}", method=RequestMethod.PUT)
	public String updateBoard(BoardDto board) throws Exception{
		boardService.updateBoard(board);
		
		return "redirect:/notice";
	}
}
