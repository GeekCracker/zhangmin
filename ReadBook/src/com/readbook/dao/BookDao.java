package com.readbook.dao;

import java.util.List;

import com.readbook.entity.Book;

public interface BookDao {

	/**
	 * ����鼮
	 * @param book ������Ҫ��ӵ��鼮
	 * @return ��������ID
	 */
	Long save(Book book);
	
	
	/**
	 * ����IDɾ��
	 * @param id ��������ID
	 */
	void deleteById(Long id);
	
	
	/**
	 * ����ID�޸�
	 * @param book ������Ҫ�޸ĵ��鼮
	 */
	void updateById(Book book);
	
	/**
	 * ����ID��ѯ�鼮����
	 * @param id �����鼮ID
	 * @return �����鼮��Ϣ
	 */
	Book queryById(Long id);
	
	/**
	 * ��ѯ��������
	 * @param sql ����sql���
	 * @param objs �����ѯ����
	 * @return ������������
	 */
	Long selectTotal(String sql,Object... objs);
	
	/**
	 * ��ѯ�鼮��ҳ����
	 * @param sql ����sql
	 * @param objs �����ѯ����
	 * @return �����鼮��ҳ�б�
	 */
	List<Book> selectPageData(String sql,Object...objs);
}
