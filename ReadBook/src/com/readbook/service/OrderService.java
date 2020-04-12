package com.readbook.service;


import com.readbook.entity.Order;
import com.readbook.page.OrderPage;
import com.readbook.response.ResponseResult;

public interface OrderService {

	/**
	 * 添加订单
	 * @param book 传入需要添加的订单
	 * @return 返回主键ID
	 */
	Long save(Order order);
	
	/**
	 * 根据ID删除订单
	 * @param id 传入订单ID
	 */
	void deleteById(Long id);

	/**
	 * 根据ID修改订单
	 * @param order 传入需要修改的订单
	 */
	void updateById(Order order);
	
	/**
	 * 根据ID查询订单
	 * @param id 传入订单ID
	 * @return 返回订单信息
	 */
	Order queryById(Long id);

	/**
	 * 获取订单分页数据
	 * @param page 传入分页条件参数
	 * @return 返回分页数据
	 */
	ResponseResult queryPageData(OrderPage page);
}
