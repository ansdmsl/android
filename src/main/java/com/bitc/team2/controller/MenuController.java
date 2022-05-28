package com.bitc.team2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bitc.team2.dto.MenuDto;
import com.bitc.team2.service.menu.MenuService;

@Controller
public class MenuController {

	@Autowired
	public MenuService menuService;
	

	//메뉴
	@RequestMapping(value="/menu", method=RequestMethod.GET)
	public ModelAndView openBoardList() throws Exception {
		ModelAndView mv = new ModelAndView("menu/productList");
		
		List<MenuDto> boardList = menuService.selectMenuList();
		mv.addObject("boardList", boardList);
		
		return mv;
	}
	
	@RequestMapping(value="/menu2", method=RequestMethod.GET)
	public ModelAndView openBoardList2() throws Exception {
		ModelAndView mv2 = new ModelAndView("/menu/productList2");
		
		List<MenuDto> boardList2 = menuService.selectMenuList2();
		mv2.addObject("boardList2", boardList2);
		
		return mv2;
	}
	
	@RequestMapping(value="/menu3", method=RequestMethod.GET)
	public ModelAndView openBoardList3() throws Exception {
		ModelAndView mv3 = new ModelAndView("/menu/productList3");
		
		List<MenuDto> boardList3 = menuService.selectMenuList3();
		mv3.addObject("boardList3", boardList3);
		
		return mv3;
	}
	
	//상세화면
	 //제품 상세 화면
	@RequestMapping(value="/menu/{menuSeq}", method=RequestMethod.GET)
	public ModelAndView openMenuDetail(@PathVariable("menuSeq") int menuSeq) throws Exception {
		ModelAndView mv = new ModelAndView("/menu/detail1");
		
		MenuDto detailBoard = menuService.selectMenuDetail(menuSeq);
		mv.addObject("detailBoard", detailBoard);
		
		return mv;
	}
	
	
	
	//장바구니 
	
	
	//주문하기 
	
	
	
	
	/*
	 * @RequestMapping(value="/menu/{menu_category}", method=RequestMethod.GET)
	 * public ModelAndView openBoardDetail(@PathVariable("idx") int idx) throws
	 * Exception { // restBoard :페이지 {idx} 접속할 글번호 // {idx}=> @PathVariable("idx")
	 * <-클라이언트에서 전송한 식별자 => int idx // 위에 것만 다르고 나머지는 같다
	 * 
	 * ModelAndView mv = new ModelAndView("/restBoard/restBoardDetail");
	 * 
	 * RestBoardDto restBoard = restBoardService.selectBoardDetail(idx);
	 * mv.addObject("restBoard", restBoard);
	 * 
	 * return mv; }
	 */
	/*
	 * 
	 * @ResponseBody
	 * 
	 * @RequestMapping(value="#", method=RequestMethod.POST) public Object
	 * jangbaguni(@RequestParam("num") int area, @RequestParam("idx") int idx)
	 * throws Exception {
	 * 
	 * return "success";
	 * 
	 * }
	 * 
	 * 
	 */
	/*
	 * @RequestMapping(value="/jr41/list/{productCategoryIdx}",
	 * method=RequestMethod.GET) public ModelAndView openMenu(@RequestParam(required
	 * = false, defaultValue= "1", value="pageNum") int
	 * pageNum, @PathVariable("productCategoryIdx") int productCategoryIdx) throws
	 * Exception { ModelAndView mv = new ModelAndView("/productList");
	 * 
	 * PageInfo<ProjectDto> MenuList = new
	 * PageInfo<>(projectService.selectMenuList(pageNum,productCategoryIdx),5);
	 * mv.addObject("MenuList",MenuList);
	 * 
	 * if (MenuList.getList().size() > 0) { mv.addObject("productCategoryIdx",
	 * MenuList.getList().get(0).getProductCategoryIdx()); }
	 * 
	 * return mv; }
	 */
	/*
	 * //제품 상세 화면
	 * 
	 * @RequestMapping(value="/jr41/list/detail/{ProductIdx}",
	 * method=RequestMethod.GET) public ModelAndView
	 * openBoardDetail(@PathVariable("ProductIdx") int ProductIdx) throws Exception
	 * { ModelAndView mv = new ModelAndView("/detail");
	 * 
	 * MenuDto board = projectService.selectBoardDetail(ProductIdx);
	 * mv.addObject("board", board);
	 * 
	 * return mv; }
	 */

}
