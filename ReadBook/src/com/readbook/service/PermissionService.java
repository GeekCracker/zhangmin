package com.readbook.service;

import java.util.List;

import com.readbook.entity.Permission;
import com.readbook.page.PermissionPage;

public interface PermissionService {

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
	 * ��ȡ��ҳ����
	 * @param page �����ҳ����
	 * @return ���ط�ҳ����
	 */
	PermissionPage queryPageData(PermissionPage page);
	
	/**
	 * ��ȡȨ����
	 * @return ����Ȩ����
	 */
	List<Permission> permissionTree();
}
