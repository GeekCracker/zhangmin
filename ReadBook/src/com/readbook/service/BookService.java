package com.readbook.service;

import com.readbook.entity.Book;
import com.readbook.page.BookPage;
import com.readbook.response.ResponseResult;

public interface BookService {

	
	/**
	 * ����鼮
	 * @param book ������Ҫ��ӵ��鼮
	 * @return ��������ID
	 */
	Long save(Book book);
	
	/**
	 * ����IDɾ���鼮
	 * @param id �����鼮ID
	 */
	void deleteById(Long id);

	/**
	 * ����ID�޸��鼮
	 * @param book ������Ҫ�޸ĵ��鼮
	 */
	void updateById(Book book);
	
	/**
	 * ����ID��ѯ�鼮
	 * @param id �����鼮ID
	 * @return �����鼮��Ϣ
	 */
	Book queryById(Long id);

	/**
	 * ��ȡ�鼮��ҳ����
	 * @param page �����ҳ��������
	 * @return ���ط�ҳ����
	 */
	ResponseResult queryPageData(BookPage page);
	
}
