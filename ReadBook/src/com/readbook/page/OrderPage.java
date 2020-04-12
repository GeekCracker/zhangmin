package com.readbook.page;

import com.readbook.entity.Order;

public class OrderPage extends Page<Order>{
	
	/**订单编号*/
	private String orderCode;
	
	/**书店ID*/
	private Long shopId;
	
	/**书柜ID*/
	private Long bookCaseId;
	
	/**书籍编号*/
	private String bookNumber;
	
	/**书籍名称*/
	private String bookName;
	
	/**会员编号*/
	private String memberCode;
	
	/**会员手机号*/
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
