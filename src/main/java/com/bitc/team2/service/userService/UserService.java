package com.bitc.team2.service.userService;

import java.util.List;

import com.bitc.team2.dto.UserDto;

public interface UserService {

	int loginCheck(String userId, String userPw) throws Exception;

	void userJoin(UserDto user) throws Exception;

	List<UserDto> selectUserList() throws Exception;

	UserDto selectUserDetail(int seq) throws Exception;

	void updateUser(UserDto user) throws Exception;

	void userDelete(UserDto user) throws Exception;

	

}
