package com.readbook.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * ����ʵ����
 * @author ����
 */
public class Order {

	/**����ID*/
	private Long id;
	
	/**�������*/
	private String orderCode;
	
	/**��ԱID*/
	private Long memberId;
	
	/**��Ա���*/
	private String memberCode;
	
	//������������
	/**���ID*/
	private Long shopId;
	
	/**�������*/
	private String shopName;
	
	/**���ID*/
	private Long bookCaseId;
	
	/**�����*/
	private String bookCaseNumber;
	
	/**�鼮ID*/
	private Long bookId;
	
	/**�鼮���*/
	private String bookNumber;
	
	/**�鼮����*/
	private String bookName;
	
	/**�鼮����*/
	private String author;

	/**�鼮�۸�*/
	private BigDecimal price;
	
	/**֧�����*/
	private BigDecimal payAmount;
	
	/**֧��ʱ��*/
	private Date payTime;
	
	/**����״̬��0��δȷ��1����ȷ��2����֧��3���ѷ���4����ǩ��5������ɣ�*/
	private Integer state;
	
	/**����ʱ��*/
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
