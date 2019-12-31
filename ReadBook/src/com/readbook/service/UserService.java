package com.readbook.service;

import com.readbook.entity.User;
import com.readbook.page.UserPage;

public interface UserService {

	/**
	 * 用户登录方法
	 * @param username 传入用户名
	 * @param password 传入用户密码
	 * @return 返回用户信息
	 */
	User login(String username,String password);
	
	/**
	 * 添加用户
	 * @param user 传入需要添加的用户
	 */
	void save(User user);
	
	/**
	 * 根据ID删除用户
	 * @param id 传入用户ID
	 */
	void deleteById(Long id);
	
	/**
	 * 根据ID修改用户信息
	 * @param user 传入需要修改的用户信息
	 */
	void updateById(User user);

	
	/**
	 * 获取分页数据
	 * @param page 传入分页参数
	 * @return 返回分页数据
	 */
	UserPage queryPageData(UserPage page);
}
