package com.readbook.entity;

/**
 * ���ʵ����
 * @author ����
 */
public class BookCase {

	/**����ID*/
	private Long id;
	
	/**�����*/
	private String number;
	
	/**��������ŵ�ID*/
	private Long shopId;
	
	/**��������ŵ�����*/
	private String shopName;

	/* TODO�Ǵ�ʵ�ֵ���˼�����Է��������ҵ���Щ�ط����Ǵ�ʵ�ֵ� 
	 * ���Ե� Tasks���ڲ鿴��ʵ�ֵĵط���˫������ת����ʵ�ֵ�λ��
	 * */
	// TODO  ����һЩ�������ԣ����Թ����õ���׷�ӡ���
	
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
