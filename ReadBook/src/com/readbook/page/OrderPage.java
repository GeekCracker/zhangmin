package com.readbook.page;

import com.readbook.entity.Order;

public class OrderPage extends Page<Order>{
	
	/**�������*/
	private String orderCode;
	
	/**���ID*/
	private Long shopId;
	
	/**���ID*/
	private Long bookCaseId;
	
	/**�鼮���*/
	private String bookNumber;
	
	/**�鼮����*/
	private String bookName;
	
	/**��Ա���*/
	private String memberCode;
	
	/**��Ա�ֻ���*/
	private String phone;

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public Long getBookCaseId() {
		return bookCaseId;
	}

	public void setBookCaseId(Long bookCaseId) {
		this.bookCaseId = bookCaseId;
	}

	public String getBookNumber() {
		return bookNumber;
	}

	public void setBookNumber(String bookNumber) {
		this.bookNumber = bookNumber;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
