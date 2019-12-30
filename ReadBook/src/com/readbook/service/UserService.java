package com.readbook.service;

import com.readbook.entity.User;

public interface UserService {

	/**
	 * 用户登录方法
	 * @param username 传入用户名
	 * @param password 传入用户密码
	 * @return 返回用户信息
	 */
	User login(String username,String password) throws Exception;
}
