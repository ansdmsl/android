package com.bitc.team2.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bitc.team2.dto.UserDto;

@Mapper
public interface UserMapper {

	int loginCheck(@Param("userId")String userId, @Param("userPw")String userPw) throws Exception;

	void userJoin(UserDto user) throws Exception;

	List<UserDto> selectUserList() throws Exception;

	UserDto selectUserDetail(int seq) throws Exception;

	void updateUser(UserDto user) throws Exception;

	void userDelete(UserDto user) throws Exception;

}
