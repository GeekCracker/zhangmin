package com.readbook.service;

import java.util.List;

import com.readbook.entity.Role;
import com.readbook.page.RolePage;
import com.readbook.response.ResponseResult;

public interface RoleService{
	
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
	 * 根据ID修改角色信息
	 * @param role 传入需要修改的角色信息
	 */
	void updateById(Role role);

	/**
	 * 获取所有的角色
	 * @return 返回所有的角色
	 */
	List<Role> queryAll();
	
	/**
	 * 获取分页数据
	 * @param page 传入分页参数
	 * @return 返回分页数据
	 */
	ResponseResult queryPageData(RolePage page);
}
