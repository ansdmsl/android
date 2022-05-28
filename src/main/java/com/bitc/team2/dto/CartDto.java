package com.bitc.team2.dto;

import lombok.Data;

@Data
public class CartDto {

	private int cartId;
	private int menuSeq;
	private int menuCount;
	private String menuName;
	private int menuPrice;
	private int totalPrice;
	private String menuStoredFilePath;
	private String userId;
	private char deletedYn;
	private int deliveryCost;
	private int sumTotal;
	private int orderSeq;
	private int finalCost;
	private char checkedYn;
	private int successQty;
	private char paySuccess;
	
	private String orderDate;
}
