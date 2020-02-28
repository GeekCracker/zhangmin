package com.readbook.service;

import java.util.List;
import java.util.Map;

import com.readbook.entity.BookCase;
import com.readbook.page.BookCasePage;
import com.readbook.response.ResponseResult;

/**
 * 书柜Service
 * @author 张敏
 */
public interface BookCaseService {

	/**
	 * 添加书柜
	 * @param bookCase 传入需要添加的书柜
	 * @return 返回主键ID
	 */
	Long save(BookCase bookCase);
	
	/**
	 * 根据ID删除书柜
	 * @param id 传入ID
	 */
	void deleteById(Long id);
	
	/**
	 * 根据ID修改书柜
	 * @param bookCase 传入需要修改的书柜
	 */
	void updateById(BookCase bookCase);
	
	/**
	 * 根据ID查询书柜
	 * @param id 传入主键ID
	 * @return 返回书柜
	 */
	BookCase queryById(Long id);
	
	/**
	 * 查询书柜分页数据
	 * @param page 传入分页查询条件参数
	 * @return 返回书柜分页数据
	 */
	ResponseResult queryPageData(BookCasePage page);
	
	/**
	 * 根据条件查询数据列表
	 * @param param 传入查询条件
	 * @return 返回书柜数据列表
	 */
	List<BookCase> queryData(Map<String,Object> param);
}
