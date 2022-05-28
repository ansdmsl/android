package com.bitc.team2.dto;

import lombok.Data;

@Data
public class UserDto {
	private int seq;
	private String userId;
	private String userPw;
	private String userName;
	private String userAddr;
	private String userPhone;
	private String userAddrDetail;
	private String userStore;
}
