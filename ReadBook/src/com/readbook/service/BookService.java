package com.readbook.service;

import com.readbook.entity.Book;
import com.readbook.page.BookPage;
import com.readbook.response.ResponseResult;

public interface BookService {

	
	/**
	 * 添加书籍
	 * @param book 传入需要添加的书籍
	 * @return 返回主键ID
	 */
	Long save(Book book);
	
	/**
	 * 根据ID删除书籍
	 * @param id 传入书籍ID
	 */
	void deleteById(Long id);

	/**
	 * 根据ID修改书籍
	 * @param book 传入需要修改的书籍
	 */
	void updateById(Book book);
	
	/**
	 * 根据ID查询书籍
	 * @param id 传入书籍ID
	 * @return 返回书籍信息
	 */
	Book queryById(Long id);

	/**
	 * 获取书籍分页数据
	 * @param page 传入分页条件参数
	 * @return 返回分页数据
	 */
	ResponseResult queryPageData(BookPage page);
	
}
