package com.readbook.dao;

import java.util.List;

import com.readbook.entity.BookCase;

/**
 * 书柜DAO
 * @author 张敏
 */
public interface BookCaseDao {

	/**
	 * 添加书柜
	 * @param bookCase 传入需要添加的书柜
	 * @return 返回主键ID
	 */
	Long addBookCase(BookCase bookCase);
	
	/**
	 * 根据ID删除书柜
	 * @param id 传入书柜ID
	 */
	void deleteById(Long id);
	
	/**
	 * 根据ID修改书柜信息
	 * @param bookCase 传入需要修改的书柜信息
	 */
	void updateById(BookCase bookCase);
	
	/**
	 * 根据主键ID查询书柜
	 * @param id 传入主键ID
	 * @return 返回书柜信息
	 */
	BookCase selectById(Long id);
	
	/**
	 * 根据条件查询数据总数
	 * @param sql 传入SQL语句
	 * @param objs 传入查询条件
	 * @return 返回数据总数
	 */
	Long selectTotal(String sql,Object...objs);
	
	/**
	 * 根据条件查询分页数据
	 * @param sql 传入SQL语句
	 * @param objs 传入查询条件
	 * @return 返回分页数据列表
	 */
	List<BookCase> selectPageData(String sql,Object...objs);
	
	/**
	 * 根据条件查询数据（非分页数据）
	 * @param sql 传入SQL语句
	 * @param objs 传入查询条件
	 * @return 返回数据列表
	 */
	List<BookCase> selectData(String sql,Object...objs);
}
