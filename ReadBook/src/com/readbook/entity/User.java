package com.readbook.entity;

/**
 * 用户实体类
 * @author 张敏
 */
public class User {

	/** 主键ID */
	private Long id;

	/** 用户名 */
	private String username;

	/** 用户密码 */
	private String password;
	
	/** 用户联系方式 */
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
