package com.readbook.dao;

import java.util.List;

import com.readbook.entity.Order;

public interface OrderDao {

	/**
	 * ��Ӷ���
	 * @param order ������Ҫ��ӵĶ���
	 * @return ��������ID
	 */
	Long save(Order order);
	
	
	/**
	 * ����IDɾ��
	 * @param id ��������ID
	 */
	void deleteById(Long id);
	
	
	/**
	 * ����ID�޸�
	 * @param order ������Ҫ�޸ĵĶ���
	 */
	void updateById(Order order);
	
	/**
	 * ����ID��ѯ��������
	 * @param id ���붩��ID
	 * @return ���ض�����Ϣ
	 */
	Order queryById(Long id);
	
	/**
	 * ��ѯ��������
	 * @param sql ����sql���
	 * @param objs �����ѯ����
	 * @return ������������
	 */
	Long selectTotal(String sql,Object... objs);
	
	/**
	 * ��ѯ������ҳ����
	 * @param sql ����sql
	 * @param objs �����ѯ����
	 * @return ���ض�����ҳ�б�
	 */
	List<Order> selectPageData(String sql,Object...objs);
}
