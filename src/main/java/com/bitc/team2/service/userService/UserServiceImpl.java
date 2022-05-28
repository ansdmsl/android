package com.bitc.team2.service.userService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitc.team2.dto.UserDto;
import com.bitc.team2.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public int loginCheck(String userId, String userPw) throws Exception {
		
		return userMapper.loginCheck(userId, userPw);
	}

	@Override
	public void userJoin(UserDto user) throws Exception {
		userMapper.userJoin(user);
	}

	@Override
	public List<UserDto> selectUserList() throws Exception {
		
		return userMapper.selectUserList();
	}

	@Override
	public UserDto selectUserDetail(int seq) throws Exception {
		
		return userMapper.selectUserDetail(seq);
	}

	@Override
	public void updateUser(UserDto user) throws Exception {
		userMapper.updateUser(user);
		
	}

	@Override
	public void userDelete(UserDto user) throws Exception {
		userMapper.userDelete(user);
		
	}



}
