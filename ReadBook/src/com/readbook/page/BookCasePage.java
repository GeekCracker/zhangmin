package com.readbook.page;

import com.readbook.entity.BookCase;

/**
 * ����ҳ��Ϣ�����壨����ҳ���������
 * @author ����
 */
public class BookCasePage extends Page<BookCase> {

	/**�����*/
	private String number;
	
	/**�ŵ�ID*/
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
