package com.readbook.entity;

import java.math.BigDecimal;

public class Book {

	/**����ID*/
	private Long id;
	
	/**����ID*/
	private Long shopId;
	
	/**��������*/
	private String shopName;
	
	/**���ID*/
	private Long bookCaseId;
	
	/**�����*/
	private String bookCaseNumber;
	
	/**�鼮����*/
	private String bookName;
	
	/**�鼮���*/
	private String number;
	
	/**����*/
	private String author;
	
	/**�۸�*/
	private BigDecimal price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
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
}
