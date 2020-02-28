package com.readbook.service;

import java.util.List;
import java.util.Map;

import com.readbook.entity.BookCase;
import com.readbook.page.BookCasePage;
import com.readbook.response.ResponseResult;

/**
 * ���Service
 * @author ����
 */
public interface BookCaseService {

	/**
	 * ������
	 * @param bookCase ������Ҫ��ӵ����
	 * @return ��������ID
	 */
	Long save(BookCase bookCase);
	
	/**
	 * ����IDɾ�����
	 * @param id ����ID
	 */
	void deleteById(Long id);
	
	/**
	 * ����ID�޸����
	 * @param bookCase ������Ҫ�޸ĵ����
	 */
	void updateById(BookCase bookCase);
	
	/**
	 * ����ID��ѯ���
	 * @param id ��������ID
	 * @return �������
	 */
	BookCase queryById(Long id);
	
	/**
	 * ��ѯ����ҳ����
	 * @param page �����ҳ��ѯ��������
	 * @return ��������ҳ����
	 */
	ResponseResult queryPageData(BookCasePage page);
	
	/**
	 * ����������ѯ�����б�
	 * @param param �����ѯ����
	 * @return ������������б�
	 */
	List<BookCase> queryData(Map<String,Object> param);
}
