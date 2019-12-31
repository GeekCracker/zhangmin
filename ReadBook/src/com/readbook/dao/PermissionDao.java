package com.readbook.dao;

import java.util.List;

import com.readbook.entity.Permission;

public interface PermissionDao {
	/**
	 * 添加权限
	 * @param permission 传入需要添加的权限
	 */
	void save(Permission permission);
	
	/**
	 * 根据ID删除权限
	 * @param id 传入权限ID
	 */
	void deleteById(Long id);
	
	/**
	 * 根据ID修改权限
	 * @param permission 传入需要修改的权限
	 */
	void updateById(Permission permission);
	
	
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
	List<Permission> selectPageData(String sql,Object... objs);
	
	/**
	 * 获取所有的权限
	 * @return 返回所有的权限
	 */
	List<Permission> selectAll();
}
