package com.bitc.team2.dto;

import lombok.Data;

@Data
public class MenuDto {
	
	private int menuSeq;
	private String menuName;
	private int menuPrice;
	private String menuCategory;
	private String menuStoredFilePath;
	private String menuDetail;
	private String userId;

//	
//	private int fileIdx;
//	private int boardIdx;
//	private String originalFileName;
//	private String storedFilePath;
//	private String fileSize;
//	
//	첨부파일에 대한 정보를 저장하기 위한 멤버 변수를 추가함
//	private List<MenuDto> fileList;


}
