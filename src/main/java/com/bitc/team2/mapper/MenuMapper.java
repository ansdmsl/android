package com.bitc.team2.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bitc.team2.dto.CartDto;
import com.bitc.team2.dto.MenuDto;

@Mapper
public interface MenuMapper {

	
	public List<MenuDto> selectMenuList() throws Exception;

	public List<MenuDto> selectMenuList2() throws Exception;

	public List<MenuDto> selectMenuList3() throws Exception;
	
	// 상세화면 
 	public MenuDto selectMenuDetail(int menuSeq) throws Exception;
	
 	public void addCart(CartDto cart) throws Exception;


//	public List<MenuDto> selectList() throws Exception;
//
////	DB에 연결하여 게시글의 첨부파일 정보를 DB에 저장하는 메서드
//	void insertBoardFileList(List<ProductFileDto> list) throws Exception;
//	
////	DB에 연결하여 게시글의 첨부파일 정보를 가져오는 메서드
//	List<MenuDto> selectBoardFileList(int productIdx) throws Exception;	
//	
//	ProductFileDto selectBoardFileInfo(@Param("fileIdx") int fileIdx, @Param("boardIdx") int boardIdx) throws Exception;
//
//
//	// 메뉴별 상품 리스트
//	Page<MenuDto> selectMenuList( int productCategoryIdx) throws Exception;
//
//	//상품상세화면
//	public MenuDto selectBoardDetail(int productIdx) throws Exception;
//	
//	
}

