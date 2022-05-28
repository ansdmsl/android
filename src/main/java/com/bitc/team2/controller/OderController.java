package com.bitc.team2.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bitc.team2.dto.MenuDto;
import com.bitc.team2.dto.UserDto;
import com.bitc.team2.service.olderList.OrderService;


@Controller
public class OderController {
	
	@Autowired
	private OrderService orderService;
	
	///////////////////**********************주소 검색***************************//////////////////////////////
	// 주문자 배송지
	/*
	 * @RequestMapping(value="/map") public String mapinsert() throws Exception {
	 * return "order/map"; }
	 * 
	 * @RequestMapping(value="/map/mapRegister") public String mapregister(OrderDto
	 * order) throws Exception { orderService.mapinsert(order); return "redirect:";
	 * //주문하기 페이지 주소 넣어 }ㄴ
	 */
	
	
	///////////////////**********************위치 찾기***************************//////////////////////////////
	// 매장 위치 찾기	
	@RequestMapping(value="/store", method=RequestMethod.GET) 
	public String store() throws Exception { 
		return "order/store"; 
	}
	
	// ajax 통신
	@ResponseBody
	@RequestMapping(value="/store/storeName", method=RequestMethod.POST) 
	public String storeName(@RequestParam("storeName") String storeName, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		// 사용자 id, 가게 이름를 매개변수로 가져가서 db 업데이트
		orderService.updateStore(userId, storeName);
		
		return "order/store"; 
	}
	
	
	
	
	

	///////////////////**********************주문***************************//////////////////////////////
	// 주문 정보 확인 페이지	
	@RequestMapping(value="/orderCheck")
	public ModelAndView orderCheck() throws Exception {
		ModelAndView mv = new ModelAndView("order/orderCheck");
		
		List<UserDto> userList = orderService.selectUserList();
		List<MenuDto> menuList = orderService.selectMenuList();
		
		mv.addObject("userList", userList);
		mv.addObject("menuList", menuList);
		
		return mv;
	}
	
	
	// 주문 완료 페이지 ******************************
	@RequestMapping(value="/orderOk")
	public String orderOk() throws Exception {
		return "order/orderOk";
	}
	
	
	
	
	
}
