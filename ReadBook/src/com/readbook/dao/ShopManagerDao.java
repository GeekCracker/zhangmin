package com.readbook.dao;

import java.util.List;

import com.readbook.entity.ShopManager;

public interface ShopManagerDao {

	/**
	 * 添加店长
	 * @param shopManager 传入需要添加的店长
	 * @return 返回主键ID
	 */
	Long save(ShopManager shopManager);
	
	/**
	 * 根据ID删除
	 * @param id 传入店长ID
	 */
	void deleteById(Long id);
	
	/**
	 * 根据ID修改店长信息
	 * @param shopManager 传入需要修改的店长
	 */
	void updateById(ShopManager shopManager);
	
	/**
	 * 根据ID查询店长
	 * @param id 传入店长ID
	 * @return 返回店长信息
	 */
	ShopManager selectById(Long id);
	
	/**
	 * 根据条件查询数据总数
	 * @param sql 传入sql语句
	 * @param objs 传入条件参数
	 * @return 返回数据总数
	 */
	Long selectTotal(String sql,Object...objs);
	
	/**
	 * 查询店长分页数据
	 * @param sql 传入sql语句
	 * @param objs 传入条件参数
	 * @return 返回分页数据
	 */
	List<ShopManager> selectPageData(String sql,Object...objs);
}
