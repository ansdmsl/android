package com.bitc.team2.service.menu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitc.team2.dto.MenuDto;
import com.bitc.team2.mapper.MenuMapper;


@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuMapper menuMapper;
	
	/*
	 * @Autowired private FileUtils fileUtils;
	 */
//메인화면
	@Override
	public List<MenuDto> selectMenuList() throws Exception {
		
		return menuMapper.selectMenuList();
		
			
	}
	
	@Override
	public List<MenuDto> selectMenuList2() throws Exception {
		
		return menuMapper.selectMenuList2();
		
	}
	
	@Override
	public List<MenuDto> selectMenuList3() throws Exception {
		
		return menuMapper.selectMenuList3();
		}
	
	
		//상헤솨면 
	
	@Override
	public MenuDto selectMenuDetail(int menuSeq) throws Exception{

		return menuMapper.selectMenuDetail(menuSeq);
	
	}
	
	
	
//	@Override
//	public List<ProjectDto> selectList() throws Exception {
//		return projectMapper.selectList();
//	}
	

//	@Override
//	public ProjectDto selectBoardDetail(int productIdx) throws Exception {
//		
//		ProjectDto board = projectMapper.selectBoardDetail(productIdx);
//		List<ProductFileDto> fileList = projectMapper.selectBoardFileList(productIdx);
//		board.setFileList(fileList);
//		return board;
//	}
	
//		@Override
//		public ProductFileDto selectBoardFileInfo(int fileIdx, int boardIdx) throws Exception {
//			return projectMapper.selectBoardFileInfo(fileIdx, boardIdx);
//		}
//
//		// 카테고리별 상품화면 
//		@Override
//		public Page<MenuDto> selectMenuList(int pageNum, int productCategoryIdx) throws Exception {
//			PageHelper.startPage(pageNum, 2);
//			return projectMapper.selectMenuList(productCategoryIdx);
//		}
//
//		@Override
//		public MenuDto selectBoardDetail(int productIdx) throws Exception {
//	
//			MenuDto board = projectMapper.selectBoardDetail(productIdx);
//			List<MenuDto> fileList = projectMapper.selectBoardFileList(productIdx);
//			board.setFileList(fileList);
//			return board;
//		}

		
 }
		
	
		
	
