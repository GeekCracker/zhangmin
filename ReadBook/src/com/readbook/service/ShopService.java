package com.readbook.service;

import java.util.List;

import com.readbook.entity.Shop;
import com.readbook.page.ShopPage;
import com.readbook.response.ResponseResult;

/**
 * �ŵ�Service��
 * @author ����
 */
public interface ShopService {

	/**
	 * ����ŵ�
	 * @param shop ������Ҫ��ӵ��ŵ�
	 */
	void save(Shop shop);
	
	/**
	 * ����IDɾ���ŵ�
	 * @param id �����ŵ�ID
	 */
	void deleteById(Long id);
	
	/**
	 * ����ID�޸��ŵ�
	 * @param shop ������Ҫ�޸ĵ��ŵ�
	 */
	void updateById(Shop shop);
	
	/**
	 * ����ID��ѯ�ŵ���Ϣ
	 * @param id �����ŵ�ID
	 * @return �����ŵ���Ϣ
	 */
	Shop queryById(Long id);
	
	/**
	 * ��ȡ���е��ŵ�
	 * @return �������е��ŵ�
	 */
	List<Shop> queryAll();
	
	/**
	 * ��ȡ�ŵ��ҳ�б�����
	 * @param shopPage �����ѯ�ķ�ҳ����
	 * @return ���ط�ҳ����
	 */
	ResponseResult queryPageData(ShopPage shopPage);
}
