package com.readbook.dao;

import java.util.List;

import com.readbook.entity.Role;

public interface RoleDao {

	/**
	 * 添加角色
	 * @param role 传入需要添加的角色
	 */
	void save(Role role);
	
	/**
	 * 根据ID删除角色
	 * @param id 传入角色ID
	 */
	void deleteById(Long id);
	
	/**
	 * 根据ID修改角色
	 * @param role 传入需要修改的角色
	 */
	void updateById(Role role);
	
	
	/**
	 * 查询数据总数
	 * @param sql 传入sql语句
	 * @param objs 传入查询条件
	 * @return 返回数据总数
	 */
	Long selectTotal(String sql,Object... objs);
	
	/**
	 * 获取所有的角色
	 * @return 返回所有的角色
	 */
	List<Role> selectAll();
	
	/**
	 * 查询分页数据
	 * @param sql 传入sql语句
	 * @param objs 传入查询条件
	 * @return 返回分页数据
	 */
	List<Role> selectPageData(String sql,Object... objs);
}
