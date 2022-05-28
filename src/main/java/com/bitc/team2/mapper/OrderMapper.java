package com.bitc.team2.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bitc.team2.dto.MenuDto;
import com.bitc.team2.dto.UserDto;

@Mapper
public interface OrderMapper {

	/* void mapinsert(OrderDto order) throws Exception; */

	List<UserDto> selectUserList() throws Exception;

	List<MenuDto> selectMenuList() throws Exception;

	void updateStore(@Param("userId")String userId, @Param("storeName")String storeName) throws Exception;

	
	
}
