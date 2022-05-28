package com.bitc.team2.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bitc.team2.dto.UserDto;
import com.bitc.team2.service.userService.UserService;

@Controller
public class AppController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/")
	public String test() throws Exception{
		return "index";
	}
	@RequestMapping("/main")
	public ModelAndView mainPage(HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		ModelAndView mv = new ModelAndView("main");
		if(userId!=null) {
			List<UserDto> user = userService.selectUserList();
			mv.addObject("user", user);
		}
		return mv;
	}
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login() throws Exception{
		return "user/login";
	}

	@RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
	public String loginCheck(UserDto user, HttpServletRequest request) throws Exception {
		int count = userService.loginCheck(user.getUserId(), user.getUserPw());
		if (count == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("userId", user.getUserId());
//			session.setMaxInactiveInterval(30);
			return "redirect:/main";
		} else {
			//
			return "redirect:/loginFail";
		}
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String userJoinPage() throws Exception {
		return "/user/join";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String userJoin(UserDto user) throws Exception {
		userService.userJoin(user);
		return "redirect:/login";
	}
	// 로그아웃
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		session.removeAttribute("userId");
		session.invalidate();
		return "/user/login";
	}
	//로그인 실패
	@RequestMapping("/loginFail")
	public String loginFail() throws Exception{
		return "/user/loginFail";
	}
	//마이페이지
	@RequestMapping("/myPage")
	public ModelAndView myPage() throws Exception{
		ModelAndView mv = new ModelAndView("myPage/myPage");
		List<UserDto> user = userService.selectUserList();
		mv.addObject("user", user);
		return mv;
	}
//	정보 수정 페이지
	@RequestMapping(value="/userEdit/{seq}", method=RequestMethod.GET)
	public ModelAndView userDetail(@PathVariable("seq") int seq) throws Exception{
		ModelAndView mv = new ModelAndView("/myPage/userEdit");
		UserDto user = userService.selectUserDetail(seq);
		mv.addObject("user", user);
		return mv;
	}
//	수정 완료 후 로그인 페이지로 이동
	@RequestMapping(value = "/userEdit/{seq}", method = RequestMethod.POST)
	public String updateUserList(UserDto user,HttpServletRequest request) throws Exception {
		userService.updateUser(user);
		HttpSession session = request.getSession();
		session.removeAttribute("userId");
		session.invalidate();
		return "redirect:/login";
	}
//	회원정보 삭제 후 메인페이지로 이동
	@RequestMapping(value = "/userEdit/{seq}", method = RequestMethod.DELETE)
	public String UserDelete(UserDto user,HttpServletRequest request) throws Exception {
//		userService.userDelete(user);
//		회원정보 삭제후에도 로그인이 유지되는 상황 방지...
		HttpSession session = request.getSession();
		session.removeAttribute("userId");
		session.invalidate();
		return "redirect:/main";
	}
}
