package com.bitc.team2.controller;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bitc.team2.dto.CartDto;
import com.bitc.team2.dto.UserDto;
import com.bitc.team2.service.cart.CartService;

@Controller
public class CartController {
	
	@Autowired
	private CartService cartService;
	
//	@Autowired
//	private JService jService;
//	
	
	
	
	// 카트 담기
	@ResponseBody
	@RequestMapping(value = "/cart/add", method = RequestMethod.POST)
	public Object addCart(CartDto cart,  HttpSession session) throws Exception {
		// 카트 등록
		
		
		String userId = (String) session.getAttribute("userId");
		cart.setUserId(userId);
		
		if (userId == null || userId.equals("")) {
			String userId1 = "N";
			cart.setUserId(userId1);
			
		}else { 
			cart.setUserId(userId);

		}
		
		cart.setTotalPrice( cart.getMenuCount() * cart.getMenuPrice() );
		
		cartService.addCart(cart);
			
//		HashMap<String, Object> map = new HashMap<String, Object>();
//		map.put("menuCount", cart.getMenuCount());
//
//		return map;
		return "redirect:/menu";
		
	
	}
	

	// 장바구니 물품 삭제
	
		@ResponseBody
		@RequestMapping(value = "/cart/cartItemDelete.do")
		public Map<String, String> cartItemDelete(@RequestParam("cartId") int cartId) throws Exception {
			
			Map<String, String> result = new HashMap<String, String>();

			cartService.deleteCart(cartId);

			result.put("result", "success");

			return result;
		}

	
	

// 카트보기
	@RequestMapping(value = "/cart/mycart/", method = RequestMethod.GET)
	public String myCart(Model model ,HttpSession session) throws Exception {
		

		
		String userId = (String) session.getAttribute("userId");


//        Map<String, Object> map = new HashMap<String, Object>();
//        int sumMoney = cartService.sumMoney(userId); // 장바구니 전체 금액 호출
        
//		CartDto cartsum = cartService.selectCostCalculate(cart);
//		mv.addObject("cartsum", cartsum);

		 
		 Map<String, Object> map = new HashMap<String, Object>();
	
	// 	model.addAttribute("cartList", cartService.cartList(userId) );
		List<CartDto> cartList = cartService.cartList(userId);
		model.addAttribute("cartList", cartList);
		
		int total = 0;

		for (CartDto shop : cartList) {
			total += shop.getTotalPrice();
		}
		
		map.put("sumTotal", total);
		map.put("finalCost", total + 2000);
		
		
		model.addAttribute("priceInfo", map);
		
		
//		 map.put("sumMoney", sumMoney);        // 장바구니 전체 금액
//	     map.put("allSum", sumMoney+ 2000);    // 주문 상품 전체 금액
		
		return "/cart/mycart";
	}
	

	
//	
	// 주문페이지로 
	@RequestMapping(value = "/order/order" , method = RequestMethod.GET)
	public String orderpage( Model model ,HttpSession session) throws Exception {

		String userId = (String) session.getAttribute("userId");

//        Map<String, Object> map = new HashMap<String, Object>();
//        int sumMoney = cartService.sumMoney(userId); // 장바구니 전체 금액 호출
        
//		CartDto cartsum = cartService.selectCostCalculate(cart);
//		mv.addObject("cartsum", cartsum);
		 
		Map<String, Object> map = new HashMap<String, Object>();
	
	 //	model.addAttribute("cartList", cartService.cartList(userId) );
		List<CartDto> cartList = cartService.cartList(userId);
		model.addAttribute("cartList", cartList);
		
		//유저정보가져오기 
		UserDto userInfo = cartService.selectUserInfo(userId);
//		userInfo.setUserId(userId);

		model.addAttribute("userInfo", userInfo);
		
		int total = 0;

		for (CartDto shop : cartList) {
			total += shop.getTotalPrice();
		}
		
		map.put("sumTotal", total);
		map.put("finalCost", total + 2000);
				
		model.addAttribute("priceInfo", map);
		
//		 map.put("sumMoney", sumMoney);        // 장바구니 전체 금액
	//     map.put("allSum", sumMoney+ 2000);    // 주문 상품 전체 금액
		
		return "/order/order";
	}


	
//	// 결제하기시 insert  or update
//
	@RequestMapping("/cart/order/success.do")
	public String ordersuccess(CartDto success , HttpSession session) throws Exception {
		
		String userId = (String) session.getAttribute("userId");
		success.setUserId(userId);
		
		if (userId == null || userId.equals("")) {
			String userId1 = "N";
			success.setUserId(userId1);
			
		}else { 
			success.setUserId(userId);

		}
		
		// 캘린더 호출 주문일자
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);  // 연도 추출
		String ym = year + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);  // 월 추출
		String ymd = ym +  new DecimalFormat("00").format(cal.get(Calendar.DATE));  // 일 추출
		String ymdh = ymd +  new DecimalFormat("00").format(cal.get(Calendar.HOUR_OF_DAY)); //시간
		String ymdhf = ymdh +  new DecimalFormat("00").format(cal.get(Calendar.MINUTE)); //시간
		
		String orderId = ymdhf;  // [연월일]_[랜덤숫자] 로 구성된 문자
		success.setOrderDate(orderId);
		
		
		cartService.paySuccess(success);
		return "redirect:/orderSuccess.do";
	}
	
 // 주문내역 
	@RequestMapping("/orderSuccess.do")
	public ModelAndView historypage(HttpSession session) throws Exception {
		
		String userId = (String) session.getAttribute("userId");
		
		ModelAndView mv = new ModelAndView("/order/orderSuccess");
		List<CartDto> successList = cartService.selectSuccessList(userId);
		mv.addObject("successList", successList);
		
		

				
		return mv;
	}


}


