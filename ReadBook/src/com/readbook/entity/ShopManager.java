package com.readbook.entity;

/**
 * �곤ʵ����
 * @author ����
 */
public class ShopManager {

	/**����ID*/
	private Long id;
	
	/**�곤����*/
	private String managerName;
	
	/**�곤��ϵ��ʽ*/
	private String managerPhone;
	
	/**����ID*/
	private Long shopId;
	
	/**��������*/
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
