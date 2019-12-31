package com.readbook.dao;

import java.util.List;

import com.readbook.entity.Permission;

public interface PermissionDao {
	/**
	 * ���Ȩ��
	 * @param permission ������Ҫ��ӵ�Ȩ��
	 */
	void save(Permission permission);
	
	/**
	 * ����IDɾ��Ȩ��
	 * @param id ����Ȩ��ID
	 */
	void deleteById(Long id);
	
	/**
	 * ����ID�޸�Ȩ��
	 * @param permission ������Ҫ�޸ĵ�Ȩ��
	 */
	void updateById(Permission permission);
	
	
	/**
	 * ��ѯ��������
	 * @param sql ����sql���
	 * @param objs �����ѯ����
	 * @return ������������
	 */
	Long selectTotal(String sql,Object... objs);
	
	/**
	 * ��ѯ��ҳ����
	 * @param sql ����sql���
	 * @param objs �����ѯ����
	 * @return ���ط�ҳ����
	 */
	List<Permission> selectPageData(String sql,Object... objs);
	
	/**
	 * ��ȡ���е�Ȩ��
	 * @return �������е�Ȩ��
	 */
	List<Permission> selectAll();
}
