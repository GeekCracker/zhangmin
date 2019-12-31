package com.readbook.page;

import com.readbook.entity.User;

public class UserPage extends Page<User> {
	
	/**用户名*/
	private String username;
	
	/**联系方式*/
	private String phone;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
