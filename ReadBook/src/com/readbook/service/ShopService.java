package com.readbook.service;

import java.util.List;

import com.readbook.entity.Shop;
import com.readbook.page.ShopPage;
import com.readbook.response.ResponseResult;

/**
 * 门店Service层
 * @author 张敏
 */
public interface ShopService {

	/**
	 * 添加门店
	 * @param shop 传入需要添加的门店
	 */
	void save(Shop shop);
	
	/**
	 * 根据ID删除门店
	 * @param id 传入门店ID
	 */
	void deleteById(Long id);
	
	/**
	 * 根据ID修改门店
	 * @param shop 传入需要修改的门店
	 */
	void updateById(Shop shop);
	
	/**
	 * 根据ID查询门店信息
	 * @param id 传入门店ID
	 * @return 返回门店信息
	 */
	Shop queryById(Long id);
	
	/**
	 * 获取所有的门店
	 * @return 返回所有的门店
	 */
	List<Shop> queryAll();
	
	/**
	 * 获取门店分页列表数据
	 * @param shopPage 传入查询的分页参数
	 * @return 返回分页数据
	 */
	ResponseResult queryPageData(ShopPage shopPage);
}
