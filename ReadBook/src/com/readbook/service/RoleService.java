package com.readbook.service;

import com.readbook.entity.Role;
import com.readbook.page.RolePage;
import com.readbook.response.ResponseResult;

public interface RoleService{
	
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
	 * ����ID�޸Ľ�ɫ��Ϣ
	 * @param role ������Ҫ�޸ĵĽ�ɫ��Ϣ
	 */
	void updateById(Role role);

	
	/**
	 * ��ȡ��ҳ����
	 * @param page �����ҳ����
	 * @return ���ط�ҳ����
	 */
	ResponseResult queryPageData(RolePage page);
}
