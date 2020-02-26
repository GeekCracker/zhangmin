package com.readbook.dao;

import java.util.List;

import com.readbook.entity.Shop;

public interface ShopDao {

	/**
	 * 添加门店
	 * @param shop 传入需要添加的门店
	 * @return 返回门店ID
	 */
	Long addShop(Shop shop);
	
	/**
	 * 根据ID删除
	 * @param id 传入门店ID
	 */
	void deleteById(Long id);
	
	/**
	 * 根据ID修改门店
	 * @param shop 传入需要修改的门店
	 */
	void updateById(Shop shop);
	
	/**
	 * 根据ID查询
	 * @param id 传入门店ID
	 * @return 返回门店信息
	 */
	Shop selectById(Long id);
	
	/**
	 * 查询所有的门店
	 * @return 返回所有的门店
	 */
	List<Shop> selectAll();
	
	/**
	 * 获取数据总数
	 * @param sql 传入组装好的SQL语句
	 * @param objs 传入查询条件
	 * @return 返回数据总数
	 */
	Long selectTotal(String sql,Object...objs);
	
	/**
	 * 获取分页数据
	 * @param sql 传入组装好的SQL语句
	 * @param objs 传入查询条件
	 * @return 返回分页数据
	 */
	List<Shop> selectPageData(String sql,Object...objs);
}
