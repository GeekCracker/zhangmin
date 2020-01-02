package com.readbook.dao;

import java.util.List;

import com.readbook.entity.RolePermission;

public interface RolePermissionDao {

	/**
	 * 添加角色对应权限记录
	 * @param rolePermission 传入需要添加的实例
	 * @return 返回受影响行数
	 */
	int save(RolePermission rolePermission);
	/**
	 * 批量添加角色对应权限
	 * @param list 传入角色对应权限关联实例
	 * @return 返回受影响行数
	 */
	int saveBatch(List<RolePermission> list);
	
	/**
	 * 根据角色ID删除
	 * @param roleId 传入角色ID
	 * @return 返回受影响行数
	 */
	int deleteByRoleId(Long roleId);
}
