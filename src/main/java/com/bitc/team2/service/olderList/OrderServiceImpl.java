package com.bitc.team2.service.olderList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitc.team2.dto.MenuDto;
import com.bitc.team2.dto.UserDto;
import com.bitc.team2.mapper.OrderMapper;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderMapper orderMapper;


	/*
	 * @Override public void mapinsert(OrderDto order) throws Exception {
	 * orderMapper.mapinsert(order);
	 * 
	 * }
	 */

	@Override
	public List<UserDto> selectUserList() throws Exception {
		
		return orderMapper.selectUserList();
	}
	
	@Override
	public List<MenuDto> selectMenuList() throws Exception {
		return orderMapper.selectMenuList();
	}

	@Override
	public void updateStore(String userId, String storeName) throws Exception{
		orderMapper.updateStore(userId, storeName);
	}

	

	

	

	
	
	


}
