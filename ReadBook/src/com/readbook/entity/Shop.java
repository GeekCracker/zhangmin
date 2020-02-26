package com.readbook.entity;

/**
 * 店铺实体类
 * @author 张敏
 */
public class Shop {

	/**主键ID*/
	private Long id;

	/**门店名称*/
	private String shopName;
	
	/**门店地址*/
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
