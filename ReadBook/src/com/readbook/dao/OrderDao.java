package com.readbook.dao;

import java.util.List;

import com.readbook.entity.Order;

public interface OrderDao {

	/**
	 * 添加订单
	 * @param order 传入需要添加的订单
	 * @return 返回主键ID
	 */
	Long save(Order order);
	
	
	/**
	 * 根据ID删除
	 * @param id 传入主键ID
	 */
	void deleteById(Long id);
	
	
	/**
	 * 根据ID修改
	 * @param order 传入需要修改的订单
	 */
	void updateById(Order order);
	
	/**
	 * 根据ID查询订单详情
	 * @param id 传入订单ID
	 * @return 返回订单信息
	 */
	Order queryById(Long id);
	
	/**
	 * 查询数据总数
	 * @param sql 传入sql语句
	 * @param objs 传入查询条件
	 * @return 返回数据总数
	 */
	Long selectTotal(String sql,Object... objs);
	
	/**
	 * 查询订单分页数据
	 * @param sql 传入sql
	 * @param objs 传入查询条件
	 * @return 返回订单分页列表
	 */
	List<Order> selectPageData(String sql,Object...objs);
}
