package com.readbook.dao;

import java.util.List;

import com.readbook.entity.RolePermission;

public interface RolePermissionDao {

	/**
	 * ��ӽ�ɫ��ӦȨ�޼�¼
	 * @param rolePermission ������Ҫ��ӵ�ʵ��
	 * @return ������Ӱ������
	 */
	int save(RolePermission rolePermission);
	/**
	 * ������ӽ�ɫ��ӦȨ��
	 * @param list �����ɫ��ӦȨ�޹���ʵ��
	 * @return ������Ӱ������
	 */
	int saveBatch(List<RolePermission> list);
	
	/**
	 * ���ݽ�ɫIDɾ��
	 * @param roleId �����ɫID
	 * @return ������Ӱ������
	 */
	int deleteByRoleId(Long roleId);
}
