package com.readbook.entity;

/**
 * ����ʵ����
 * @author ����
 */
public class Shop {

	/**����ID*/
	private Long id;

	/**�ŵ�����*/
	private String shopName;
	
	/**�ŵ��ַ*/
	private String address;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
