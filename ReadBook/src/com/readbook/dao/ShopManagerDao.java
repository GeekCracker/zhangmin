package com.readbook.dao;

import java.util.List;

import com.readbook.entity.ShopManager;

public interface ShopManagerDao {

	/**
	 * ��ӵ곤
	 * @param shopManager ������Ҫ��ӵĵ곤
	 * @return ��������ID
	 */
	Long save(ShopManager shopManager);
	
	/**
	 * ����IDɾ��
	 * @param id ����곤ID
	 */
	void deleteById(Long id);
	
	/**
	 * ����ID�޸ĵ곤��Ϣ
	 * @param shopManager ������Ҫ�޸ĵĵ곤
	 */
	void updateById(ShopManager shopManager);
	
	/**
	 * ����ID��ѯ�곤
	 * @param id ����곤ID
	 * @return ���ص곤��Ϣ
	 */
	ShopManager selectById(Long id);
	
	/**
	 * ����������ѯ��������
	 * @param sql ����sql���
	 * @param objs ������������
	 * @return ������������
	 */
	Long selectTotal(String sql,Object...objs);
	
	/**
	 * ��ѯ�곤��ҳ����
	 * @param sql ����sql���
	 * @param objs ������������
	 * @return ���ط�ҳ����
	 */
	List<ShopManager> selectPageData(String sql,Object...objs);
}
