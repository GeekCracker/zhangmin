package com.readbook.page;

import com.readbook.entity.BookCase;

/**
 * 书柜分页信息数据体（含分页请求参数）
 * @author 张敏
 */
public class BookCasePage extends Page<BookCase> {

	/**书柜编号*/
	private String number;
	
	/**门店ID*/
	private Long shopId;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}
}
