package com.readbook.page;

import com.readbook.entity.Shop;

/**
 * 门店分页信息数据体（含分页请求参数）
 * @author 张敏
 */
public class ShopPage extends Page<Shop>{

	/**门店名称*/
	private String shopName;

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
}
