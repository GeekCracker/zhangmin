package com.readbook.service;


import com.readbook.entity.Order;
import com.readbook.page.OrderPage;
import com.readbook.response.ResponseResult;

public interface OrderService {

	/**
	 * ��Ӷ���
	 * @param book ������Ҫ��ӵĶ���
	 * @return ��������ID
	 */
	Long save(Order order);
	
	/**
	 * ����IDɾ������
	 * @param id ���붩��ID
	 */
	void deleteById(Long id);

	/**
	 * ����ID�޸Ķ���
	 * @param order ������Ҫ�޸ĵĶ���
	 */
	void updateById(Order order);
	
	/**
	 * ����ID��ѯ����
	 * @param id ���붩��ID
	 * @return ���ض�����Ϣ
	 */
	Order queryById(Long id);

	/**
	 * ��ȡ������ҳ����
	 * @param page �����ҳ��������
	 * @return ���ط�ҳ����
	 */
	ResponseResult queryPageData(OrderPage page);
}
