package com.readbook.page;

import com.readbook.entity.Book;

public class BookPage extends Page<Book>{

	/**����ID*/
	private Long shopId;
	
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
}
