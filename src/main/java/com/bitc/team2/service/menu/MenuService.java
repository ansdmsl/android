package com.bitc.team2.service.menu;

import java.util.List;

import com.bitc.team2.dto.MenuDto;


public interface MenuService {

	
 //메누별	
	List<MenuDto> selectMenuList() throws Exception;
	
	List<MenuDto> selectMenuList2() throws Exception;

	List<MenuDto> selectMenuList3() throws Exception;

	MenuDto selectMenuDetail(int menuSeq) throws Exception;
	
//	List<ProjectDto> selectList() throws Exception;
	
	/*
	 * // 메뉴별 화면 //List<ProjectDto> selectMenuList(int productCategoryIdx) throws
	 * Exception; Page<MenuDto> selectMenuList(int pageNum, int productCategoryIdx)
	 * throws Exception;
	 * 
	 * 
	 * // 상세화면 MenuDto selectBoardDetail(int productIdx) throws Exception;
	 * 
	 * 
	 * ProductFileDto selectBoardFileInfo(int fileIdx, int boardIdx) throws
	 * Exception;
	 */
	


}
