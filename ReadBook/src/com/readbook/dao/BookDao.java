package com.readbook.dao;

import java.util.List;

import com.readbook.entity.Book;

public interface BookDao {

	/**
	 * 添加书籍
	 * @param book 传入需要添加的书籍
	 * @return 返回主键ID
	 */
	Long save(Book book);
	
	
	/**
	 * 根据ID删除
	 * @param id 传入主键ID
	 */
	void deleteById(Long id);
	
	
	/**
	 * 根据ID修改
	 * @param book 传入需要修改的书籍
	 */
	void updateById(Book book);
	
	/**
	 * 根据ID查询书籍详情
	 * @param id 传入书籍ID
	 * @return 返回书籍信息
	 */
	Book queryById(Long id);
	
	/**
	 * 查询数据总数
	 * @param sql 传入sql语句
	 * @param objs 传入查询条件
	 * @return 返回数据总数
	 */
	Long selectTotal(String sql,Object... objs);
	
	/**
	 * 查询书籍分页数据
	 * @param sql 传入sql
	 * @param objs 传入查询条件
	 * @return 返回书籍分页列表
	 */
	List<Book> selectPageData(String sql,Object...objs);
}
