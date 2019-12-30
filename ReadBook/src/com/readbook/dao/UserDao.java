package com.readbook.dao;

import java.lang.reflect.InvocationTargetException;

import com.readbook.entity.User;

public interface UserDao {

	
	/**
	 * 登录方法
	 * @param username 传入用户名
	 * @param password 传入密码
	 * @return 返回用户信息
	 */
	public User login(String username,String password)  throws NullPointerException, IllegalAccessException, InvocationTargetException, InstantiationException;
}
