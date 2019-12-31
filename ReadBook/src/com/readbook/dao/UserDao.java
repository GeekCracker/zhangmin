package com.readbook.dao;

import java.util.List;
import com.readbook.entity.User;

public interface UserDao {

	
	/**
	 * 登录方法
	 * @param username 传入用户名
	 * @param password 传入密码
	 * @return 返回用户信息
	 */
	public User login(String username,String password);

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
	 * 查询数据总数
	 * @param sql 传入sql语句
	 * @param objs 传入查询条件
	 * @return 返回数据总数
	 */
	Long selectTotal(String sql,Object... objs);
	
	/**
	 * 查询分页数据
	 * @param sql 传入sql语句
	 * @param objs 传入查询条件
	 * @return 返回分页数据
	 */
	List<User> selectPageData(String sql,Object... objs);
}
