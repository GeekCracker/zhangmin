package com.readbook.dao;

import java.util.List;

import com.readbook.entity.BookCase;

/**
 * ���DAO
 * @author ����
 */
public interface BookCaseDao {

	/**
	 * ������
	 * @param bookCase ������Ҫ��ӵ����
	 * @return ��������ID
	 */
	Long addBookCase(BookCase bookCase);
	
	/**
	 * ����IDɾ�����
	 * @param id �������ID
	 */
	void deleteById(Long id);
	
	/**
	 * ����ID�޸������Ϣ
	 * @param bookCase ������Ҫ�޸ĵ������Ϣ
	 */
	void updateById(BookCase bookCase);
	
	/**
	 * ��������ID��ѯ���
	 * @param id ��������ID
	 * @return ���������Ϣ
	 */
	BookCase selectById(Long id);
	
	/**
	 * ����������ѯ��������
	 * @param sql ����SQL���
	 * @param objs �����ѯ����
	 * @return ������������
	 */
	Long selectTotal(String sql,Object...objs);
	
	/**
	 * ����������ѯ��ҳ����
	 * @param sql ����SQL���
	 * @param objs �����ѯ����
	 * @return ���ط�ҳ�����б�
	 */
	List<BookCase> selectPageData(String sql,Object...objs);
	
	/**
	 * ����������ѯ���ݣ��Ƿ�ҳ���ݣ�
	 * @param sql ����SQL���
	 * @param objs �����ѯ����
	 * @return ���������б�
	 */
	List<BookCase> selectData(String sql,Object...objs);
}
