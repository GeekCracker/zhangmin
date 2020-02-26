package com.readbook.dao;

import java.util.List;

import com.readbook.entity.Shop;

public interface ShopDao {

	/**
	 * ����ŵ�
	 * @param shop ������Ҫ��ӵ��ŵ�
	 * @return �����ŵ�ID
	 */
	Long addShop(Shop shop);
	
	/**
	 * ����IDɾ��
	 * @param id �����ŵ�ID
	 */
	void deleteById(Long id);
	
	/**
	 * ����ID�޸��ŵ�
	 * @param shop ������Ҫ�޸ĵ��ŵ�
	 */
	void updateById(Shop shop);
	
	/**
	 * ����ID��ѯ
	 * @param id �����ŵ�ID
	 * @return �����ŵ���Ϣ
	 */
	Shop selectById(Long id);
	
	/**
	 * ��ѯ���е��ŵ�
	 * @return �������е��ŵ�
	 */
	List<Shop> selectAll();
	
	/**
	 * ��ȡ��������
	 * @param sql ������װ�õ�SQL���
	 * @param objs �����ѯ����
	 * @return ������������
	 */
	Long selectTotal(String sql,Object...objs);
	
	/**
	 * ��ȡ��ҳ����
	 * @param sql ������װ�õ�SQL���
	 * @param objs �����ѯ����
	 * @return ���ط�ҳ����
	 */
	List<Shop> selectPageData(String sql,Object...objs);
}
