package com.readbook.entity;

/**
 * 书柜实体类
 * @author 张敏
 */
public class BookCase {

	/**主键ID*/
	private Long id;
	
	/**书柜编号*/
	private String number;
	
	/**书柜所属门店ID*/
	private Long shopId;
	
	/**书柜所属门店名称*/
	private String shopName;

	/* TODO是待实现的意思，可以方面我们找到那些地方都是待实现的 
	 * 可以到 Tasks窗口查看待实现的地方，双击后跳转到待实现的位置
	 * */
	// TODO  还有一些书柜的属性，先略过，用到再追加。。
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
}
