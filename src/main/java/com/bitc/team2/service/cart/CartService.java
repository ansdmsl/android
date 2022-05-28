package com.bitc.team2.service.cart;

import java.util.List;

import com.bitc.team2.dto.CartDto;
import com.bitc.team2.dto.UserDto;

public interface CartService {
	
	/* 장바구니 추가 */
	
	void addCart(CartDto cart) throws Exception;
	
	//장바구니 보기 
	
	// Map<String, List> getMyCart(String userid);

	List<CartDto> cartList(String userId) throws Exception;

	 //장바구니 삭제
	void deleteCart(int cartId) throws Exception;

	 //유저불러오기
	UserDto selectUserInfo(String userId) throws Exception;

	 // 결제하기 -> order db에 insert OR UPDATE
	void paySuccess(CartDto success) throws Exception;

	// 결제완료 
	List<CartDto> selectSuccessList(String userId) throws Exception;

	
	

}
