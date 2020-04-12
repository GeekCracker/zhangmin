package com.readbook.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单实体类
 * @author 张敏
 */
public class Order {

	/**订单ID*/
	private Long id;
	
	/**订单编号*/
	private String orderCode;
	
	/**会员ID*/
	private Long memberId;
	
	/**会员编号*/
	private String memberCode;
	
	//订单快照数据
	/**书店ID*/
	private Long shopId;
	
	/**书店名称*/
	private String shopName;
	
	/**书柜ID*/
	private Long bookCaseId;
	
	/**书柜编号*/
	private String bookCaseNumber;
	
	/**书籍ID*/
	private Long bookId;
	
	/**书籍编号*/
	private String bookNumber;
	
	/**书籍名称*/
	private String bookName;
	
	/**书籍作者*/
	private String author;

	/**书籍价格*/
	private BigDecimal price;
	
	/**支付金额*/
	private BigDecimal payAmount;
	
	/**支付时间*/
	private Date payTime;
	
	/**订单状态（0：未确认1：已确认2：已支付3：已发货4：已签收5：已完成）*/
	private Integer state;
	
	/**创建时间*/
	private Date createTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public Long getBookCaseId() {
		return bookCaseId;
	}

	public void setBookCaseId(Long bookCaseId) {
		this.bookCaseId = bookCaseId;
	}

	public String getBookCaseNumber() {
		return bookCaseNumber;
	}

	public void setBookCaseNumber(String bookCaseNumber) {
		this.bookCaseNumber = bookCaseNumber;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(BigDecimal payAmount) {
		this.payAmount = payAmount;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
