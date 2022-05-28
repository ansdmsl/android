package com.bitc.team2.service.olderList;

import java.util.List;

import com.bitc.team2.dto.MenuDto;
import com.bitc.team2.dto.UserDto;

public interface OrderService {
	
	//void mapinsert(OrderDto order) throws Exception;

	List<UserDto> selectUserList() throws Exception;
	
	List<MenuDto> selectMenuList() throws Exception;

	void updateStore(String userId, String storeName) throws Exception;


	
}
