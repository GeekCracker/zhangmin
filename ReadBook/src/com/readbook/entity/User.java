package com.readbook.entity;

/**
 * �û�ʵ����
 * @author ����
 */
public class User {

	/** ����ID */
	private Long id;

	/** �û��� */
	private String username;

	/** �û����� */
	private String password;
	
	/** �û���ϵ��ʽ */
	private String phone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
