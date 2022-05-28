package com.bitc.team2.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bitc.team2.dto.CartDto;
import com.bitc.team2.dto.UserDto;

@Mapper
public interface CartMapper {
	
	/* 카트 추가 */
	public int addCart(CartDto cart) throws Exception;
	
	/* 카트 확인 */
	public CartDto checkCart(CartDto cart);

	 // 카트보기
	public List<CartDto> getCart(String userId);	
//	public List<CartDto> openCartList(String userId) throws Exception;

//	 // 카트보기 
//		public List<CartDto> openCartList() throws Exception;

//	public int sumMoney(String userId) throws Exception;
//	
	// 삭제
	public void deleteCart(int cartId) throws Exception;

//	//장바구니 주문클릭시 데이터 입력 
//	public void cartOrder(CartDto cartorder) throws Exception;

	 // 주문보기
	public List<CartDto> cartOrder(String userId) throws Exception;

  // 주문자정보 가져오기
	public UserDto getUser(String userId) throws Exception;
 
	// ordersuccess를 y로 
	public void paySuccess(CartDto success) throws Exception;
	
	// 주문일자 
	public void paySuccess1(CartDto success) throws Exception;
	
// 주문내역 
	public List<CartDto> getSuccessList(String userId) throws Exception;

	

	 // 유저정보 가져오기
	

	
	
	

	

}
