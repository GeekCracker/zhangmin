package com.readbook.entity;

/**
 * 店长实体类
 * @author 张敏
 */
public class ShopManager {

	/**主键ID*/
	private Long id;
	
	/**店长名称*/
	private String managerName;
	
	/**店长联系方式*/
	private String managerPhone;
	
	/**店铺ID*/
	private Long shopId;
	
	/**店铺名称*/
	private String shopName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerPhone() {
		return managerPhone;
	}

	public void setManagerPhone(String managerPhone) {
		this.managerPhone = managerPhone;
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
}
