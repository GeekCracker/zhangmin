package com.readbook.dao;

import java.util.List;

import com.readbook.entity.Role;

public interface RoleDao {

	/**
	 * ��ӽ�ɫ
	 * @param role ������Ҫ��ӵĽ�ɫ
	 */
	void save(Role role);
	
	/**
	 * ����IDɾ����ɫ
	 * @param id �����ɫID
	 */
	void deleteById(Long id);
	
	/**
	 * ����ID�޸Ľ�ɫ
	 * @param role ������Ҫ�޸ĵĽ�ɫ
	 */
	void updateById(Role role);
	
	
	/**
	 * ��ѯ��������
	 * @param sql ����sql���
	 * @param objs �����ѯ����
	 * @return ������������
	 */
	Long selectTotal(String sql,Object... objs);
	
	/**
	 * ��ȡ���еĽ�ɫ
	 * @return �������еĽ�ɫ
	 */
	List<Role> selectAll();
	
	/**
	 * ��ѯ��ҳ����
	 * @param sql ����sql���
	 * @param objs �����ѯ����
	 * @return ���ط�ҳ����
	 */
	List<Role> selectPageData(String sql,Object... objs);
}
