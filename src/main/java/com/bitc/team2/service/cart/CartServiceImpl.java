package com.bitc.team2.service.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitc.team2.dto.CartDto;
import com.bitc.team2.dto.UserDto;
import com.bitc.team2.mapper.CartMapper;

@Service
public class CartServiceImpl implements CartService {

	

	@Autowired
	private CartMapper cartMapper;
	
	// 장바구니 담기 
	@Override
	public void addCart(CartDto cart) throws Exception {
		

		cartMapper.addCart(cart);
	}

	// 장바구니 목록
	
	@Override
	public List<CartDto> cartList(String userId) throws Exception {
		
		if (userId == null || userId.equals("")) {
			userId = "N";
				
		}
		
		List<CartDto> cart = cartMapper.getCart(userId);
		
		return cart;
	}
	
	// 삭제 

	@Override
	public void deleteCart(int cartId) throws Exception {

		cartMapper.deleteCart(cartId);
		
	}
//
//	@Override
//	public int sumMoney(String userId) throws Exception {
//		// TODO Auto-generated method stub
//		
//		return cartMapper.sumMoney(userId);
//	}
 //장바구니 주문 
//	@Override
//	public void cartOrder(CartDto cartorder) throws Exception {
//		// TODO Auto-generated method stub
//		cartMapper.cartOrder(cartorder);
//	}

	@Override
	public UserDto selectUserInfo(String userId) throws Exception {

		if (userId == null || userId.equals("")) {
			userId = "N";
				
		}
		
	//	UserDto userInfo = cartMapper.getUser(userId);
		
		return cartMapper.getUser(userId);
	}

	 // 결제하기 
	@Override
	public void paySuccess(CartDto success) throws Exception {

		cartMapper.paySuccess1(success);

		 cartMapper.paySuccess(success);
		 
	}

	@Override
	public List<CartDto> selectSuccessList(String userId) throws Exception {
		
		if (userId == null || userId.equals("")) {
			userId = "N";
				
		}
		
		List<CartDto> cart = cartMapper.getSuccessList(userId);
		
		return cart;
	}




}
