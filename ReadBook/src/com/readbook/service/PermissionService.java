package com.readbook.service;

import java.util.List;

import com.readbook.entity.Permission;
import com.readbook.page.PermissionPage;

public interface PermissionService {

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
	 * 获取分页数据
	 * @param page 传入分页参数
	 * @return 返回分页数据
	 */
	PermissionPage queryPageData(PermissionPage page);
	
	/**
	 * 获取权限树
	 * @return 返回权限树
	 */
	List<Permission> permissionTree();
}
